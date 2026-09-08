public class Computer {

    String cpu;
    int ram;
    int storage;
    String operatingSystem;
    String gpu;
    double screenSize;
    boolean wifi;
    boolean bluetooth;
    boolean keyboard;
    boolean mouse;
    boolean gamingMode;
    int warrantyYears;
    Monitor monitor;

    public Computer(String cpu, int ram, int storage, String operatingSystem, String gpu,
                    double screenSize, boolean wifi, boolean bluetooth, boolean mouse, boolean keyboard,
                    boolean gamingMode, int warrantyYears, Monitor monitor) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.gpu = gpu;
        this.screenSize = screenSize;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.gamingMode = gamingMode;
        this.warrantyYears = warrantyYears;
        this.monitor = monitor;
    }
}
