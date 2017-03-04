package de.tum.moveii.ops.eps.panel.model;

import de.tum.moveii.ops.eps.battery.model.BatteryStateConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Entity
@Table(name = "PANELS", schema = "EPS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Panel {
    @Id
    @SequenceGenerator(name = "panels_reg_id_seq",
            sequenceName = "panels_reg_id_seq",
            schema = "EPS",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REG_ID", nullable = false, updatable = false)
    private Long registrationId;

    @Column(name = "PANEL_ID", nullable = false)
    private Integer panelId;

    @Column(name = "STATE", nullable = false)
    @Convert(converter = BatteryStateConverter.class)
    private PanelState state;

    @Column(name = "CURRENT", nullable = false)
    private Double current;

    @Column(name = "VOLTAGE", nullable = false)
    private Double voltage;

    @Column(name = "CREATED_ON", nullable = false)
    private LocalDateTime createdOn;
}
