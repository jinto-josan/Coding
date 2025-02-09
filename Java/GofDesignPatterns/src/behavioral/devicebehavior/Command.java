package behavioral.devicebehavior;

import creational.devicemanagement.devices.Device;

/**
 * Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request.
 * This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.
 */
public class Command {
    public interface Cmd {
        void execute();
    }

    public static class TurnOnCmd implements Cmd {
        private Device device;

        public TurnOnCmd(Device device) {
            this.device = device;
        }

        @Override
        public void execute() {
            device.turnOn();
        }
    }

    class TurnOffCmd implements Cmd {
        private Device device;

        public TurnOffCmd(Device device) {
            this.device = device;
        }

        @Override
        public void execute() {
            device.turnOff();
        }
    }

    public static class RemoteControl {
        private Cmd Cmd;

        public void setCmd(Cmd Cmd) {
            this.Cmd = Cmd;
        }

        public void pressButton() {
            Cmd.execute();
        }
    }
}

