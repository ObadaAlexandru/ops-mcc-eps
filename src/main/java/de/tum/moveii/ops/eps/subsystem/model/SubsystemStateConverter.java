package de.tum.moveii.ops.eps.subsystem.model;

import javax.persistence.AttributeConverter;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
public class SubsystemStateConverter implements AttributeConverter<SubsystemState, String> {
    @Override
    public String convertToDatabaseColumn(SubsystemState subsystemState) {
        switch (subsystemState) {
            case ON:
                return "1";
            case OFF:
                return "0";
            default:
                throw new IllegalArgumentException("<SubsystemState> Unknown attribute " + subsystemState);
        }
    }

    @Override
    public SubsystemState convertToEntityAttribute(String s) {
        switch (s) {
            case "1":
                return SubsystemState.ON;
            case "0":
                return SubsystemState.OFF;
            default:
                throw new IllegalArgumentException("<SubsystemState> Unknown entity " + s);
        }
    }
}
