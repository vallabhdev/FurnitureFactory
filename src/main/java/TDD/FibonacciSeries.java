package TDD;

public class FibonacciSeries {

    public static void main1(String[] args) {
        //0 1 1 2 3 5
        int n = 47;
        int[] memo = new int[n + 1];
        System.out.println(fib(n, memo));
    }

    private static int fib(int i, int[] memo) {
        if (i <= 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = fib(i - 1, memo) + fib(i - 2, memo);
        return memo[i];
    }

    public static void main(String[] args) {
//        System.out.println(powerOf(6));
        System.out.println(bPowerOfA(2, 6));
        System.out.println(bPowerOfA(2, 0));
        System.out.println(bPowerOfA(2, 1));
        System.out.println(bPowerOfA(1, 6));
    }

    // 2 * 2 * 2 * 2
    private static int powerOf(int n) {
        int multiple = 1;
        for (int i = 1; i <= n; i++) {
            multiple *= 2;
        }
        return multiple;
    }

    private static int bPowerOfA(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        int multiple = 1;
        for (int i = 1; i <= b; i++) {
            multiple *= a;
        }
        return multiple;
    }
}
