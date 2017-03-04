package de.tum.moveii.ops.eps.api.mapper;

import de.tum.moveii.ops.eps.api.message.BatteryMessage;
import de.tum.moveii.ops.eps.battery.model.BatteryMeasurement;
import org.springframework.stereotype.Component;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Component
public class BatteryMapper implements ResourceMapper<BatteryMessage, BatteryMeasurement> {
    @Override
    public BatteryMeasurement toResource(BatteryMessage message) {
        return BatteryMeasurement.builder()
                .state(message.getState())
                .level(message.getLevel())
                .createdOn(message.getCreatedOn())
                .build();
    }

    @Override
    public BatteryMessage toMessage(BatteryMeasurement resource) {
        return BatteryMessage.builder()
                .state(resource.getState())
                .level(resource.getLevel())
                .createdOn(resource.getCreatedOn())
                .build();
    }
}
