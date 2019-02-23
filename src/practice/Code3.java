package practice;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: X星球居民小区的楼房都是一样的，并且按照矩阵的样式排列，其楼房的编号的为1，2，3....
 * 当排满一排的时候，从下一行的相邻的楼往反方向的排号
 *
 */
public class Code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        /**
         *  要算出两个房子的距离，就把两房子的 |行| + |列| 的绝对值算出来
         *  1、算出行号
         */
        int tmp = getRow(w, m, n);
        System.out.println(tmp);
    }

    /**
     * 输入对应的w，m房子号，输出对应的行, 只需要算出类似于6 12 18 24 的这种位置
     * 以w=6为例子， 6在第一行， 12在第二行， 18在第三行， 24在第四行。
     * m % w == 0 ? m /(w -1) ? m / w + 1;
     * 判断列号只需要判断奇偶，奇数行的是从左到右递增，偶数行的是从右到左递增
     * @param w
     * @param m
     * @return
     */
    public static int getRow(int w, int m, int n) {
        int tmp1 = m % w == 0 ? m / (w - 1) : m / w + 1;
        int tmp2 = n % w == 0 ? n / (w - 1) : n / w + 1;
        int row = Math.abs(tmp2 - tmp1);
        int col1 = getCol(w, m, tmp1);
        int col2 = getCol(w, n, tmp2);
        return Math.abs(tmp2 - tmp1) + Math.abs(col2 - col1);
    }

    public static int getCol(int w, int n, int tmp) {
        if (tmp % 2 != 0) {
            return Math.abs(n - (tmp * w) + w);
        } else {
            return Math.abs((tmp * w) - n + 1);
        }

        // 蓝桥的答案是
        // 奇数: (数字 % 宽度 - 1 + 宽度) % 宽度
        // 偶数: (宽度 - 数字%宽度) % 宽度
    }

}
