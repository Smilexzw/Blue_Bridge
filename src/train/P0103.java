package train;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 大写转小写
 */
public class P0103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(str.toLowerCase());
    }
}
