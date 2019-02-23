package basic;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 构建Huffman树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        sc.close();
        Collections.sort(list);
        int len = n;
        int res = 0;
        while (list.size() != 1) {
            int tmp = list.get(0) + list.get(1);
            list.remove(0);
            list.remove(0);
            list.add(tmp);
            res += tmp;
            Collections.sort(list);
        }
        System.out.println(res);

    }
}
