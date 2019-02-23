package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 质因数分解 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        print(start, end);
    }

    /**
     * 如下所示
     * @param start
     * @param end
     */
    public static void print(int start, int end) {
        for (int i = start; i <= end; i++) {
            print(i);
            System.out.println();
        }
    }

    /**
     * 分解质因数
     * @param num
     */
    public static void print(int num) {
        System.out.print(num + "=");
        for (int i = 2; i <= num; i++) {
            while (num != i) {
                if (num % i == 0) {
                    System.out.print(i + "*");
                    num /= i;
                } else {
                    break;
                }
            }
            if (num == i) {
                System.out.print(i);
            }
        }
    }
}
