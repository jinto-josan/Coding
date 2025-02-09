package creational.devicemanagement.smarthome;

public class SmartHomeBuilder {
    private SmartHome smartHome;

    public SmartHomeBuilder() {
        smartHome = new SmartHome();
    }

    public SmartHomeBuilder setLights(String lights) {
        smartHome.setLights(lights);
        return this;
    }

    public SmartHomeBuilder setThermostat(String thermostat) {
        smartHome.setThermostat(thermostat);
        return this;
    }

    public SmartHomeBuilder setSecurity(String security) {
        smartHome.setSecurity(security);
        return this;
    }

    public SmartHome build() {
        return smartHome;
    }
}
