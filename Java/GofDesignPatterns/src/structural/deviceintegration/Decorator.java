package structural.deviceintegration;

import creational.devicemanagement.devices.Device;

/**
 * Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the new behaviors.
 */
public class Decorator {
    /**
     * DeviceDecorator is a decorator for Device. It helps to add additional functionality to a device
     */
    abstract static class DeviceDecorator implements Device {
        protected Device decoratedDevice;

        public DeviceDecorator(Device decoratedDevice) {
            this.decoratedDevice = decoratedDevice;
        }

        @Override
        public void turnOn() {
            decoratedDevice.turnOn();
        }

        @Override
        public void turnOff() {
            decoratedDevice.turnOff();
        }
    }

    public static class TimedDevice extends DeviceDecorator {
        public TimedDevice(Device decoratedDevice) {
            super(decoratedDevice);
        }

        @Override
        public void turnOn() {
            super.turnOn();
            System.out.println("Device will turn off in 10 minutes.");
        }
    }
}
