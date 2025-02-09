package creational.devicemanagement.devices;

public class ThermostatFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Thermostat();
    }
}
