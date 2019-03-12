package competition;

import java.math.BigDecimal;
import java.util.Scanner;


/**
 * @Auther: xuzhangwang
 * @Description: 垒骰子
 * <p>
 * 赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
 * 经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！
 * 我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
 * 假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。
 * atm想计算一下有多少种不同的可能的垒骰子方式。
 * 两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
 * 由于方案数可能过多，请输出模 10^9 + 7 的结果。
 * <p>
 * 不要小看了 atm 的骰子数量哦～
 * <p>
 * 「输入格式」
 * 第一行两个整数 n m
 * n表示骰子数目
 * 接下来 m 行，每行两个整数 a b ，表示 a 和 b 不能紧贴在一起。
 * <p>
 * 「输出格式」
 * 一行一个数，表示答案模 10^9 + 7 的结果。
 * <p>
 * 「样例输入」
 * 2 1
 * 1 2
 * <p>
 * 「样例输出」
 * 544
 * <p>
 * 「数据范围」
 * 对于 30% 的数据：n <= 5
 * 对于 60% 的数据：n <= 100
 * 对于 100% 的数据：0 < n <= 10^9, m <= 36
 * <p>
 * <p>
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 2000ms
 * <p>
 * <p>
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 * <p>
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class _2015_09_垒骰子 {

    static int MOD = 1000000007;

    static int[] op = new int[7];
    static boolean[][] conflict = new boolean[7][7];

    // n表示那个骰子，m表示有多少组冲突
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            conflict[x][y] = true;
            conflict[y][x] = true;
        }

        init();
        long ans = 0;
        for (int up = 1; up <= 6; up++) {
            ans = (ans + 4 * f(up, n - 1)) % MOD;
        }
        System.out.println(ans);
    }


    public static long f(int up, int cnt) {
        if (cnt == 0) {
            return 4;    // 色子是可以转动的
        }
        long ans = 0;
        for (int upp = 1; upp <= 6; upp++) {
            // 起了冲突
            if (conflict[op[up]][upp]) continue;
            ans += f(upp, cnt - 1);
        }
        return ans;
    }

    /**
     * 定义的冲突数组
     */
    public static void init() {
        op[1] = 4;
        op[4] = 1;
        op[2] = 5;
        op[5] = 2;
        op[3] = 6;
        op[6] = 3;
    }
}
