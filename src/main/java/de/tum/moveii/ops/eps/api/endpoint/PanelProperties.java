package de.tum.moveii.ops.eps.api.endpoint;

import de.tum.moveii.ops.eps.battery.model.BatteryState;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
public class PanelProperties {
    private BatteryState state;
    private Integer pageSize = 50;
    private Integer pageIndex = 0;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime since = LocalDateTime.now().minus(Duration.ofDays(7));
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime until = LocalDateTime.now();
}
