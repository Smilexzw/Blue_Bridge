package competition;

/**
 * @Auther: xuzhangwang
 * @Description:
 *
牌型种数

小明被劫持到X赌城，被迫与其他3人玩牌。
一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
这时，小明脑子里突然冒出一个问题：
如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？

请填写该整数，不要填写任何多余的内容或说明文字。

 */
public class _2015_07牌型种数 {
    static int ans = 0;
    public static void main(String[] args) {
        // 直接暴力
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 5; c++) {
                    for (int d = 0; d < 5; d++) {
                        for (int e = 0; e < 5; e++) {
                            for (int f = 0; f < 5; f++) {
                                for (int h = 0; h < 5; h++) {
                                    for (int k = 0; k < 5; k++) {
                                        for (int l = 0; l < 5; l++) {
                                            for (int m = 0; m < 5; m++) {
                                                for (int n = 0; n < 5; n++) {
                                                    for (int o = 0; o < 5; o++) {
                                                        for (int p = 0; p < 5; p++) {
                    if (a+b+c+d+e+f+h+k+l+m+n+o+p == 13) {
                        ans++;
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
                    }
                }
            }
        }

        System.out.println(ans);
    }


}
