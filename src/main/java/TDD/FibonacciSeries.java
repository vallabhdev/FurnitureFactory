package TDD;

public class FibonacciSeries {

    private static long fibByTabulation(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    private static long fibByMemorization(int i, long[] memo) {
        if (i <= 1) {
            return i;
        } else if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = fibByMemorization(i - 1, memo) + fibByMemorization(i - 2, memo);
        return memo[i];
    }

    public static void main(String[] args) {
        //0 1 1 2 3 5
        int n = 40;
        long[] memo = new long[n + 1];
//        System.out.println(fibByMemorization(n, memo));
        System.out.println(fibByTabulation(n));
    }

    public static void main2(String[] args) {
        System.out.println(bPowerOfA(1, 0));
        System.out.println(bPowerOfA(2, 6));
        System.out.println(bPowerOfA(2, 0));
        System.out.println(bPowerOfA(2, 1));
        System.out.println(bPowerOfA(1, 6));
        System.out.println(bPowerOfA(-1, 6));
        System.out.println(bPowerOfA(1, -6));

    }

    private static int bPowerOfA(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
        int multiple = 1;
        for (int i = 1; i <= b; i++) {
            multiple *= a;
        }
        return multiple;
    }
}
