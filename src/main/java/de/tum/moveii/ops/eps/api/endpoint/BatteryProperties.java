package de.tum.moveii.ops.eps.api.endpoint;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import de.tum.moveii.ops.eps.battery.model.BatteryState;
import de.tum.moveii.ops.eps.battery.model.QBatteryLog;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
@Data
public class BatteryProperties {
    private BatteryState state;
    private Integer pageSize = 50;
    private Integer pageIndex = 0;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime since = LocalDateTime.now().minus(Duration.ofDays(7));
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime until = LocalDateTime.now();

    public Predicate buildPredicate() {
        QBatteryLog batteryLogQuery = QBatteryLog.batteryLog;
        BooleanExpression booleanExpression = batteryLogQuery.createdOn.gt(since)
                .and(batteryLogQuery.createdOn.lt(until));
        return null == state ? booleanExpression : booleanExpression
                .and(batteryLogQuery.state.eq(state));
    }
}
