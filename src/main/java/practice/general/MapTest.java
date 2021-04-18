package practice.general;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import practice.general.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MapTest {
    private static final Comparator<Employee> comByAge = Comparator.comparingInt(Employee::getAge);
    private static final Comparator<Employee> comBySal = Comparator.comparingInt(Employee::getSalary);
    private static final Comparator<Employee> comByName = Comparator.comparing(Employee::getName);

    public static void main1(String[] args) {
        Employee i1 = new Employee("one", 1, 1000, "add1");
        Employee i2 = new Employee("two", 22, 200, "add2");
        Employee i3 = new Employee("three", 22, 300, "add3");
        Employee i4 = new Employee("four", 22, 400, "add4");
        Employee i5 = new Employee("five", 5, 500, "add5");
        Employee i6 = new Employee("asix", 5, 500, "add6");

        List<Employee> lst = Arrays.asList(i1, i6, i2, i5, i4, i3);
        lst.forEach(System.out::println);
        System.out.println(" sorting started");
        lst.stream().sorted(comByAge.thenComparing(comBySal).thenComparing(comByName)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("    "));
        System.out.println(isPalindrome("Hello"));
    }

    static boolean isPalindrome(String s) {
        if (s.isBlank() || s.isEmpty()) {
            return false;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static int[] removeFromArray(int[] arr, int i) {
        if (hasElement(arr, i)) {
            int[] temp = new int[arr.length - 1];
            for (int each = 0; each < arr.length; each++) {
                if (arr[each] != i) {
                    temp[each] = arr[each];
                }
            }
            return temp;
        }
        return arr;
    }

    static boolean hasElement(int[] arr, int i) {
        for (int each : arr) {
            return each == i;
        }
        return false;
    }
    //        System.out.println(kangaroo(0, 3, 4, 2));

    static String kangaroo(int x1, int v1, int x2, int v2) {
        return v1 > v2 && (x2 - x1) % (v1 - v2) == 0 ? "YES" : "NO";
    }
    //        countApplesAndOranges(7, 10, 4, 12, new int[]{2, 3, -4}, new int[]{3, -2, -4});

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int apl_count = 0, ora_count = 0;
        for (int i = 0; i < apples.length; i++) {
            apples[i] += a;
            if (apples[i] >= s && apples[i] <= t) {
                apl_count++;
            }
        }
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] += b;
            if (oranges[i] >= s && oranges[i] <= t) {
                ora_count++;
            }
        }
        System.out.println(apl_count);
        System.out.println(ora_count);
    }

    static String nimGame(int[] pile) {
        int G = 0;
        for (int i = 0; i < pile.length; i++) {
            if (pile[i] % 2 != 0) {
                G ^= (pile[i] + 1);
            } else {
                G ^= (pile[i] - 1);
            }
        }
        return G != 0 ? "First" : "Second";
    }

    static String timeConversionViaSimpleDateFormat(String s) {
        Date parse = null;
        try {
            parse = new SimpleDateFormat("hh:mm:ssa").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat("HH:mm:ss").format(parse);
    }

    static String timeConversionByJoda(String s) {
        DateTime dateTime = DateTimeFormat.forPattern("hh:mm:ssa").parseDateTime(s);
        return DateTimeFormat.forPattern("HH:mm:ss").print(dateTime);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = 0, max_count = 0;
        for (int each : candles) {
            if (max == each) {
                max_count++;
            } else if (max < each) {
                max = each;
                max_count = 1;
            }
        }
        return max_count;
    }

    static void simpleMaxMin(int[] arr) {//[1,2,3,4,5]
        Arrays.sort(arr);
        long min = 0, max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min += arr[i];
            System.out.println(i);
        }
        for (int i = 1; i < arr.length; i++) {
            max += arr[i];
            System.out.println(i);
        }
        System.out.println(min + " " + max);
    }

    static void miniMaxSum(int[] arr) {
        long sum = 0, min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
            sum += arr[i];
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        System.out.println((sum - max) + " " + (sum - min));
    }
}
