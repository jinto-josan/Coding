package creational.devicemanagement.smarthome;

public class SmartHome {
    private String lights;
    private String thermostat;
    private String security;

    public void setLights(String lights) {
        this.lights = lights;
    }

    public void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    @Override
    public String toString() {
        return "SmartHome [lights=" + lights + ", thermostat=" + thermostat + ", security=" + security + "]";
    }
}
