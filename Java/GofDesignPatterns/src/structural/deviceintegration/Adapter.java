package structural.deviceintegration;

import creational.devicemanagement.devices.Device;

/**
 * Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
 * The Adapter acts as a wrapper for an object and provides a compatible interface.
 */
public class Adapter {
    public static class OldThermostat {
        public void heatOn() {
            System.out.println("Old Thermostat is heating.");
        }
    }

    public static class ThermostatAdapter implements Device {
        private OldThermostat oldThermostat;

        public ThermostatAdapter(OldThermostat oldThermostat) {
            this.oldThermostat = oldThermostat;
        }

        @Override
        public void turnOn() {
            oldThermostat.heatOn();
        }

        @Override
        public void turnOff() {
            System.out.println("Old Thermostat is OFF");
        }
    }
}
