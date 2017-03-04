package de.tum.moveii.ops.eps.api.mapper;

import de.tum.moveii.ops.eps.api.message.BatteryLogMessage;
import de.tum.moveii.ops.eps.battery.model.BatteryLog;
import org.springframework.stereotype.Component;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Component
public class BatteryMapper implements ResourceMapper<BatteryLogMessage, BatteryLog> {
    @Override
    public BatteryLog toResource(BatteryLogMessage message) {
        return BatteryLog.builder()
                .state(message.getState())
                .level(message.getLevel())
                .createdOn(message.getCreatedOn())
                .build();
    }

    @Override
    public BatteryLogMessage toMessage(BatteryLog resource) {
        return BatteryLogMessage.builder()
                .state(resource.getState())
                .level(resource.getLevel())
                .createdOn(resource.getCreatedOn())
                .build();
    }
}
