package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 按照要求进行回形取数
 */
public class 回形取数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        // 下面开始回形取数
        spairOrderPrint(matrix);
    }

    public static void spairOrderPrint(int[][] m) {
        int tR = 0;
        int tC = 0;
        int dR = m.length - 1;
        int dC = m[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(m, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 有两种特殊情况
     * 1、只有一行
     * 2、只有一列
     */

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        // 只有一行的
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) { // 只有一列
            for (int i = tR; i < dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            int curR = tR;
            int curC = tC;
            while (curR != dR) {
                System.out.print(m[curR][tC] + " ");
                curR++;
            }
            while (curC != dC) {
                System.out.print(m[dR][curC] + " ");
                curC++;
            }
            while (curR != tR) {
                System.out.print(m[curR][dC] + " ");
                curR--;
            }
            while (curC != tC) {
                System.out.print(m[tR][curC] + " ");
                curC--;
            }
        }
    }
}
