package competition;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _2014_09地宫取宝贝2 {
    static int n , m , k;
    static int[][] data;
    static int ans;
    static int MOD = 1000000007;
    static long[][][][] cache;
    // 先使用dfs进行搜索
    public static void main(String[] args) {
        // n m k
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        sc.close();
        cache = new long[51][51][14][14];
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                for (int l = 0; l < 14; l++) {
                    for (int o = 0; o < 14; o++) {
                        cache[i][j][l][o] = -1;
                    }
                }
            }
        }
//        dfs(0, 0, -1, 0);
//        System.out.println(ans);
//        long tmp = dfs2(0, 0 , -1, 0);
//        System.out.println(tmp);
        long result = dfs3(0, 0 , -1, 0);
        System.out.println(result);
    }

    /**
     * dfs进行深度搜索二维数组
     * @param x
     * @param y
     * @param max  max为当前获取到物品中的最大值
     * @param cnt  cnt为当前获取到的物品数目
     */
    private static void dfs(int x, int y, int max, int cnt) {
        if (x > data.length - 1 || y > data[0].length - 1) {
            return;
        }
        int cur = data[x][y];
        if (x == n - 1 && y == m - 1) {  // 目前已经到达最后一个格子面临两个决策，拿与不拿
            if (cnt == k || (cnt == k - 1 && cur > max)) {
                ans++;
                if (ans > MOD) {
                    ans %= MOD;
                }
            }
        }

        if (cur > max) { // 可以获取当前这个物品
            dfs(x + 1, y, cur, cnt + 1);
            dfs(x, y + 1, cur, cnt + 1);
        }

        // 对于价值较小的物品，或则价值不大于当前物品的最大值
        dfs(x + 1, y, max, cnt);
        dfs(x, y + 1, max, cnt);
    }


    /**
     * dfs进行深度搜索二维数组
     * @param x
     * @param y
     * @param max  max为当前获取到物品中的最大值
     * @param cnt  cnt为当前获取到的物品数目
     */
    private static long dfs2(int x, int y, int max, int cnt) {
        if (x > data.length - 1 || y > data[0].length - 1) {
            return 0;
        }
        int cur = data[x][y];
        int ans = 0;
        if (x == n - 1 && y == m - 1) {  // 目前已经到达最后一个格子面临两个决策，拿与不拿
            if (cnt == k || (cnt == k - 1 && cur > max)) return 1;
            return ans;
        }

        if (cur > max) { // 可以获取当前这个物品
            ans += dfs2(x + 1, y, cur, cnt + 1);
            ans += dfs2(x, y + 1, cur, cnt + 1);
        }

        // 对于价值较小的物品，或则价值不大于当前物品的最大值
        ans += dfs2(x + 1, y, max, cnt);
        ans += dfs2(x, y + 1, max, cnt);
        return ans % MOD;
    }


    /**
     * 记忆形dfs
     * @param x
     * @param y
     * @param max
     * @param cnt
     * @return
     */
    private static long dfs3(int x, int y, int max, int cnt) {
        if (cache[x][y][max + 1][cnt] != -1) return cache[x][y][max + 1][cnt];
        if (x > data.length - 1 || y > data[0].length - 1) {
            return 0;
        }
        int cur = data[x][y];
        long ans = 0;
        if (x == n - 1 && y == m - 1) {  // 目前已经到达最后一个格子面临两个决策，拿与不拿
            if (cnt == k || (cnt == k - 1 && cur > max)) return 1;
            return ans;
        }

        if (cur > max) { // 可以获取当前这个物品
            ans += dfs3(x + 1, y, cur, cnt + 1);
            ans += dfs3(x, y + 1, cur, cnt + 1);
        }

        // 对于价值较小的物品，或则价值不大于当前物品的最大值
        ans += dfs3(x + 1, y, max, cnt);
        ans += dfs3(x, y + 1, max, cnt);
        cache[x][y][max + 1][cnt] = ans % MOD;
        return ans;
    }
}
