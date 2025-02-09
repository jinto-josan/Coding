package behavioral.devicebehavior;

import creational.devicemanagement.devices.Device;

/**
 * SmartHomeMediator is a mediator that encapsulates how a set of devices interact with each other.
 */
public class SmartHomeMediator {
    private Device light;
    private Device thermostat;

    public SmartHomeMediator(Device light, Device thermostat) {
        this.light = light;
        this.thermostat = thermostat;
    }

    public void turnOnAllDevices() {
        light.turnOn();
        thermostat.turnOn();
    }

    public void turnOffAllDevices() {
        light.turnOff();
        thermostat.turnOff();
    }
}
