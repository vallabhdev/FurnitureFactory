package practice.general;

public class LabelledBreak {
    public static void main(String[] args) {
        breakInnerLoop();
        breakAtLabel();
    }

    private static void breakAtLabel() {
        a:
        for (int i = 1; i <= 3; i++) {
            b:
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break a;
                }
                System.out.println(i + "-" + j);
            }
        }
    }

    private static void breakInnerLoop() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break;
                }
                System.out.println(i + "-" + j);
            }
        }
    }
}
