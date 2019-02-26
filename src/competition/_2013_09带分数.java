package competition;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 * 带分数
100 可以表示为带分数的形式：100 = 3 + 69258 / 714。
还可以表示为：100 = 82 + 3546 / 197。
注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
类似这样的带分数，100 有 11 种表示法。
输入格式
从标准输入读入一个正整数N (N<1000*1000)
输出格式
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！

样例输入1
100
样例输出1
11
样例输入2
105
样例输出2
6
【参考】：https://blog.csdn.net/liuchuo/article/details/56676795
【解析】：
用深度优先搜索，将1～9形成一个全排列，根据整数部分、分子和分母的长度来分割整个排列。设整数部分为a，分子为b，分母为c，这个数字的带分数形式就是a + (b / c)。a和b的长度是1～7，c的长度是由a和b来确定的，三个数字的总长度是9。最后验证a + (b / c)是否等于输入的数字。
 */
public class _2013_09带分数 {
    static int ans = 0;
    static int N = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
//        int[] arr = {1, 2, 3};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(0, arr);
        System.out.println(ans);
    }

    // 全排列
    private static void f(int k, int[] arr) {
        if (k == 9) {
            if (check(arr)) {
                return;
            }
        }


        // 选定第k位
        for (int i = k; i < arr.length; i++) {
            // 将第i个位置和第k位交换
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f(k + 1, arr);

            // 回溯（换回来）
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }

    }

    /* 枚举加号 和 除号的位置 */
    private static boolean check(int[] arr) {
        // + 前面的字符最多只能有7位, 最后两位作为分子分母
        for (int i = 1; i <= 7; i++) {
            int num1 = toInt(arr, 0, i);
            if (num1 >= N) continue;// 如果此时+数额已经超过N没有必要进行演算
            // /前的字符数, 最后一个位置要作为分母；
            for (int j = 1; j <= 8 - i; j++) {
                int num2 = toInt(arr, i, j);
                int num3 = toInt(arr, i + j, 9 - i - j);
                if (num2 % num3 ==0 && N == num1 + num2 / num3) {
                    ans++;
                }
            }
        }


        return true;
    }

    /**
     * @param arr
     * @param pos 当前所在的位置
     * @param len len表示所截取的数组的长度
     * @return
     */
    private static int toInt(int[] arr, int pos, int len) {
        int t = 1;
        int ans = 0;
        for (int i = pos + len - 1; i >= pos; i--) {
            ans += arr[i] * t;
            t *= 10;
        }
        return ans;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }


}
