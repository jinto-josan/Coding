package creational.devicemanagement.devices;

public class Thermostat  implements Device{
    private String status = "OFF";

    @Override
    public void turnOn() {
        status = "ON";
        System.out.println("Thermostat is ON");
    }

    @Override
    public void turnOff() {
        status = "OFF";
        System.out.println("Thermostat is OFF");
    }
}
