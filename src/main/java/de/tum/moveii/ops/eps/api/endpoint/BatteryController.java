package de.tum.moveii.ops.eps.api.endpoint;

import de.tum.moveii.ops.eps.api.mapper.BatteryMapper;
import de.tum.moveii.ops.eps.api.message.BatteryMessage;
import de.tum.moveii.ops.eps.api.message.ErrorMessage;
import de.tum.moveii.ops.eps.battery.model.BatteryMeasurement;
import de.tum.moveii.ops.eps.battery.service.BatteryService;
import de.tum.moveii.ops.eps.error.BatteryMeasurementNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Alexandru Obada on 04/03/17.
 */
@Slf4j
@RestController
@RequestMapping("/eps/battery")
public class BatteryController {
    private BatteryService batteryService;
    private BatteryMapper batteryMapper;

    @Autowired
    public BatteryController(BatteryService batteryService, BatteryMapper batteryMapper) {
        this.batteryService = batteryService;
        this.batteryMapper = batteryMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public BatteryMessage createBatteryLog(@Valid @RequestBody BatteryMessage batteryLogMessage) {
        BatteryMeasurement battery = batteryService.create(batteryMapper.toResource(batteryLogMessage));
        return batteryMapper.toMessage(battery);
    }

    @GetMapping(value = "/{registrationId}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public BatteryMessage getBatteryLog(@PathVariable Long registrationId) {
        return batteryService.getBatteryLog(registrationId)
                .map(batteryMapper::toMessage)
                .orElseThrow(() -> new BatteryMeasurementNotFound("Battery measurement <%s> not found"));
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<BatteryMessage> getBatteryLogs(BatteryProperties batteryLogProperties) {
        List<BatteryMeasurement> batteryLogs = batteryService.getBatteryLogs(batteryLogProperties.buildPredicate(),
                new PageRequest(batteryLogProperties.getPageIndex(), batteryLogProperties.getPageSize()));
        return batteryLogs.stream()
                .map(batteryMapper::toMessage)
                .collect(Collectors.toList());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(BatteryMeasurementNotFound.class)
    public ErrorMessage handleBatteryLogNotFound(BatteryMeasurementNotFound batteryLogNotFound) {
        log.warn(batteryLogNotFound.toString());
        return new ErrorMessage(batteryLogNotFound.toString());
    }
}