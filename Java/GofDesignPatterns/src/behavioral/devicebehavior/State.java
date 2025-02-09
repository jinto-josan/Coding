package behavioral.devicebehavior;

/**
 * State is a behavioral design pattern that lets an object alter its behavior when its internal state changes.
 * This pattern is close to the concept of finite-state machines.
 */
public class State {
    interface DeviceState {
        void handle();
    }

    public static class OnState implements DeviceState {
        @Override
        public void handle() {
            System.out.println("Device is ON");
        }
    }

    class OffState implements DeviceState {
        @Override
        public void handle() {
            System.out.println("Device is OFF");
        }
    }

    public static class DeviceContext {
        private DeviceState state;

        public void setState(DeviceState state) {
            this.state = state;
        }

        public void request() {
            state.handle();
        }
    }
}
