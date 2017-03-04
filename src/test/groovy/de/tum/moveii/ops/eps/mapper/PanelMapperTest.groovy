package de.tum.moveii.ops.eps.mapper

import de.tum.moveii.ops.eps.api.mapper.PanelMapper
import de.tum.moveii.ops.eps.api.message.PanelMessage
import de.tum.moveii.ops.eps.panel.model.PanelMeasurement
import de.tum.moveii.ops.eps.panel.model.PanelMeasurement
import de.tum.moveii.ops.eps.panel.model.PanelState
import spock.lang.Specification

import java.time.LocalDateTime

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
class PanelMapperTest extends Specification {
    def panelMapper = new PanelMapper()

    def 'Map panel to panelMessage'() {
        given:

        def panel = PanelMeasurement.builder()
                .panelId(1)
                .state(PanelState.NORMAL)
                .current(5.2)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()


        def panelMessage = PanelMessage.builder()
                .panelId(1)
                .state(PanelState.NORMAL)
                .current(5.2)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()

        when:
        def actualPanelMessage = panelMapper.toMessage(panel)
        then:
        actualPanelMessage == panelMessage
    }

    def 'Map panelMessage to panel'() {
        given:
        def panel = PanelMeasurement.builder()
                .panelId(1)
                .state(PanelState.NORMAL)
                .current(5.2)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()


        def panelMessage = PanelMessage.builder()
                .panelId(1)
                .state(PanelState.NORMAL)
                .current(5.2)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()
        when:
        def actualPanel = panelMapper.toResource(panelMessage)
        then:
        actualPanel == panel
    }

    def 'Null panel'() {
        when:
        panelMapper.toMessage(null)
        then:
        thrown(NullPointerException)
    }

    def 'Null panelMessage'() {
        when:
        panelMapper.toResource(null)
        then:
        thrown(NullPointerException)
    }
}