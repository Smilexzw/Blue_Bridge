package competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 第四届 幸运数
 * 标题：幸运数

    幸运数是波兰数学家乌拉姆命名的。它采用与生成素数类似的“筛法”生成。
    首先从1开始写出自然数1,2,3,4,5,6,....  
    1 就是第一个幸运数。
    我们从2这个数开始。把所有序号能被2整除的项删除，变为：
    1 _ 3 _ 5 _ 7 _ 9 ...
    把它们缩紧，重新记序，为：    
    1 3 5 7 9 .... 。这时，3为第2个幸运数，然后把所有能被3整除的序号位置的数删去。注意，是序号位置，不是那个数本身能否被3整除!! 删除的应该是5，11, 17, ...
    此时7为第3个幸运数，然后再删去序号位置能被7整除的(19,39,...)
    最后剩下的序列类似：
    1, 3, 7, 9, 13, 15, 21, 25, 31, 33, 37, 43, 49, 51, 63, 67, 69, 73, 75, 79, ...
    本题要求：
    输入两个正整数m n, 用空格分开 (m < n < 1000*1000)
    程序输出 位于m和n之间的幸运数的个数（不包含m和n）。

    例如：
    用户输入：
    1 20
    程序输出：
    5
    例如：
    用户输入：
    30 69
    程序输出：
    8
    资源约定：
    峰值内存消耗（含虚拟机） < 64M
    CPU消耗  < 2000ms
    请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
    所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
    注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
    注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class _2013_08幸运数 {
    public static void main(String[] args) {
//         先看看的暴力破解可以解决嘛？

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }


        List<Integer> current = new ArrayList<>();
        current.add(1);
        int index = 2;
        int cur = list.get(index);
        current.add(cur);
        while(cur != list.get(list.size() - 1)) {
            List<Integer> remove = new ArrayList<>();
            for (int i = 1; i < list.size(); i++) {
                if (i % cur == 0) {
                    remove.add(list.get(i));
                }
            }

            list.removeAll(remove);
            for (int i = index; i < list.size(); i++) {
                if (!current.contains(list.get(i))) {
                    cur = list.get(i);
                    current.add(cur);
                    index = i;
                    break;
                }
            }
        }
        int sum = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if (list.get(i) > m && list.get(i) < n) {
                sum++;
            } else if (list.get(i) <= m) {
                break;
            }
        }
        System.out.println(sum);


        // 这个是网上的同学写的

//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int m=in.nextInt();
//        ArrayList<Integer> num=new ArrayList<Integer>();
//        for(int i=1;i<m;i+=2){
//            num.add(i);
//        }//偶数就不用添加了
//        int j=2;//第二个幸运数
//
//        while(num.get(j-1)<=num.size()){
//            int number=num.get(j-1);//幸运数
//            for(int i=number-1;i<num.size();i=i+number-1){
//                num.remove(i);
//            }
//            j++;
//        }
//        int temp=num.size();
//        for(int i=0;i<num.size();i++)
//        {
//            if(num.get(i)<=n)temp--;
//        }
//        if(num.contains(m))temp--;
//        System.out.println(temp);

    }
}
