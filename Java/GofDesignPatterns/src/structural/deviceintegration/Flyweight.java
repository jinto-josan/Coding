package structural.deviceintegration;

/**
 * Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing
 * common parts of state between multiple objects, instead of keeping all of the data in each object.
 */
public class Flyweight {
    public static class DeviceState {
        private final String state;

        public DeviceState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public static class DeviceFlyweight {
        private DeviceState state;

        public DeviceFlyweight(DeviceState state) {
            this.state = state;
        }

        public void operate() {
            System.out.println("Device is in state: " + state.getState());
        }
    }
}
