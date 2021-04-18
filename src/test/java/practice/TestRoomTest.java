package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestRoomTest {

    public static int countMaxElement(int[] n) {
        int size = n.length / 2;
        int max = 0;
        List<Integer> aboveThreshold = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (int each : n) {
            if (!counter.containsKey(each)) {
                counter.put(each, 1);
            } else {
                counter.put(each, counter.get(each) + 1);
            }
            Integer value = counter.get(each);
            if ((value >= size) && value > max) {
                aboveThreshold.add(each);
            }
        }
        return aboveThreshold.stream().findFirst().get();
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 1, 1, 1, 2, 3, 4, 3, 2, 2, 2, 2, 2};
        System.out.println(countMaxElement(ints));
//        System.out.println(countMaxChar("hello world you are my favorite program.!"));
    }

    public static int countMaxChar(String n) {
        int[] chars = new int[256];
        for (int i = 0; i < n.length(); i++) {
            chars[n.charAt(i)]++;
        }
        int max = 0;
        char result = ' ';
        for (int i = 0; i < n.length(); i++) {
            if (max < chars[n.charAt(i)]) {
                max = chars[n.charAt(i)];
                result = n.charAt(i);
            }
        }
        System.out.println(result);
        return max;
    }

    @Test
    public void power() throws Exception {
        int n = 10;
        int p = 0;
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        long result = 1;
        for (int i = 1; i <= p; i++) {
            result *= n;
        }
        System.out.println(result);
    }
}