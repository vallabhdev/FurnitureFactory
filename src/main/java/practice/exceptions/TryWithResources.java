package practice.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {
    public static void main1(String[] args) {
        File hello = new File("Hello");
        try (Scanner scanner = new Scanner(hello);
             PrintWriter pw = new PrintWriter(hello)) {
            while (scanner.hasNext()) {
                pw.write(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File hello = new File("Hello");
        final Scanner scanner = new Scanner(hello);
        final PrintWriter pw = new PrintWriter(hello);
        try (scanner; pw) {
            while (scanner.hasNext()) {
                pw.write(scanner.nextLine());
            }
        }
    }
}
