package practice.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayPractice {
    public static void main1(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(deleteElementAt(1, input)));
//        System.out.println(Arrays.toString(rotate(input, 500000003)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List> parentList = prepare2DArray(scanner);
        queryTo(parentList, scanner);
        scanner.close();
    }

    private static List<List> prepare2DArray(Scanner scanner) {
        int lines = Integer.parseInt(scanner.nextLine());
        List<List> parentList = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            int length = scanner.nextInt();
            List<Integer> childList = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                childList.add(scanner.nextInt());
            }
            parentList.add(childList);
            scanner.nextLine();
        }
        System.out.println(parentList);
        return parentList;
    }

    private static void queryTo(List<List> list, Scanner scanner) {
        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < queries; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x < list.size() && y < list.get(x).size()) {
                System.out.println(list.get(x).get(y));
            } else {
                System.out.println("Error!");
            }
        }
    }

    private static int[] deleteElementAt(int index, int[] input) {
        int size = input.length;
        for (int i = index; i < size - 1; i++) {
            input[i] = input[i + 1];
        }
        input[size] = Integer.parseInt(null);
        return input;
    }

    private static int[] rotate(int[] input, int times) {
        int size = input.length;
        int rotation = times % size;
        for (int i = 0; i < rotation; i++) {
            int first = input[0];
            for (int j = 0; j < size - 1; j++) {
                input[j] = input[j + 1];
            }
            input[size - 1] = first;
        }
        return input;
    }

    public static void main2(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        int m = 2;
        int size = a.size() - 1;
        for (int i = 0; i < m; i++) {
            Integer value = a.get(0);
            a.remove(0);
            a.add(size, value);
        }
        System.out.println(a);
    }
}
