package de.tum.moveii.ops.eps.error;

import lombok.NonNull;

import static de.tum.moveii.ops.eps.error.ErrorCode.PANEL_MEASUREMENT_NOT_FOUND;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
public class PanelMeasurementNotFound extends BaseException {
    public PanelMeasurementNotFound(@NonNull String message) {
        super(PANEL_MEASUREMENT_NOT_FOUND, message);
    }
}
