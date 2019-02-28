package competition;

import java.math.BigDecimal;

/**
 * @Auther: xuzhangwang
 * @Description:
 *
 * 
 */
public class _2014_06奇怪的分式 {
    static BigDecimal sum1;
    static BigDecimal sum2;
    public static void main(String[] args) {
        int ans = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        if (a != b && c != d) {
                            if (a != b && c != d) {;
                                sum1 = (new BigDecimal(a * c).divide(new BigDecimal(b * d), 10, BigDecimal.ROUND_HALF_UP));
                                sum2 = (new BigDecimal(a * 10 + c)).
                                        divide(new BigDecimal(b * 10 + d), 10, BigDecimal.ROUND_HALF_UP);
                                if (sum1.equals(sum2)) {
                                    System.out.println(a + "/" + b + " * " + c + "/" + d );
                                    ans++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
