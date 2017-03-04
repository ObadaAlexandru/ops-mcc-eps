package de.tum.moveii.ops.eps.panel.service;

import com.querydsl.core.types.Predicate;
import de.tum.moveii.ops.eps.panel.model.PanelMeasurement;
import lombok.NonNull;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

/**
 * Created by Alexandru Obada on 05/03/17.
 */
public interface PanelService {
    PanelMeasurement create(@NonNull PanelMeasurement panelLog);
    Optional<PanelMeasurement> getPanelMeasurement(@NonNull Long registrationId);
    List<PanelMeasurement> getPanelMeasurements(@NonNull Predicate predicate, @NonNull PageRequest pageRequest);
}
