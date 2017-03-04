package de.tum.moveii.ops.eps.mapper;

import de.tum.moveii.ops.eps.api.mapper.BatteryMapper;
import de.tum.moveii.ops.eps.api.message.BatteryMessage;
import de.tum.moveii.ops.eps.battery.model.BatteryMeasurement
import de.tum.moveii.ops.eps.battery.model.BatteryMeasurement
import de.tum.moveii.ops.eps.battery.model.BatteryMeasurement
import de.tum.moveii.ops.eps.battery.model.BatteryState;
import spock.lang.Specification;

import java.time.LocalDateTime;

/**
 * Created by Constantin Costescu on 04-Mar-17.
 */
class BatteryMapperTest extends Specification {
    def batteryMapper = new BatteryMapper()

    def 'Map battery to batteryMessage'() {
        given:

        def battery = BatteryMeasurement.builder()
                .state(BatteryState.CHARGING)
                .level(73)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()


        def batteryMessage = BatteryMessage.builder()
                .state(BatteryState.CHARGING)
                .level(73)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()

        when:
        def actualBatteryMessage = batteryMapper.toMessage(battery)
        then:
        actualBatteryMessage == batteryMessage
    }

    def 'Map batteryMessage to battery'() {
        given:
        def battery = BatteryMeasurement.builder()
                .state(BatteryState.CHARGING)
                .level(73)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()


        def batteryMessage = BatteryMessage.builder()
                .state(BatteryState.CHARGING)
                .level(73)
                .createdOn(LocalDateTime.of(2016, 2, 19, 10, 35, 30))
                .build()
        when:
        def actualBattery = batteryMapper.toResource(batteryMessage)
        then:
        actualBattery == battery
    }

    def 'Null battery'() {
        when:
        batteryMapper.toMessage(null)
        then:
        thrown(NullPointerException)
    }

    def 'Null batteryMessage'() {
        when:
        batteryMapper.toResource(null)
        then:
        thrown(NullPointerException)
    }
}
