package behavioral.devicebehavior;

/**
 * Template is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.
 * This pattern is close to the concept of inheritance.
 */
public class Template {
    public static abstract class DeviceSetup {
        public final void setup() {
            powerOn();
            configure();
            test();
        }

        protected abstract void powerOn();
        protected abstract void configure();
        protected abstract void test();
    }

    public static class LightSetup extends DeviceSetup {
        @Override
        protected void powerOn() {
            System.out.println("Light: Powering on...");
        }

        @Override
        protected void configure() {
            System.out.println("Light: Configuring...");
        }

        @Override
        protected void test() {
            System.out.println("Light: Testing...");
        }
    }
}
