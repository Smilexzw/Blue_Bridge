package train;


import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 全排列 {
    static int ans;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        f(arr, 0);
        System.out.println(ans);
    }

    private static void f(int[] arr, int k) {
        if (k == arr.length - 1) {
            print(arr);
            ans++;
        }

        for (int i = k; i < arr.length; i++) {
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            f(arr, k + 1);

            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
