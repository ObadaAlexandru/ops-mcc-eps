package de.tum.moveii.ops.eps.api.mapper;

import de.tum.moveii.ops.eps.api.message.SubsystemMessage;
import de.tum.moveii.ops.eps.subsystem.model.Subsystem;
import org.springframework.stereotype.Component;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Component
public class SubsystemMapper implements ResourceMapper<SubsystemMessage, Subsystem> {
    @Override
    public Subsystem toResource(SubsystemMessage message) {
        return Subsystem.builder()
                .subsystem(message.getSubsystem())
                .state(message.getState())
                .expectedState(message.getExpectedState())
                .current(message.getCurrent())
                .voltage(message.getVoltage())
                .createdOn(message.getCreatedOn())
                .build();
    }

    @Override
    public SubsystemMessage toMessage(Subsystem resource) {
        return SubsystemMessage.builder()
                .subsystem(resource.getSubsystem())
                .state(resource.getState())
                .expectedState(resource.getExpectedState())
                .current(resource.getCurrent())
                .voltage(resource.getVoltage())
                .createdOn(resource.getCreatedOn())
                .build();
    }
}
