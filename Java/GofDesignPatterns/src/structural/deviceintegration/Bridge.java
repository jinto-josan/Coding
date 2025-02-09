package structural.deviceintegration;

/**
 * Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two
 * separate hierarchies—abstraction and implementation—which can be developed independently of each other.
 */
public class Bridge {
    public interface DeviceImplementation {
        void turnOn();
        void turnOff();
    }

    public static class LightImplementation implements DeviceImplementation {
        @Override
        public void turnOn() {
            System.out.println("Light is ON");
        }

        @Override
        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    public static abstract class DeviceControl {
        protected DeviceImplementation implementation;

        public DeviceControl(DeviceImplementation implementation) {
            this.implementation = implementation;
        }

        public abstract void turnOn();
        public abstract void turnOff();
    }

    /**
     * RemoteControl is a bridge between DeviceControl and DeviceImplementation
     */

    public static class RemoteControl extends DeviceControl {
        public RemoteControl(DeviceImplementation implementation) {
            super(implementation);
        }

        @Override
        public void turnOn() {
            implementation.turnOn();
        }

        @Override
        public void turnOff() {
            implementation.turnOff();
        }
    }
}
