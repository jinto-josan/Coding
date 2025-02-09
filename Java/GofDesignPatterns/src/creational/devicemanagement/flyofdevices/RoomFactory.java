package creational.devicemanagement.flyofdevices;

import creational.devicemanagement.devices.Device;

public interface RoomFactory {
    Device createLight();
    Device createThermostat();
}
