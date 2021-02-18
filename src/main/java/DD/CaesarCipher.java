package DD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaesarCipher {
    public static void main(String[] args)
            throws IOException, FileNotFoundException {
        if (args.length != 1) {
            System.exit(1);
        }
        String path = args[0];
        String outputFile = "output.txt";

        try {
            int length = new String(
                    Files.readAllBytes(Paths.get(path)),
                    StandardCharsets.UTF_8
            ).length();

            char[] shifted = new char[length];
            FileInputStream inFile = new FileInputStream(path);
            PrintWriter outFile = new PrintWriter(outputFile);
            int shiftedLen = 0;
            int shiftAmount = 10;
            int maxAmount = 128;

            for (int i; (i = inFile.read()) != -1;) {
                shifted[shiftedLen++] = (char)((i + shiftAmount) % maxAmount);
            }

            outFile.println(shifted.toString());
            outFile.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}