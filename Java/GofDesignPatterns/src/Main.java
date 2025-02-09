import behavioral.devicebehavior.*;
import creational.devicemanagement.Prototype;
import creational.devicemanagement.SmartHomeController;
import creational.devicemanagement.devices.Device;
import creational.devicemanagement.devices.DeviceFactory;
import creational.devicemanagement.devices.LightFactory;
import creational.devicemanagement.flyofdevices.LivingRoomFactory;
import creational.devicemanagement.flyofdevices.RoomFactory;
import creational.devicemanagement.smarthome.SmartHome;
import creational.devicemanagement.smarthome.SmartHomeBuilder;
import structural.deviceintegration.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Singleton
        SmartHomeController controller = SmartHomeController.getInstance();
        controller.turnOn();

        // Factory Method
        DeviceFactory lightFactory = new LightFactory();
        Device light = lightFactory.createDevice();
        light.turnOn();

        // Abstract Factory
        RoomFactory livingRoomFactory = new LivingRoomFactory();
        Device livingRoomLight = livingRoomFactory.createLight();
        livingRoomLight.turnOn();

        // Builder
        SmartHome smartHome = new SmartHomeBuilder()
                .setLights("ON")
                .setThermostat("72°F")
                .setSecurity("Armed")
                .build();
        System.out.println(smartHome);

        // Prototype
        Prototype.AdvancedLight advancedLight = new Prototype.AdvancedLight();
        Prototype.AdvancedLight clonedLight = advancedLight.clone();
        clonedLight.turnOn();

        // Adapter
        Adapter.OldThermostat oldThermostat = new Adapter.OldThermostat();
        Device adaptedThermostat = new Adapter.ThermostatAdapter(oldThermostat);
        adaptedThermostat.turnOn();

        // Bridge
        Bridge.DeviceImplementation lightImpl = new Bridge.LightImplementation();
        Bridge.DeviceControl remote = new Bridge.RemoteControl(lightImpl);
        remote.turnOn();

        // Composite
        DeviceGroup deviceGroup = new DeviceGroup(new Device[]{light, adaptedThermostat});
        deviceGroup.turnOn();

        // Decorator
        Device timedLight = new Decorator.TimedDevice(light);
        timedLight.turnOn();

        // Facade
        SmartHomeFacade facade = new SmartHomeFacade(light, adaptedThermostat);
        facade.startEveningRoutine();

        // Flyweight
        Flyweight.DeviceState state = new Flyweight.DeviceState("ON");
        Flyweight.DeviceFlyweight flyweight = new Flyweight.DeviceFlyweight(state);
        flyweight.operate();

        // Proxy
        SecureDeviceProxy secureLight = new SecureDeviceProxy("1234");
        secureLight.turnOn();

        // Chain of Responsibility
        ChainOfResponsibility.DeviceHandler lightHandler = new ChainOfResponsibility.LightHandler();
        ChainOfResponsibility.DeviceHandler thermostatHandler = new ChainOfResponsibility.ThermostatHandler();
        lightHandler.setNextHandler(thermostatHandler);
        lightHandler.handleRequest("TurnOnThermostat");

        // Command
        Command.Cmd turnOnCommand = new Command.TurnOnCmd(light);
        Command.RemoteControl remoteControl = new Command.RemoteControl();
        remoteControl.setCmd(turnOnCommand);
        remoteControl.pressButton();

        // Iterator
        DeviceCollection deviceCollection = new DeviceCollection(new Device[]{light, adaptedThermostat});
        for (Device device : deviceCollection) {
            device.turnOn();
        }

        // Mediator
        SmartHomeMediator mediator = new SmartHomeMediator(light, adaptedThermostat);
        mediator.turnOnAllDevices();

        // Memento
        Memento.SmartHomeOriginator originator = new Memento.SmartHomeOriginator();
        originator.setState("ON");
        Memento.SmartHomeMemento memento = originator.save();
        originator.setState("OFF");
        originator.restore(memento);

        // Observer
        Observer.MotionSensor motionSensor = new Observer.MotionSensor();
        motionSensor.addObsrvr(new Observer.LightObsrvr());
        motionSensor.detectMotion();

        // State
        State.DeviceContext deviceContext = new State.DeviceContext();
        deviceContext.setState(new State.OnState());
        deviceContext.request();

        // Strategy
        Stratergy.ThermostatContext thermostatContext = new Stratergy.ThermostatContext();
        thermostatContext.setStrategy(new Stratergy.EcoHeating());
        thermostatContext.executeStrategy();

        // Template Method
        Template.DeviceSetup lightSetup = new Template.LightSetup();
        lightSetup.setup();

        // Visitor

        Visitor.DeviceInspector inspector = new Visitor.DeviceInspector();
        new Visitor.Light()
                .accept(inspector);
        new Visitor.Thermostat().accept(inspector);
    }
}