package competition;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Auther: xuzhangwang
 * @Description:
 *
立方变自身

观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？

请填写该数字，不要填写任何多余的内容或说明性的文字。

 */
public class _2015_02立方变自身 {
    public static void main(String[] args) {
        int ans = 0;

        // 直接暴力解法2层for循环, 如果当前的数字相等就ans++;
        // 因为2层的得到的最大的值可以代表100  100 ^ 3 每个位置上相加坑定最大就都不会相等
        for (int i = 1; i < 1000000; i++) {
            BigDecimal b = new BigDecimal(i);
            b = b.pow(3);
            String str = b.toString();
            BigDecimal tmp = BigDecimal.ZERO;
            for (int j = 0; j < str.length(); j++) {
                tmp = tmp.add(new BigDecimal(str.charAt(j) - 48));
            }
            if (i == tmp.intValue()) {
                System.out.println(i + "\t" + b.toString());
                ans++;

            }
        }
        System.out.println("结果=" + ans);
    }
}
