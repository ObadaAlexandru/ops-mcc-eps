package de.tum.moveii.ops.eps.error;

import lombok.NonNull;

import static de.tum.moveii.ops.eps.error.ErrorCode.BATTERY_LOG_NOT_FOUND;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
public class BatteryLogNotFound extends BaseException {
    BatteryLogNotFound(@NonNull String message) {
        super(BATTERY_LOG_NOT_FOUND, message);
    }
}
