package DD;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/* Note: this file is available for your testing purposes
   and will not be included with your final submission. */

public class CandidateTest {

    @Test
    public void providedExample1() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\bc5a5f88-8006-4de6-beaf-8724527f9b91\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\bc5a5f88-8006-4de6-beaf-8724527f9b91\\FurnitureFactory\\src\\test\\resources\\example_01.txt";
        String expected = "æ";

        /* We can compile once in the first test--the binary
         * will persist for the remainder of the test suite */
        TestUtilities.runCommand("javac " + programNameUnderTest + ".java");

        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        assertEquals(expected, actual);
    }

    @Test
    public void providedExample2() throws IOException {
        String programNameUnderTest = "CaesarCipher";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\bc5a5f88-8006-4de6-beaf-8724527f9b91\\FurnitureFactory\\src\\test\\resources\\example_02.txt";
        String expected = "↑";

        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        List<String>  s = Arrays.asList("heloo", "again");
        assertEquals(expected, actual);

    }
}