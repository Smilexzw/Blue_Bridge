package competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 * 把abcd...s共19个字母组成的序列重复拼接106次，得到长度为2014的串。


接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字母。


得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。

 */
public class _2014_03猜字母 {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrs";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 106; i++) {
            sb.append(str);
        }
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < sb.length(); i++) {
            list.add(String.valueOf(sb.charAt(i)));
        }
        while(list.size() != 1) {
            List<String> index = new ArrayList<String>();
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 0) {
                    // 在对应的位置设置Z，最后在删除有Z的位置即可
                    list.set(i, "Z");
                    index.add("Z");
                }
            }
            list.removeAll(index);
        }

        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
