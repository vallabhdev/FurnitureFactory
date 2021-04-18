package practice.general;

import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

public class Trying {

    public static void main(String[] args) {
        String s = "Direction";

    }


    public static void main1(String[] args) throws FileNotFoundException {
//        First first = () -> System.out.println("From first");
//        Second sec = () -> System.out.println("From second");
//        sec.method();
//        System.out.println(countCapitalLetters("Hello Everyone.! Did You get to See me"));
        System.out.println(countCapital());
    }

    private static int countCapitalLetters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                count++;
            }
        }
        return count;
    }

    private static int countCapital() throws FileNotFoundException {
        File file = new File("C:/Users/Sreenika/Downloads/prateek/count.txt");
        FileInputStream ip = new FileInputStream(file);
        FileReader fileReader = new FileReader(file.getAbsolutePath());
        BufferedReader reader = new BufferedReader(fileReader);
        int count = 0;
        Stream<String> lines = reader.lines();
        for (Iterator<String> it = lines.iterator(); it.hasNext(); ) {
            String each = it.next();
            count += countCapitalLetters(each);
        }
        return count;
    }
}
