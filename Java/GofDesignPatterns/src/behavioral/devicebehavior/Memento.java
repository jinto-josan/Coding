package behavioral.devicebehavior;

public class Memento {
    public static class SmartHomeMemento {
        private String state;

        public SmartHomeMemento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    public static class SmartHomeOriginator {
        private String state;

        public void setState(String state) {
            this.state = state;
        }

        public SmartHomeMemento save() {
            return new SmartHomeMemento(state);
        }

        public void restore(SmartHomeMemento memento) {
            state = memento.getState();
            System.out.println("Restored state: " + state);
        }
    }
}
