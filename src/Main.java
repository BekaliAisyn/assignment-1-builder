public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Asus ROG Strix", 27.0, "2560x1440");

        Computer myComputer = new Computer("Core i9-13900H",
                16, 1024, "Windows 11 pro",
                "Nvidia RTX 4060", 27.0, true,
                true, true, true,
                true, 1, monitor);

        System.out.println("CPU: " + myComputer.cpu);
        System.out.println("RAM: " + myComputer.ram + "GB");
        System.out.println("GPU: " + myComputer.gpu);
        System.out.println("Monitor: " + myComputer.monitor.brand + " " + myComputer.monitor.size + "\"");

    }
}