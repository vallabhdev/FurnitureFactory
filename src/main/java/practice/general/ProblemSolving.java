package practice.general;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProblemSolving {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4};
//        System.out.println(simpleArraySum(ar));

        List<Integer> first = Arrays.asList(1, 2, 3, 4);
        List<Integer> second = Arrays.asList(4, 5, 6, 7);
        List<Integer> third = Arrays.asList(7, 8, 9, 10);
        List<Integer> forth = Arrays.asList(10, 11, 12, 13);
        List<List<Integer>> arr = Arrays.asList(first, second, third);
//        Integer[][] arr = {{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}, {7, 8, 9, 10}};
        Date start = new Date();
        System.out.println(start);
        System.out.println(diagonalDifference(arr));
        Date end = new Date();
        System.out.println(end);
        System.out.println(end.getTime() - start.getTime());
    }

    private static int diagonalDifference(List<List<Integer>> arr) {
        Integer left_diagonal = 0, right_diagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> eachRow = arr.get(i);
            for (int j = 0; j < eachRow.size(); j++) {
                if (i == j) {
                    left_diagonal += eachRow.get(j);
                }
                if (i == eachRow.size() - j - 1) {
                    right_diagonal += eachRow.get(j);
                }
            }
        }
        return Math.abs(left_diagonal - right_diagonal);
    }

    private static int effectiveDiagonalDifference(Integer[][] arr) {
        Integer left_diagonal = 0, right_diagonal = 0;
        for (int i = 0; i < arr.length; i++) {
            left_diagonal += arr[i][i];
            right_diagonal += arr[i][arr.length - i - 1];
        }
        return Math.abs(left_diagonal - right_diagonal);
    }

    private static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        return sum;
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int a_score = 0, b_score = 0;
        for (int i = 0; i < a.size() && i < b.size(); i++) {
            if (a.get(i) > b.get(i)) {
                a_score += 1;
            } else if (a.get(i) < b.get(i)) {
                b_score += 1;
            }
        }
        return Arrays.asList(a_score, b_score);
    }
}
