package de.tum.moveii.ops.eps.mapper

import de.tum.moveii.ops.eps.api.mapper.SubsystemMapper
import de.tum.moveii.ops.eps.api.message.SubsystemMessage
import de.tum.moveii.ops.eps.subsystem.model.Subsystem
import de.tum.moveii.ops.eps.subsystem.model.SubsystemState
import spock.lang.Specification

import java.time.LocalDateTime

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
class SubsystemMapperTest extends Specification {
    def subsystemMapper = new SubsystemMapper()

    def 'Map subsystem to subsystemMessage'() {
        given:

        def subsystem = Subsystem.builder()
                .subsystem("COM")
                .state(SubsystemState.ON)
                .expectedState(SubsystemState.ON)
                .current(3.0)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()


        def subsystemMessage = SubsystemMessage.builder()
                .subsystem("COM")
                .state(SubsystemState.ON)
                .expectedState(SubsystemState.ON)
                .current(3.0)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()

        when:
        def actualSubsystemMessage = subsystemMapper.toMessage(subsystem)
        then:
        actualSubsystemMessage == subsystemMessage
    }

    def 'Map subsystemMessage to subsystem'() {
        given:
        def subsystem = Subsystem.builder()
                .subsystem("COM")
                .state(SubsystemState.ON)
                .expectedState(SubsystemState.ON)
                .current(3.0)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()


        def subsystemMessage = SubsystemMessage.builder()
                .subsystem("COM")
                .state(SubsystemState.ON)
                .expectedState(SubsystemState.ON)
                .current(3.0)
                .voltage(5.0)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()
        when:
        def actualSubsystem = subsystemMapper.toResource(subsystemMessage)
        then:
        actualSubsystem == subsystem
    }

    def 'Null subsystem'() {
        when:
        subsystemMapper.toMessage(null)
        then:
        thrown(NullPointerException)
    }

    def 'Null subsystemMessage'() {
        when:
        subsystemMapper.toResource(null)
        then:
        thrown(NullPointerException)
    }
}