package DD;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/* Note: this file is available for your testing purposes
   and will not be included with your final submission. */

public class CandidateTest {

    @Test
    public void providedExample1() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher.java";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\test\\resources\\example_01.txt";
        String expected = "æ";

        /* We can compile once in the first test--the binary
         * will persist for the remainder of the test suite */
//        TestUtilities.runCommand("javac " + programNameUnderTest + ".java");

        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        assertEquals(expected, actual);
    }

    @Test
    public void providedExample2() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher.java";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\test\\resources\\example_02.txt";
        String expected = "↑";
//        TestUtilities.runCommand("javac " + programNameUnderTest + ".java");
        String actual = CrashMinimizer.minimize(
                "java " + programNameUnderTest, failingInputFilename
        );
        assertEquals(expected, actual);
    }

    @Test
    public void providedExample3() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher.java";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\test\\resources\\example_03.txt";
        String actual = CrashMinimizer.minimize("java " + programNameUnderTest, failingInputFilename);
        assertEquals("", actual);
    }

    @Test
    public void providedExample4() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher.java";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\test\\resources\\example_04.txt";
        String actual = CrashMinimizer.minimize("java " + programNameUnderTest, failingInputFilename);
        assertEquals("", actual);
    }

    @Test
    public void providedExample5() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher.java";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\test\\resources\\example_05.txt";
        String actual = CrashMinimizer.minimize("java " + programNameUnderTest, failingInputFilename);
        assertEquals("æ", actual);
    }

    @Test
    public void providedExample6() throws IOException {
        String programNameUnderTest = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\main\\java\\DD\\CaesarCipher.java";
        String failingInputFilename = "C:\\Users\\Sreenika\\Downloads\\prateek\\workspace\\play-area\\FurnitureFactory\\src\\test\\resources\\example_06.txt";
        String actual = CrashMinimizer.minimize("java " + programNameUnderTest, failingInputFilename);
        assertEquals("æ", actual);
    }
}