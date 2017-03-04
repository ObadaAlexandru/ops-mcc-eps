package de.tum.moveii.ops.eps.battery.service;

import com.querydsl.core.types.Predicate;
import de.tum.moveii.ops.eps.battery.model.BatteryLog;
import lombok.NonNull;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

/**
 * Created by Alexandru Obada on 04/03/17.
 */
public interface BatteryService {
    BatteryLog create(@NonNull BatteryLog batteryLog);
    Optional<BatteryLog> getBatteryLog(@NonNull Long registrationId);
    List<BatteryLog> getBatteryLogs(Predicate predicate, PageRequest pageRequest);
    BatteryLog getLatestBatteryLog();
}
