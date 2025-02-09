package behavioral.devicebehavior;

/**
 * ChainOfResponsibility is a behavioral design pattern that lets you pass requests along a chain of handlers.
 */
public class ChainOfResponsibility {
    public static abstract class DeviceHandler {
        private DeviceHandler nextHandler;

        public void setNextHandler(DeviceHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public void handleRequest(String request) {
            if (canHandle(request)) {
                processRequest(request);
            } else if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }

        protected abstract boolean canHandle(String request);
        protected abstract void processRequest(String request);
    }

    public static class LightHandler extends DeviceHandler {
        @Override
        protected boolean canHandle(String request) {
            return request.equals("TurnOnLight") || request.equals("TurnOffLight");
        }

        @Override
        protected void processRequest(String request) {
            System.out.println("LightHandler: Processing " + request);
        }
    }

    public static class ThermostatHandler extends DeviceHandler {
        @Override
        protected boolean canHandle(String request) {
            return request.equals("TurnOnThermostat") || request.equals("TurnOffThermostat");
        }

        @Override
        protected void processRequest(String request) {
            System.out.println("ThermostatHandler: Processing " + request);
        }
    }
}
