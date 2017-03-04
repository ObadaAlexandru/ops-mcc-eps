package de.tum.moveii.ops.eps.battery.service;

import com.querydsl.core.types.Predicate;
import de.tum.moveii.ops.eps.battery.model.BatteryMeasurement;
import lombok.NonNull;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

/**
 * Created by Alexandru Obada on 04/03/17.
 */
public interface BatteryService {
    BatteryMeasurement create(@NonNull BatteryMeasurement batteryLog);
    Optional<BatteryMeasurement> getBatteryLog(@NonNull Long registrationId);
    List<BatteryMeasurement> getBatteryLogs(Predicate predicate, PageRequest pageRequest);
    BatteryMeasurement getLatestBatteryLog();
}
