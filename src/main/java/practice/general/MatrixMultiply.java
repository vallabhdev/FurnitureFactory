package practice.general;

public class MatrixMultiply {
    static int r1 = 3, c1 = 2, r2 = 2, c2 = 3;
    private static int[][] A = {{1, 2}, {3, 4}, {5, 6}};
    private static int[][] B = {{1, 2, 3}, {4, 5, 6}};
    private static int[][] C = new int[r1][c2];

    public static void main(String[] args) {
        printMatrix(C, r1, c2);
        C = multiplyMatrix(A, B);
        printMatrix(C, r1, c2);
    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b) {
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < r2; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    static void printMatrix(int[][] c, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.print(c[i][j] + " ");

            System.out.println();
        }
    }
}
