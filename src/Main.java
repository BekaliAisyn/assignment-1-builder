public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Asus ROG Strix", 27.0, "2560x1440");

        Computer myComputer = new Computer.Builder("Core i9-13900H", 16, 1024, "Windows 11 pro")
                .gpu("Nvidia RTX 4060")
                .screenSize(27.0)
                .wifi(true)
                .bluetooth(true)
                .keyboard(true)
                .mouse(true)
                .gamingMode(true)
                .warrantyYears(1)
                .monitor(monitor)
                .build();

        System.out.println("CPU: " + myComputer.getCpu());
        System.out.println("RAM: " + myComputer.getRam() + "GB");
        System.out.println("GPU: " + myComputer.getGpu());
        System.out.println("Monitor: " + myComputer.getMonitor().brand + " " + myComputer.getMonitor().size + "\"");

        try {
            Computer badComputer = new Computer.Builder("Intel i3", 4, 256, "Windows 11")
                    .gamingMode(true)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Validation caught error: " + e.getMessage());
        }

    }
}