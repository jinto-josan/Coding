package creational.devicemanagement;

public class Prototype {
    abstract static class DevicePrototype implements Cloneable {
        public abstract DevicePrototype clone();
    }

    public static class AdvancedLight extends DevicePrototype {
        @Override
        public AdvancedLight clone() {
            return new AdvancedLight();
        }

        public void turnOn() {
            System.out.println("Advanced Light is ON");
        }
    }

}
