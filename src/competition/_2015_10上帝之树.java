package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 在X森林里，上帝创建了生命之树。 他给每棵树的每个节点（叶子也称为一个节点）上，都标了一个整数，代表这个点的和谐值。 上帝要在这棵树内选出一个非空节点集S，使得对于S中的任意两个点a,b，都存在一个点列 {a, v1, v2, ..., vk, b} 使得这个点列中的每个点都是S里面的元素，且序列中相邻两个点间有一条边相连。 
 * 在这个前提下，上帝要使得S中的点所对应的整数的和尽量大。 这个最大的和就是上帝给生命之树的评分。  
 * 经过atm的努力，他已经知道了上帝给每棵树上每个节点上的整数。但是由于 atm 不擅长计算，他不知道怎样有效的求评分。他需要你为他写一个程序来计算一棵树的分数。   
 * <p>
 * <p>
 * 「输入格式」 
 * 第一行一个整数 n 表示这棵树有 n 个节点。 第二行 n 个整数，依次表示每个节点的评分。 
 * 接下来 n-1 行，每行 2 个整数 u, v，表示存在一条 u 到 v 的边。由于这是一棵树，所以是不存在环的。   
 * 「输出格式」 
 * 输出一行一个数，表示上帝给这棵树的分数。   
 * 「样例输入」 
 * <p>
 * 5 
 * 1 -2 -3 4 5
 * <p>
 * 4 2
 * <p>
 * 3 1
 * <p>
 * 1 2
 * <p>
 * 2 5   
 * 「样例输出」
 * <p>
 *  8   
 * 「数据范围」 
 * 对于 30% 的数据，n <= 10 
 * 对于 100% 的数据，0 < n <= 10^5, 每个节点的评分的绝对值不超过 10^6 。   
 * 资源约定： 
 * 峰值内存消耗 < 256M CPU消耗  < 3000ms
 * ---------------------
 * 作者：i逆天耗子丶
 * 来源：CSDN
 * 原文：https://blog.csdn.net/qq_34594236/article/details/53769848
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class _2015_10上帝之树 {

    private static int n;
    private static long[] w;      // 每一个结点的权重
    private static List<Integer>[] g;  // 使用list数组来存放邻接结点
    private static long ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = new long[n + 1];
        g = new ArrayList[n + 1];
        initG();
        for (int i = 1; i < n + 1; i++) {
            w[i] = sc.nextLong();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1, 0);
        System.out.println(ans);
    }


    /**
     * root作为根所代表的子树有一个最大权和， 将其储存在w[root]中
     * @param root
     * @param fa
     */
    private static void dfs(int root, int fa) {
        for (int i = 0; i < g[root].size(); i++) {
            Integer son = g[root].get(i);
            if (son == fa) continue;
            dfs(son, root);

            if (w[son] > 0)
                w[root] += w[son];
        }

        if (w[root] > ans) ans = w[root];
    }

    /**
     * 初始化G, 用来模拟邻接表
     */
    private static void initG() {
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }

    }


}
