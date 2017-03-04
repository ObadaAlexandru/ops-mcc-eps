package de.tum.moveii.ops.eps.api.endpoint;

import de.tum.moveii.ops.eps.api.mapper.PanelMapper;
import de.tum.moveii.ops.eps.api.message.ErrorMessage;
import de.tum.moveii.ops.eps.api.message.PanelMessage;
import de.tum.moveii.ops.eps.error.PanelMeasurementNotFound;
import de.tum.moveii.ops.eps.panel.model.PanelMeasurement;
import de.tum.moveii.ops.eps.panel.service.PanelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
@Slf4j
@RestController
@RequestMapping("/eps/panels")
public class PanelController {
    private PanelService panelService;
    private PanelMapper panelMapper;

    @Autowired
    public PanelController(PanelService panelService, PanelMapper panelMapper) {
        this.panelService = panelService;
        this.panelMapper = panelMapper;
    }

    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public PanelMessage createMeasurement(@RequestBody PanelMessage panelMessage) {
        PanelMeasurement panelMeasurement = panelService.create(panelMapper.toResource(panelMessage));
        return panelMapper.toMessage(panelMeasurement);
    }

    @ResponseStatus(OK)
    @GetMapping(value = "/{registrationId}", produces = APPLICATION_JSON_VALUE)
    public PanelMessage getMeasurement(@PathVariable Long registrationId) {
        return panelService.getPanelMeasurement(registrationId)
                .map(panelMapper::toMessage)
                .orElseThrow(() -> new PanelMeasurementNotFound(String.format("Panel measurement <%s> not found", registrationId)));
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(PanelMeasurementNotFound.class)
    public ErrorMessage handleBatteryLogNotFound(PanelMeasurementNotFound panelMeasurementNotFound) {
        log.warn(panelMeasurementNotFound.toString());
        return new ErrorMessage(panelMeasurementNotFound.toString());
    }
}
