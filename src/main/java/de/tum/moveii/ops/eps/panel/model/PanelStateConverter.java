package de.tum.moveii.ops.eps.panel.model;

import javax.persistence.AttributeConverter;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
public class PanelStateConverter implements AttributeConverter<PanelState, String> {
    @Override
    public String convertToDatabaseColumn(PanelState panelState) {
        switch (panelState) {
            case NORMAL:
                return "N";
            case WARNING:
                return "W";
            default:
                throw new IllegalArgumentException("<PanelState> Unknown attribute " + panelState);
        }
    }

    @Override
    public PanelState convertToEntityAttribute(String s) {
        switch (s) {
            case "N":
                return PanelState.NORMAL;
            case "W":
                return PanelState.WARNING;
            default:
                throw new IllegalArgumentException("<PanelState> Unknown entity " + s);
        }
    }
}
