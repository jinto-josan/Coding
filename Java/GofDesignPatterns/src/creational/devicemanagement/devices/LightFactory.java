package creational.devicemanagement.devices;

public class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Light();
    }
}
