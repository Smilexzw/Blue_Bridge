package competition;

/**
 * @Auther: xuzhangwang
 * @Description: 振兴中华
 * 小明参加了学校的趣味运动会，其中的一个项目是：跳格子。
    地上画着一些格子，每个格子里写一个字，如下所示：（也可参见p1.jpg）
        从我做起振
        我做起振兴
        做起振兴中
        起振兴中华
    比赛时，先站在左上角的写着“从”字的格子里，可以横向或纵向跳到相邻的格子里，但不能跳到对角的格子或其它位置。一直要跳到“华”字结束。
    要求跳过的路线刚好构成“从我做起振兴中华”这句话。
 */
public class _2013_03振兴中华 {
    public static void main(String[] args) {
        String[][] m = {
                {"从", "我", "做", "起", "振"},
                {"我", "做", "起", "振", "兴"},
                {"做", "起", "振", "兴", "中"},
                {"起", "振", "兴", "中", "华"}
        };

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }

        int tmp = paths();
        System.out.println(tmp);



    }
    // 思路， 随便找一条路从左上角走到右边下角就可以
    public static int paths() {
        int[][] opt = new int[4][5];
        for (int i = 0; i < 4; i++) {
            opt[i][0] = 1;
        }
        for (int i = 0; i < 5; i++) {
            opt[0][i] = 1;
        }

        for (int i = 1; i < opt.length; i++) {
            for (int j = 1; j < opt[0].length; j++) {
                opt[i][j] = opt[i - 1][j] + opt[i][j - 1];
            }
        }
        // 打印数组看下
        for (int i = 0; i < opt.length; i++) {
            for (int j = 0; j < opt[0].length; j++) {
                System.out.print(opt[i][j] + "\t");
            }
            System.out.println();
        }
        return opt[opt.length - 1][opt[0].length - 1];
    }
}
