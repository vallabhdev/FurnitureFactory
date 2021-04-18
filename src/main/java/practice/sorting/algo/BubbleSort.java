package practice.sorting.algo;

import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    private static final int[] arr = {3, 0, -1, 5, 10, 4, 6, 1, 8};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        long start = new Date().getTime();
        optimizedOne();
        long afterOne = new Date().getTime();
        System.out.println(afterOne - start);
        sort();
        long aftertwo = new Date().getTime();
        System.out.println(aftertwo - afterOne);
        doubleLoop();
        long third = new Date().getTime();
        System.out.println(third - aftertwo);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort() {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static void optimizedOne() {
        int temp;
        boolean flag;
        do {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }
        } while (flag);
    }

    private static void doubleLoop() {
        int temp;
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }
}
