package de.tum.moveii.ops.eps.api.mapper;

import de.tum.moveii.ops.eps.api.message.BatteryMessage;
import de.tum.moveii.ops.eps.battery.model.Battery;
import org.springframework.stereotype.Component;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Component
public class BatteryMapper implements ResourceMapper<BatteryMessage, Battery> {
    @Override
    public Battery toResource(BatteryMessage message) {
        return Battery.builder()
                .state(message.getState())
                .level(message.getLevel())
                .createdOn(message.getCreatedOn())
                .build();
    }

    @Override
    public BatteryMessage toMessage(Battery resource) {
        return BatteryMessage.builder()
                .state(resource.getState())
                .level(resource.getLevel())
                .createdOn(resource.getCreatedOn())
                .build();
    }
}
