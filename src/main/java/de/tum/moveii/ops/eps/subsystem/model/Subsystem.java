package de.tum.moveii.ops.eps.subsystem.model;

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
@Table(name = "SUBSYSTEMS", schema = "EPS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Subsystem {
    @Id
    @SequenceGenerator(name = "subsystems_reg_id_seq",
            sequenceName = "subsystems_reg_id_seq",
            schema = "EPS",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REG_ID", nullable = false, updatable = false)
    private Long registrationId;

    @Column(name = "SUBSYSTEM", nullable = false)
    @Convert(converter = BatteryStateConverter.class)
    private String subsystem;

    @Column(name = "STATE", nullable = false)
    @Convert(converter = BatteryStateConverter.class)
    private SubsystemState state;

    @Column(name = "EXPECTED_STATE", nullable = false)
    @Convert(converter = BatteryStateConverter.class)
    private SubsystemState expectedState;

    @Column(name = "CURRENT", nullable = false)
    private Double current;

    @Column(name = "VOLTAGE", nullable = false)
    private Double voltage;

    @Column(name = "CREATED_ON", nullable = false)
    private LocalDateTime createdOn;
}
