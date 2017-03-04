package de.tum.moveii.ops.eps.api.mapper;

import de.tum.moveii.ops.eps.api.message.PanelMessage;
import de.tum.moveii.ops.eps.panel.model.Panel;
import org.springframework.stereotype.Component;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
@Component
public class PanelMapper implements ResourceMapper<PanelMessage, Panel> {
    @Override
    public Panel toResource(PanelMessage message) {
        return Panel.builder()
                .panelId(message.getPanelId())
                .state(message.getState())
                .current(message.getCurrent())
                .voltage(message.getVoltage())
                .createdOn(message.getCreatedOn())
                .build();
    }

    @Override
    public PanelMessage toMessage(Panel resource) {
        return PanelMessage.builder()
                .panelId(resource.getPanelId())
                .state(resource.getState())
                .current(resource.getCurrent())
                .voltage(resource.getVoltage())
                .createdOn(resource.getCreatedOn())
                .build();
    }
}
