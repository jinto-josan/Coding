package structural.deviceintegration;

import creational.devicemanagement.devices.Device;
import creational.devicemanagement.devices.Light;

/**
 * SecureDeviceProxy is a proxy that controls access to the real device.
 */
public class SecureDeviceProxy implements Device {
    private Device realDevice;
    private String password;

    public SecureDeviceProxy(String password) {
        this.password = password;
    }

    @Override
    public void turnOn() {
        if (authenticate()) {
            if (realDevice == null) {
                realDevice = new Light();
            }
            realDevice.turnOn();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void turnOff() {
        if (authenticate()) {
            if (realDevice == null) {
                realDevice = new Light();
            }
            realDevice.turnOff();
        } else {
            System.out.println("Access denied!");
        }
    }

    private boolean authenticate() {
        return "1234".equals(password);
    }
}
