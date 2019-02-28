package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description:
 * X 国王有一个地宫宝库。是 n x m 个格子的矩阵。每个格子放一件宝贝。每个宝贝贴着价值标签。
 * 地宫的入口在左上角，出口在右下角。 小明被带到地宫的入口，国王要求他只能向右或向下行走。
 * 走过某个格子时，如果那个格子中的宝贝价值比小明手中任意宝贝价值都大，小明就可以拿起它（当然，也可以不拿）。
 * 当小明走到出口时，如果他手中的宝贝恰好是k件，则这些宝贝就可以送给小明。
 * 请你帮小明算一算，在给定的局面下，他有多少种不同的行动方案能获得这k件宝贝。 

【数据格式】 

   输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
    接下来有 n 行数据，每行有 m 个整数 Ci(0<=Ci<=12)代表这个格子上的宝物的价值 要求输出一个整数，表示正好取k个宝贝的行动方案数。
    该数字可能很大，输出它对 1000000007 取模的结果。

例如，输入： 2 2 2 1 2 2 1 程序应该输出： 2 再例如，输入： 2 3 2 1 2 3 2 1 5 程序应该输出： 14
资源约定： 峰值内存消耗（含虚拟机） < 256M CPU消耗 < 2000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。 

注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。 注意：主类的名字必须是：Main，否则按无效代码处理。 






    思路： 类似与做解救小哈，地下迷宫问题，做两次深搜，第一次找出路， 第二次来用来选择选与不选



 *
 */
public class _2014_09地宫取宝 {
    static int ans  = 0, k, curk , listlen;
    static int max = Integer.MIN_VALUE;
    static int[][] matrix;
    static int[][] place;   // 0代表没有走过 1代表走过
    static List<Integer> list;

    static int[][] next = { {0, 1} , {1, 0}};  // 向右走，向下走
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        matrix = new int[n][m];
        place = new int[n][m];
        place[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        dp(matrix, 0, 0);
        System.out.println(ans % 1000000007);
    }

    private static void dp(int[][] m, int x, int y) {
        int tx = 0, ty = 0;
        // 走到了右下角的位置，并且当前拿到的物品 == k
        if (x == m.length - 1 && y == m[0].length - 1) {
            // 获取经过的点的宝藏和值
            deal();


        } else {
            // 枚举走法  向下走，向右走
            for (int k = 0; k < 2; k++) {
                tx = x + next[k][0];
                ty = y + next[k][1];
                if (tx < 0 || tx > m.length - 1 || ty < 0 || ty > m[0].length - 1) continue;
                if (place[tx][ty] == 0) {
                    place[tx][ty] = 1;
                    dp(m , tx, ty);
                    place[tx][ty] = 0;
                }
            }
        }



    }

    private static void deal() {
        list = new ArrayList<>();
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length; j++) {
                if (place[i][j] == 1) {
                    list.add(matrix[i][j]);
                }
            }
        }
        listlen = list.size();
        curk = 0;
        dp2(0);
    }

    private static void dp2(int index) {
        if (index == listlen) {
            if (curk == k) {
                ans++;
            }
        } else {
            if (list.get(index) > max) {
                int t = max;
                max = list.get(index);
                curk++;
                dp2(index + 1);
                max = t;
                curk--;

                // 上面回溯代表当前的位置 不合适，走下一步
                dp2(index + 1);
            } else {
                // 直接跳过当前的宝藏
                dp2(index + 1);
            }
        }
    }


}
