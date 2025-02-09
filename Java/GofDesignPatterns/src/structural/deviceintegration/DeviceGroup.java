package structural.deviceintegration;

import creational.devicemanagement.devices.Device;

/**
 * DeviceGroup is a composite device that groups multiple devices. It helps to treat devices and group of devices uniformly
 */
public class DeviceGroup implements Device {
    private Device[] devices;

    public DeviceGroup(Device[] devices) {
        this.devices = devices;
    }



    @Override
    public void turnOn() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }
}
