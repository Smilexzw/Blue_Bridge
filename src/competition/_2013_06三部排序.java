package competition;

/**
 * @Auther: xuzhangwang
 * @Description: 三部排序
 * 一般的排序有许多经典算法，如快速排序、希尔排序等。
    但实际应用时，经常会或多或少有一些特殊的要求。我们没必要套用那些经典算法，可以根据实际情况建立更好的解法。
    比如，对一个整型数组中的数字进行分类排序：
    使得负数都靠左端，正数都靠右端，0在中部。注意问题的特点是：负数区域和正数区域内并不要求有序。可以利用这个特点通过1次线性扫描就结束战斗!!
    以下的程序实现了该目标。
    static void sort(int[] x)
    {
        int p = 0;
        int left = 0;
        int right = x.length-1;
        
        while(p<=right){
            if(x[p]<0){
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            }
            else if(x[p]>0){
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;            
            }
            else{
                _________________________;  //代码填空位置
            }
        }
    }

   如果给定数组：
   25,18,-2,0,16,-5,33,21,0,19,-16,25,-3,0
   则排序后为：
   -3,-2,-16,-5,0,0,0,21,19,33,25,16,18,25
 */
public class _2013_06三部排序 {
    public static void main(String[] args) {
        // -3,-2,-16,-5,0,0,0,21,19,33,25,16,18,25
        int[] x = {25, 18, -2, 0, 16, -5, 33, 21, 0, 19, -16, 25, -3, 0};
        sort(x);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + "\t");
        }
    }

    public static void sort(int[] x) {
        int p = 0;
        int left = 0;
        int right = x.length - 1;
        while (p <= right) {
            if (x[p] < 0) {
                int t = x[left];
                x[left] = x[p];
                x[p] = t;
                left++;
                p++;
            } else if (x[p] > 0) {
                int t = x[right];
                x[right] = x[p];
                x[p] = t;
                right--;
            } else {
                // 代码填空的位置
                // 这里是处理x[p] == 0 的状态
                // 这里用p的做的是遍历指针, 如果当前的位置为0， 直接与left交换， left不移动, 这样就实现了左中交换
                int t = x[p];
                x[p] = x[left];
                x[left] = t;
                p++;
            }
        }
    }
}
