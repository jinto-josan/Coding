package structural.deviceintegration;

import creational.devicemanagement.devices.Device;

/**
 * SmartHomeFacade is a facade that provides a simple interface to the complex subsystem of devices.
 */
public class SmartHomeFacade {
    private Device light;
    private Device thermostat;

    public SmartHomeFacade(Device light, Device thermostat) {
        this.light = light;
        this.thermostat = thermostat;
    }

    public void startEveningRoutine() {
        System.out.println("Starting evening routine...");
        light.turnOn();
        thermostat.turnOn();
    }

    public void stopEveningRoutine() {
        System.out.println("Stopping evening routine...");
        light.turnOff();
        thermostat.turnOff();
    }
}
