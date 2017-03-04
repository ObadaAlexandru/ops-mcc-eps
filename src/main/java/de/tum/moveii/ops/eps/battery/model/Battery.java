package de.tum.moveii.ops.eps.battery.model;

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
@Table(name = "BATTERY", schema = "EPS")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Battery {
    @Id
    @SequenceGenerator(name = "battery_reg_id_seq",
            sequenceName = "battery_reg_id_seq",
            schema = "EPS",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "REG_ID", nullable = false, updatable = false)
    private Long registrationId;

    @Column(name = "STATE", nullable = false)
    @Convert(converter = BatteryStateConverter.class)
    private BatteryState state;

    @Column(name = "LEVEL", nullable = false)
    private Integer level;

    @Column(name = "CREATED_ON", nullable = false)
    private LocalDateTime createdOn;
}
