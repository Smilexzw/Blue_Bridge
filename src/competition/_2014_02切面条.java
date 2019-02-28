package competition;

/**
 * @Auther: xuzhangwang
 * @Description:
 * 一根高筋拉面，中间切一刀，可以得到2根面条。
如果先对折1次，中间切一刀，可以得到3根面条。
如果连续对折2次，中间切一刀，可以得到5根面条。
那么，连续对折10次，中间切一刀，会得到多少面条呢？
 */
public class _2014_02切面条 {

    public static void main(String[] args) {
        /*
            观察上面的算式可以发现是个规律题目
            1   2
            2   5
            3   9
            4   17

            大家可以用自己的纸进行模拟
            看出规律为 2 ^ n + 1
        */
        System.out.println(Math.pow(2, 10) + 1);

        // 结果为1025



    }
}
