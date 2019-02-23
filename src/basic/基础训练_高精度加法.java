package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
 * 计算c  =  a  +  b的时候，首先将A[0]与B[0]相加，如果有进位产生，则把进位（即和的十位数）存入r，把和的个位数存入C[0]，
 * 即C[0]等于(A[0]+B[0])%10。然后计算A[1]与B[1]相加，这时还应将低位进上来的值r也加起来，即C[1]应该是A[1]、B[1]和r三个数的和．
 * 如果又有进位产生，则仍可将新的进位存入到r中，和的个位存到C[1]中。依此类推，即可求出C的所有位。
 */
public class 基础训练_高精度加法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String aa = sc.nextLine();
        String bb = sc.nextLine();
        int[] a = new int[101];
        int[] b = new int[101];
        int[] c = new int[101];
        sc.close();
        if (aa == null || a.length == 0) {
            System.out.println(bb);
        }
        if (bb == null || bb.length() == 0) {
            System.out.println(aa);
        }
        for (int i = 0; i < aa.length(); i++) {
            a[i] = aa.charAt(aa.length() - 1 - i) - 48;
        }
        for (int i = 0; i < bb.length(); i++) {
            b[i] = bb.charAt(bb.length() - 1 - i) - 48;
        }
        int carry = 0;
        int temp = 0;
        for (int i = 0; i < c.length; i++) {
            temp = a[i] + b[i] + carry;
            c[i] = temp % 10;
            carry = temp / 10;
        }
        int index = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] != 0) {
                index = i;
                break;
            }
        }
        for (int i = index; i >=0 ; i--) {
            System.out.print(c[i]);
        }

    }

}
