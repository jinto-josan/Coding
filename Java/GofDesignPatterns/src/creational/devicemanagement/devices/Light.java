package creational.devicemanagement.devices;

public class Light implements Device{
    private String status = "OFF";

    @Override
    public void turnOn() {
        status = "ON";
        System.out.println("Light is ON");
    }

    @Override
    public void turnOff() {
        status = "OFF";
        System.out.println("Light is OFF");
    }
}
