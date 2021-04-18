package practice.sorting;

import java.util.*;

public class MapSorting {
    static int first = 0, second = 1, current = 0;
    private static final Comparator<Map.Entry<String, Integer>> comByValue = Map.Entry.comparingByValue();

    static void trySwtich(String label) {
        switch (label) {
            case "A":
                System.out.println("A");
            case "B":
                System.out.println("B");
            default:
                System.out.println("Default");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.next();
        String y = scanner.next();
        scanner.close();

        try {
            int parsedY = Integer.parseInt(y);
            int parsedX = Integer.parseInt(x);
            if (parsedY > 0 && parsedX > 0) {
                System.out.println(parsedX / parsedY);
            } else if (parsedY <= 0) {
                System.out.println(new ArithmeticException("/ by zero"));
            }
        } catch (NumberFormatException e) {
            System.out.println(new InputMismatchException());
        }
    }

    private static void stdIn_Out() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        List<Integer> integers = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            integers.add(scanner.nextInt());
        }
        int query = scanner.nextInt();
        for (int j = 1; j <= query; j++) {
            String queryType = scanner.next();
            if (queryType.equalsIgnoreCase("Insert")) {
                integers.add(scanner.nextInt(), scanner.nextInt());
            } else if (queryType.equalsIgnoreCase("Delete")) {
                integers.remove(scanner.nextInt());
            }
        }
        scanner.close();
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    private static void fibSeriesOfLengthViaRecursion(int i) {
        if (i > 0) {
            current = first + second;
            first = second;
            second = current;
            System.out.print(" " + current);
            fibSeriesOfLengthViaRecursion(i - 1);
        }
    }

    private static void fibSeriesOfLength(int i) {
//        int first = 0, second = 1, current;
        System.out.print(first + " " + second);
        for (int j = 2; j < i; j++) {
            current = first + second;
            System.out.print(" " + current);
            first = second;
            second = current;
        }
    }

    private static int getfibonacciNumberAtIndex(int i) {
        if (i <= 1) {
            return i;
        }
        return getfibonacciNumberAtIndex(i - 1) + getfibonacciNumberAtIndex(i - 2);
    }

    public static void main1(String[] args) {
        Map<String, Integer> unsortMap = createMapData();
        System.out.println(unsortMap);

        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());
        Collections.sort(list, comByValue.reversed());
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> each : list) {
            sortedMap.put(each.getKey(), each.getValue());
        }
        System.out.println(sortedMap);
        /*Set<Map.Entry<String, Integer>> entries = unsortMap.entrySet();
        List<Map.Entry<String, Integer>> collect = entries.stream().sorted(comByValue.reversed()).collect(Collectors.toList());
        Map<String, Integer> sortedMap = new HashMap<>();
        for (Map.Entry<String, Integer> each : collect) {
            sortedMap.put(each.getKey(), each.getValue());
        }
        System.out.println(sortedMap);*/
    }

    static Map<String, Integer> createMapData() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        return unsortMap;
    }
}
