package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 * FJ在沙盘上写了这样一些字符串：
 * A1  =  “A”
 * A2  =  “ABA”
 * A3  =  “ABACABA”
 * A4  =  “ABACABADABACABA”
 * 你能找出其中的规律并写所有的数列AN吗？
 *
 *
 * 通过上面的观察可以看出，下一个位置的答案是上一个位置的基础上加上一个字母得到的结果
 * A 对应的AscII的值为65那户y'n'n'n'n'n'n'n'n'n'n'n'n'n'n'n'n'n'n
 */
public class FJ的字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + (char)(65 + i) + s;
        }
        System.out.println(s);
    }


}
