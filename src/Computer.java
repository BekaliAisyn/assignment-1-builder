public class Computer {

    private static final String DEFAULT_GPU = "Integrated Graphics";
    private final String cpu;
    private final int ram;
    private final int storage;
    private final String operatingSystem;

    private final String gpu;
    private final double screenSize;
    private final boolean wifi;
    private final boolean bluetooth;
    private final boolean keyboard;
    private final boolean mouse;
    private final boolean gamingMode;
    private final int warrantyYears;
    private final Monitor monitor;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.operatingSystem = builder.operatingSystem;
        this.gpu = builder.gpu;
        this.screenSize = builder.screenSize;
        this.wifi = builder.wifi;
        this.bluetooth = builder.bluetooth;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
        this.gamingMode = builder.gamingMode;
        this.warrantyYears = builder.warrantyYears;
        this.monitor = builder.monitor;
    }

    public String getCpu() { return cpu; }
    public int getRam() { return ram; }
    public int getStorage() { return storage; }
    public String getOperatingSystem() { return operatingSystem; }
    public String getGpu() { return gpu; }
    public double getScreenSize() { return screenSize; }
    public boolean hasWifi() { return wifi; }
    public boolean hasBluetooth() { return bluetooth; }
    public boolean hasKeyboard() { return keyboard; }
    public boolean hasMouse() { return mouse; }
    public boolean isGamingMode() { return gamingMode; }
    public int getWarrantyYears() { return warrantyYears; }
    public Monitor getMonitor() { return monitor; }

    public static Computer budget() {
        return new Builder("Intel i3-12100", 8, 256, "Windows 11 Home")
                .gpu("Integrated Graphics")
                .enableWifi()
                .warrantyYears(1)
                .build();
    }

    public static Computer gaming() {
        return new Builder("Core i9-13900H", 32, 1024, "Windows 11 Pro")
                .gpu("Nvidia RTX 4070")
                .enableWifi()
                .bluetooth(true)
                .gamingMode(true)
                .warrantyYears(2)
                .build();
    }

    public static Computer workstation() {
        return new Builder("AMD Ryzen 9 7950X", 64, 2048, "Windows 11 Pro")
                .gpu("Nvidia RTX 4090")
                .enableWifi()
                .bluetooth(true)
                .warrantyYears(3)
                .build();
    }

    public static class Builder {
        private final String cpu;
        private final int ram;
        private final int storage;
        private final String operatingSystem;

        private String gpu = DEFAULT_GPU;
        private double screenSize = 24.0;
        private boolean wifi = false;
        private boolean bluetooth = false;
        private boolean keyboard = true;
        private boolean mouse = true;
        private boolean gamingMode = false;
        private int warrantyYears = 1;
        private Monitor monitor;

        public Builder(String cpu, int ram, int storage, String operatingSystem) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
            this.operatingSystem = operatingSystem;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder screenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public Builder enableWifi() {
            this.wifi = true;
            return this;
        }

        public Builder bluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Builder keyboard(boolean keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder mouse(boolean mouse) {
            this.mouse = mouse;
            return this;
        }

        public Builder gamingMode(boolean gamingMode) {
            this.gamingMode = gamingMode;
            return this;
        }

        public Builder warrantyYears(int warrantyYears) {
            this.warrantyYears = warrantyYears;
            return this;
        }

        public Builder monitor(Monitor monitor) {
            this.monitor = monitor;
            return this;
        }

        public Computer build() {
            validateSingleFields();
            validateCrossFieldRules();
            return new Computer(this);
        }

        private void validateSingleFields() {
            if (ram <= 0) {
                throw new IllegalArgumentException("RAM must be greater than 0");
            }
            if (storage <= 0) {
                throw new IllegalArgumentException("Storage must be greater than 0");
            }
            if (cpu == null || cpu.trim().isEmpty()) {
                throw new IllegalArgumentException("CPU cannot be empty");
            }
        }

        private void validateCrossFieldRules() {
            if (gamingMode && gpu.equals(DEFAULT_GPU)) {
                throw new IllegalArgumentException("Gaming mode requires a dedicated GPU, not integrated graphics");
            }
            if (gamingMode && ram < 16) {
                throw new IllegalArgumentException("Gaming mode requires at least 16GB RAM");
            }
        }
    }
}