package behavioral.devicebehavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing.
 */
public class Observer {

    interface Obsrvr {
        void update(String event);
    }

    public static class MotionSensor {
        private List<Obsrvr> Obsrvrs = new ArrayList<>();

        public void addObsrvr(Obsrvr Obsrvr) {
            Obsrvrs.add(Obsrvr);
        }

        public void detectMotion() {
            System.out.println("Motion detected!");
            notifyObsrvrs("Motion Detected");
        }

        private void notifyObsrvrs(String event) {
            for (Obsrvr Obsrvr : Obsrvrs) {
                Obsrvr.update(event);
            }
        }
    }

    public static class LightObsrvr implements Obsrvr {
        @Override
        public void update(String event) {
            System.out.println("LightObsrvr: Turning on lights due to " + event);
        }
    }
}
