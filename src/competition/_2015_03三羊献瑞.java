package competition;

/**
 * @Auther: xuzhangwang
 * @Description:
 *
三羊献瑞

观察下面的加法算式：

祥 瑞 生 辉
+   三 羊 献 瑞
-------------------
三 羊 生 瑞 气

(如果有对齐问题，可以参看【图1.jpg】)

其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。

请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。


 */
public class _2015_03三羊献瑞 {
    public static void main(String[] args) {
        // 直接使用暴力的解法进行解决， for循环进行数据的模拟

        int ans = 0;
        for (int a = 1; a < 10; a++) {
            // 这个位置代表的是“祥” , 不能为0开头

            for (int b = 0; b < 10; b++) {
                if (b != a) for (int c = 0; c < 10; c++) {
                    if (c != b && c != a) for (int d = 0; d < 10; d++) {
                        if (d != c && d != b && d != a) for (int e = 1; e < 10; e++) {


                            // 当前的位置代表的是 “三”, 这个四位数开头则不能为0
                            if (e != d && e != c && e != b && e != a) for (int f = 0; f < 10; f++) {
                                if (f != e && f != d && f != c && f != b && f != a)for (int g = 0; g < 10; g++) {
                                    if (g != f && g != e && g != d && g != c && g != b && g != a) for (int h = 0; h < 10; h++) {
                                       if (h != a && h != b && h != c && h != d && h != e && h != f && h != g) {
                                           int shang = a * 1000 + b * 100 + c * 10 + d;
                                           int xia =  e * 1000 + f * 100 + g * 10 + b;
                                           int result = e * 10000 + f * 1000 + c * 100 + b * 10 + h;
                                           if ((shang + xia) == result) {
                                               ans++;
                                               System.out.println(a + "," + b + "," + c + "," + d);
                                               System.out.println(e + "," + f + "," + g + "," + b);
                                               System.out.println(e + "," + f + "," + c + "," + b + "," + h);
                                               System.out.println("====================================");
                                           }
                                       }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("结果=" + ans);

        // 三羊生瑞所代表的数字是 1065
    }
}
