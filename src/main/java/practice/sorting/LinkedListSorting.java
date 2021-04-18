package practice.sorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListSorting {

    public static void main(String[] args) {
        String s = "413025";
        String[] nums = s.split("");
        for (String each : nums) {
            int integer = Integer.parseInt(each);
            if (integer > 0) {
                System.out.print("|");
                for (int i = 0; i < integer; i++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }


    public static void main1(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(11);
        list.add(4, 2);
        list.add(5, 0);
        System.out.println(list);
        list.sort(Comparator.comparingInt(Integer::intValue).reversed());
        System.out.println(list);
    }
}
