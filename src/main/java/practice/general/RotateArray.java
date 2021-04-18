package practice.general;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println(solution(14));//99
    }

    public static int solution(int N) {
        String[] chars = String.valueOf(N).split("");
        int length = chars.length;
        int sum = getSum(chars, length);
        System.out.println(sum); //5
        return getSmallestInt(N, sum);
    }
// N = 15,16,17,18,19,20, .....28
    private static int getSmallestInt(int N, int sum) {
        for (int i = N + 1; i <= N + 1 + 10; i++) {
            String[] eachNum = String.valueOf(i).split("");
            int eachSum = getSum(eachNum, eachNum.length);
            if (eachSum == (sum * 2)) {
                return eachSum;
            }
        }
        return 0;
    }

    private static int getSum(String[] chars, int length) {
        int sum;
        if (length == 3) {
            sum = Integer.parseInt(chars[0]) + Integer.parseInt(chars[1]) + Integer.parseInt(chars[2]);
        } else if (length == 2) {
            sum = Integer.parseInt(chars[0]) + Integer.parseInt(chars[1]);
        } else if (length == 1) {
            sum = Integer.parseInt(chars[0]);
        } else {
            return 0;
        }
        return sum;
    }

}
