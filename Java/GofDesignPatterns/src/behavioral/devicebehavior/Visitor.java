package behavioral.devicebehavior;

public class Visitor {
    interface DeviceVisitor {
        void visit(Light light);
        void visit(Thermostat thermostat);
    }

    public static class DeviceInspector implements DeviceVisitor {
        @Override
        public void visit(Light light) {
            System.out.println("Inspecting Light: Checking brightness.");
        }

        @Override
        public void visit(Thermostat thermostat) {
            System.out.println("Inspecting Thermostat: Checking temperature settings.");
        }
    }

    interface VisitableDevice {
        void accept(DeviceVisitor visitor);
    }

    public static class Light implements VisitableDevice {
        @Override
        public void accept(DeviceVisitor visitor) {
            visitor.visit(this);
        }
    }

    public static class Thermostat implements VisitableDevice {
        @Override
        public void accept(DeviceVisitor visitor) {
            visitor.visit(this);
        }
    }
}
