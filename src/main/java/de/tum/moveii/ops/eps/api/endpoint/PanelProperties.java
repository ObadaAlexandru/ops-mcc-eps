package de.tum.moveii.ops.eps.api.endpoint;

import com.querydsl.core.types.Predicate;
import de.tum.moveii.ops.eps.battery.model.BatteryState;
import de.tum.moveii.ops.eps.panel.model.PanelState;
import de.tum.moveii.ops.eps.panel.model.QPanel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
@Data
public class PanelProperties {
    private BatteryState state;
    private Integer pageSize = 50;
    private Integer pageIndex = 0;

    private Integer panelId;
    private PanelState panelState;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime since = LocalDateTime.now().minus(Duration.ofDays(7));
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime until = LocalDateTime.now();


    public Predicate buildPredicate() {
        QPanel query = QPanel.panel;
        return null;
    }
}