package de.tum.moveii.ops.eps.api.mapper;

import de.tum.moveii.ops.eps.api.message.PanelMessage;
import de.tum.moveii.ops.eps.panel.model.PanelMeasurement;
import org.springframework.stereotype.Component;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Component
public class PanelMapper implements ResourceMapper<PanelMessage, PanelMeasurement> {
    @Override
    public PanelMeasurement toResource(PanelMessage message) {
        return PanelMeasurement.builder()
                .panelId(message.getPanelId())
                .state(message.getState())
                .current(message.getCurrent())
                .voltage(message.getVoltage())
                .createdOn(message.getCreatedOn())
                .build();
    }

    @Override
    public PanelMessage toMessage(PanelMeasurement resource) {
        return PanelMessage.builder()
                .panelId(resource.getPanelId())
                .state(resource.getState())
                .current(resource.getCurrent())
                .voltage(resource.getVoltage())
                .createdOn(resource.getCreatedOn())
                .build();
    }
}
