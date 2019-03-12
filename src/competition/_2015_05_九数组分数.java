package competition;

/**
 * @Auther: xuzhangwang
 * @Description: 九数组分数
 * <p>
 * 1,2,3...9 这九个数字组成一个分数，其值恰好为1/3，如何组法？
 * <p>
 * 下面的程序实现了该功能，请填写划线部分缺失的代码。
 * <p>
 * public class A
 * {
 * public static void test(int[] x)
 * {
 * int a = x[0]*1000 + x[1]*100 + x[2]*10 + x[3];
 * int b = x[4]*10000 + x[5]*1000 + x[6]*100 + x[7]*10 + x[8];
 * if(a*3==b) System.out.println(a + " " + b);
 * }
 * <p>
 * public static void f(int[] x, int k)
 * {
 * if(k>=x.length){
 * test(x);
 * return;
 * }
 * <p>
 * for(int i=k; i<x.length; i++){
 * {int t=x[k]; x[k]=x[i]; x[i]=t;}
 * f(x,k+1);
 * _______________________________________       // 填空
 * }
 * }
 * <p>
 * public static void main(String[] args)
 * {
 * int[] x = {1,2,3,4,5,6,7,8,9};
 * f(x,0);
 * }
 * }
 * <p>
 * 注意，只能填写缺少的部分，不要重复抄写已有代码。不要填写任何多余的文字。
 */
public class _2015_05_九数组分数 {

    // 我看代码就感觉像回溯
    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(x, 0);
    }

    public static void test(int[] x) {
        int a = x[0] * 1000 + x[1] * 100 + x[2] * 10 + x[3];
        int b = x[4] * 10000 + x[5] * 1000 + x[6] * 100 + x[7] * 10 + x[8];
        if (a * 3 == b) System.out.println(a + " " + b);
    }

    public static void f(int[] x, int k) {
        if (k >= x.length) {
            test(x);
            return;
        }

        for (int i = k; i < x.length; i++) {
            {
                int t = x[k];
                x[k] = x[i];
                x[i] = t;
            }
            f(x, k + 1);

            // 下面位置是填空, 个人的感觉是这个地方填写回溯的代码


            int t = x[k];
            x[k] = x[i];
            x[i] = t;

            // 经过测试果然就是这个

        }
    }
}
