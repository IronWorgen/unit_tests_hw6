package Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[][] arrays;

    @BeforeEach
    void setUp() {
        arrays = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{3, 2, 3, 4},
                new int[]{3, 2, 3, 4},
                new int[]{1, 2, 3, 4}
        };
    }

    @Test
    @DisplayName("search arr with max AVG")
    void compareAvg() {
        assertEquals(
                "список №2 имеет наибольшее среднее значение  = 3\n" +
                        "список №3 имеет наибольшее среднее значение  = 3", getConsoleOutput(() -> Main.compareAvg(arrays)));

        arrays = new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 4}
        };
        assertEquals("Средние значения равны", getConsoleOutput(() -> Main.compareAvg(arrays)));

    }

    private String getConsoleOutput(Runnable runnable) {

        var standardOut = System.out;
        try {
            var outputStream = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStream));

            runnable.run();
            return outputStream.toString().trim();

        } finally {
            System.setOut(standardOut);
        }
    }
}