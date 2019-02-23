package entry;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 求圆的面积
 */
public class RoundArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double pi = Math.PI;
        double tmp = (n * n * pi);
        System.out.println(String.format("%.7f", tmp));
    }

}
