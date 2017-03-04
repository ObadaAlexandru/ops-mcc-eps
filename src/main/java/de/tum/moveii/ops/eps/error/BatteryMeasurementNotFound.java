package de.tum.moveii.ops.eps.error;

import lombok.NonNull;

import static de.tum.moveii.ops.eps.error.ErrorCode.BATTERY_LOG_NOT_FOUND;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
public class BatteryMeasurementNotFound extends BaseException {
    public BatteryMeasurementNotFound(@NonNull String message) {
        super(BATTERY_LOG_NOT_FOUND, message);
    }
}
