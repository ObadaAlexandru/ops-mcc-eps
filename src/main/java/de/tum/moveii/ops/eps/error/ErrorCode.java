package de.tum.moveii.ops.eps.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Alexandru Obada on 12/05/16.
 */

/**
 * Used mainly for logging purpose, better exception identification
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    BATTERY_LOG_NOT_FOUND("EPS-001", "Battery measurement not found"),
    PANEL_MEASUREMENT_NOT_FOUND("EPS-002", "Panel measurement not found");

    private String code;
    private String defaultMessage;
}
