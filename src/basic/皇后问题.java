package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 给定一个n*n大小的棋盘， 棋盘中有些位置不能摆放皇后
 * 输入
 *  输入的第一行为一个整数n，表示棋盘的大小
 *  接下来n行，每行n个0或则1的整数，如果一个整数为1，表示该位置可以放皇后，如果一个整数为0
 *  表示对应的位置不可以放皇后。
 */
public class 皇后问题 {

    public static int total = 0;

    public static int N;
    public static int[] c;
    public static int[][] border;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        c = new int[N];
        border = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                border[i][j] = sc.nextInt();
            }
        }
        queen(0, N);
        System.out.println(total);
    }

    /**
     * 先用n皇后问题进行求解, 可以用一维数组模拟二维数组
     * @return
     */
    public static void queen(int row, int N) {
        if (row == N) {
            total++;
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i]);
            }
            System.out.println();
        } else {
            // 控制列数的变化
            for (int col = 0; col != N; col++) {
                c[row] = col;
                if (isPlace(row, col)) {
                    queen(row + 1, N);
                }
            }
        }
    }

    public static boolean isPlace(int row, int col) {
        // 判断该位置是否能摆放, i != row, 控制的是的
        for (int i = 0; i != row ; i++) {
            // 当前棋盘位置为1
            if (border[row][col] == 0 || c[row] == c[i] || Math.abs(c[row] - c[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
