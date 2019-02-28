package competition;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 * A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
    要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。

    请填写出所有符合要求的排列中，字典序最小的那个。

例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。


 *
 *  规定中 AA中间一张牌， 22中间2张牌，33中间3张牌，44中间4张牌
 *  Arraylist会根据自动的根据字典进行排序
 */
public class _2014_07扑克序列 {
    static List<String> list = new ArrayList<String>();
    static StringBuffer sb;
    public static void main(String[] args) {
        String[] str = {"A", "A", "2", "2", "3", "3", "4", "4"};
        f(0, str);
        System.out.println("结果：" + list.get(0));
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }

    }

    private static void f(int k, String[] str) {
        if (k == str.length - 1) {
            // 递归结束， 判断
            deal(str);
        }
        for (int i = k; i < str.length; i++) {
            String t = str[i];
            str[i] = str[k];
            str[k] = t;

            f(k + 1, str);

            // 回溯
            t = str[i];
            str[i] = str[k];
            str[k] = t;
        }
    }

    /* 用来检查当前全排列的数组是否符合题目的要求 */
    private static boolean deal(String[] str) {
        sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        if (check("A") && check("2") && check("3") && check("4")) {
            list.add(sb.toString());
            return true;
        } else {
            return false;
        }

    }

    private static boolean check(String str) {
        // 从前向后开始的第一个位置
        int a = sb.indexOf(str);
        // 从后向前开始的第一个位置
        int b = sb.lastIndexOf(str);
        int cha = b - a - 1;
        if (str == "A") {
            return cha == 1 ? true : false;
        } else if (str == "2") {
            return cha == 2 ? true : false;
        } else if (str == "3") {
            return cha == 3 ? true : false;
        } else {
            return cha == 4 ? true : false;
        }
    }


    /* 用来测试答应全排列是否正确的 */
    private static void print(String[] str) {
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println();
    }
}
