package creational.devicemanagement;

/**
 * SmartHomeController is a singleton class that manages the status of the smart home system.
 */
public class SmartHomeController {
    private static SmartHomeController instance;
    private String status = "System is OFF";

    private SmartHomeController() {}

    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void turnOn() {
        status = "System is ON";
        System.out.println(status);
    }

    public void turnOff() {
        status = "System is OFF";
        System.out.println(status);
    }
}
