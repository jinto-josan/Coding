package behavioral.devicebehavior;

import creational.devicemanagement.devices.Device;

/**
 * DeviceCollection is a collection of devices that can be iterated over.
 */
public class DeviceCollection implements Iterable<Device> {
    private Device[] devices;

    public DeviceCollection(Device[] devices) {
        this.devices = devices;
    }

    @Override
    public DeviceIterator iterator() {
        return new DeviceIterator();
    }

    class DeviceIterator implements java.util.Iterator<Device> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < devices.length;
        }

        @Override
        public Device next() {
            return devices[index++];
        }
    }
}
