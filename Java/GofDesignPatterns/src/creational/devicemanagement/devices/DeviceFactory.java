package creational.devicemanagement.devices;

public abstract class DeviceFactory {

    /**
     * Factory method to create a device
     * @return
     */
    public abstract Device createDevice();
    public void setupDevice(Device device) {
        device.turnOn();
    }
}
