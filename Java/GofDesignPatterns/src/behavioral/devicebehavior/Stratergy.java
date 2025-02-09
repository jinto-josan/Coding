package behavioral.devicebehavior;

/**
 * Stratergy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.
 * This pattern lets the algorithm vary independently from clients that use it.
 */
public class Stratergy {
    interface HeatingStrategy {
        void heat();
    }

    public static class EcoHeating implements HeatingStrategy {
        @Override
        public void heat() {
            System.out.println("Eco heating: Saving energy.");
        }
    }

    class ComfortHeating implements HeatingStrategy {
        @Override
        public void heat() {
            System.out.println("Comfort heating: Maximum warmth.");
        }
    }

    public static class ThermostatContext {
        private HeatingStrategy strategy;

        public void setStrategy(HeatingStrategy strategy) {
            this.strategy = strategy;
        }

        public void executeStrategy() {
            strategy.heat();
        }
    }
}
