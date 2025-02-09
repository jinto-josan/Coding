package creational.devicemanagement.flyofdevices;

import creational.devicemanagement.devices.Device;
import creational.devicemanagement.devices.Light;
import creational.devicemanagement.devices.Thermostat;

public class BedroomFactory implements RoomFactory {
    @Override
    public Device createLight() {
        return new Light();
    }

    @Override
    public Device createThermostat() {
        return new Thermostat();
    }
}
