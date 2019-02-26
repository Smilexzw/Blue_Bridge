package competition;

import java.math.BigDecimal;

/**
 * @Auther: xuzhangwang
 * @Description: 黄金分割数
 * 比较简单的一种是用连分数：
                  1
    黄金数 = ---------------------
                        1
             1 + -----------------
                          1
                 1 + -------------
                            1
                     1 + ---------
                          1 + ...
    这个连分数计算的“层数”越多，它的值越接近黄金分割数。
    请你利用这一特性，求出黄金分割数的足够精确值，要求四舍五入到小数点后100位。
    小数点后3位的值为：0.618
    小数点后4位的值为：0.6180
    小数点后5位的值为：0.61803
    小数点后7位的值为：0.6180340
   （注意尾部的0，不能忽略）
你的任务是：写出精确到小数点后100位精度的黄金分割值。
 */
public class _2013_04黄金分割数 {
    public static void main(String[] args) {
        /*
           这是一道找规律的题目，由上提示可以推出
           第一层    1 / 2
           第二层    2 / 3
           第三层    3 / 5
           第四层    5 / 8
           第五层    8 / 13
           第六层    13 / 21
           .....
           由上可以写出代码
         */
        BigDecimal a = BigDecimal.ONE;
        BigDecimal b = new BigDecimal("2");
        BigDecimal result = null;
        BigDecimal tmp;
        for (int i = 0; i < 1000; i++) {
            tmp = a;
            a = b;
            b = tmp.add(b);
            // 这里直接放计算机去计算， 要注意result的精度范围
            result = a.divide(b, 1000, BigDecimal.ROUND_HALF_UP);
        }
        System.out.println(result.setScale(100, BigDecimal.ROUND_HALF_UP));

//        double a = 1;
//        double b = 2;
//        double result = 0;
//        double tmp = 0;
//        for (int i = 1; i < 2000; i++) {
//            tmp = a;
//            a = b;
//            b = tmp + b;
//            result = a / b;
//        }
//        System.out.println(result);
    }
}
