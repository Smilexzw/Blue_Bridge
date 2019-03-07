package train;

/**
 * @Auther: xuzhangwang
 * @Description: 基本思路：求全组合，假设由原来的元素有n个，最总组合的结果为2^n个
 * 使用的是位操作
 *
 * 假设原来的元素为 {"a", "b", "c"}
 * 全组合的为 {"a", "b", "c", "ab", "ac", "bc" "abc"}
 * 对应的结果是 100 1010  001 110    101   011  111
 * 所以结果是 0 ~ 2^n - 1
 */
public class 全组合 {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        int n = str.length;
        int nbit = 1 << n;
        System.out.println("全组合个数：" + nbit);
        for (int i = 0; i < nbit; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j;
                if ((tmp & i) != 0) {
                    System.out.print(str[j]);
                }
            }
            System.out.println();
        }
    }
}
