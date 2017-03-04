package de.tum.moveii.ops.eps.battery.model;

import javax.persistence.AttributeConverter;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
public class BatteryStateConverter implements AttributeConverter<BatteryState, String> {
    @Override
    public String convertToDatabaseColumn(BatteryState batteryState) {
        switch (batteryState) {
            case CHARGING:
                return "C";
            case DISCHARGING:
                return "D";
            default:
                throw new IllegalArgumentException("<BatteryState> Unknown attribute " + batteryState);
        }
    }

    @Override
    public BatteryState convertToEntityAttribute(String s) {
        switch (s) {
            case "C":
                return BatteryState.CHARGING;
            case "D":
                return BatteryState.DISCHARGING;
            default:
                throw new IllegalArgumentException("<BatteryState> Unknown entity " + s);
        }
    }
}
