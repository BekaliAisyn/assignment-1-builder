import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerTest {

    @Test
    void validComputerIsCreated() {
        Computer computer = new Computer.Builder("Intel i5", 16, 512, "Windows 11")
                .build();
        assertEquals("Intel i5", computer.getCpu());
        System.out.println("Computer created successfully \uD83C\uDF4C");
    }

    @Test
    void validGamingComputerIsCreated() {
        Computer computer = new Computer.Builder("Core i9", 32, 1024, "Windows 11")
                .gamingMode(true)
                .gpu("RTX 4070")
                .build();
        assertTrue(computer.isGamingMode());
    }

    @Test
    void validComputerWithMonitorIsCreated() {
        Monitor monitor = new Monitor("Dell", 27.0, "1440p");
        Computer computer = new Computer.Builder("AMD Ryzen 7", 16, 512, "Linux")
                .monitor(monitor)
                .build();
        assertEquals("Dell", computer.getMonitor().brand);
    }

    @Test
    void zeroRamThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("Intel i5", 0, 512, "Windows 11").build();
        });
    }

    @Test
    void negativeStorageThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("Intel i5", 16, -100, "Windows 11").build();
        });
    }

    @Test
    void emptyCpuThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("", 16, 512, "Windows 11").build();
        });
    }

    @Test
    void ramExactlyOneIsValid() {
        Computer computer = new Computer.Builder("Intel i3", 1, 128, "Windows 11")
                .build();
        assertEquals(1, computer.getRam());
    }

    @Test
    void storageExactlyOneIsValid() {
        Computer computer = new Computer.Builder("Intel i3", 8, 1, "Windows 11")
                .build();
        assertEquals(1, computer.getStorage());
    }

    @Test
    void gamingModeWithoutGpuThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("Intel i5", 32, 512, "Windows 11")
                    .gamingMode(true)
                    .build();
        });
    }

    @Test
    void gamingModeWithLowRamThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("Intel i5", 8, 512, "Windows 11")
                    .gamingMode(true)
                    .gpu("RTX 4070")
                    .build();
        });
    }

    @Test
    void builderReuseDoesNotAffectPreviousObject() {
        Computer.Builder builder = new Computer.Builder("Intel i5", 16, 512, "Windows 11");
        Computer firstComputer = builder.gpu("Integrated Graphics").build();
        Computer secondComputer = builder.gpu("RTX 4090").build();

        assertEquals("Integrated Graphics", firstComputer.getGpu());
        assertEquals("RTX 4090", secondComputer.getGpu());
    }
}