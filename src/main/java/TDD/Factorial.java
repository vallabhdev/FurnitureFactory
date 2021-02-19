package TDD;

public class Factorial {
    public int factorialOf(int i) throws Exception {
        if (i < 0) {
            throw new Exception("negative number");
        }
        if (i == 1) {
            return 1;
        }
        return i * factorialOf(i - 1);
    }
}
