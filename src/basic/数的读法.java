package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 解题思路
 * 将读入的数字往后向前读入的， 每四个分为一组， 数字长度的不够4整除的在前面补零
 */
public class 数的读法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dight = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba",
        "jiu"};
        String n = sc.nextLine();
        // cnt用于判断当前读入的数字前面得加多少个0
        int cnt = n.length() % 4;
        String[] tmp = {"0000", "000", "00", "0"};
        n = tmp[cnt] + n;
        String res = "";
        int nzero = 0;
        for (int i = 4 - cnt; i < n.length(); i++) {
            if (n.charAt(i) != '0') {
                if (nzero > 0 && i % 4 != 0) {
                    res += "ling ";
                }
                nzero = 0;
                if (i % 4 == 0) { // 千位
                    res += dight[n.charAt(i) - '0'] + " qian ";
                } else if (i % 4 == 1) {  // 百位
                    res += dight[n.charAt(i) - '0'] + " bai ";
                } else if (i % 4 == 2) {
                    res += dight[n.charAt(i) - '0'] + " shi ";
                } else {
                    res += dight[n.charAt(i) - '0'] + " ";
                }
            } else {
                nzero++;
            }
            if (n.length() - i == 5 && nzero < 4) {
                res += "wan ";
            } else if(n.length() - i == 9) {
                res += "yi ";
            }
            if (res.indexOf("yi shi") == 0) {
                res = res.substring(3, res.length());
            }
        }
        System.out.println(res);
    }
}
