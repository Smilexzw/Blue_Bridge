package competition;

import java.util.Calendar;

/**
 * @Auther: xuzhangwang
 * @Description: 世界末日
 * 曾有邪教称1999年12月31日是世界末日。当然该谣言已经不攻自破。
    还有人称今后的某个世纪末的12月31日，如果是星期一则会....
    有趣的是，任何一个世纪末的年份的12月31日都不可能是星期一!! 
    于是，“谣言制造商”又修改为星期日......
    1999年的12月31日是星期五，请问：未来哪一个离我们最近的一个世纪末年（即xx99年）的12月31日正好是星期天（即星期日）？
    请回答该年份（只写这个4位整数，不要写12月31等多余信息
 *
 */
public class _2013_01世纪末的星期 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 1999; ; i += 100) {

            // 注意的几个点， Calendar 中月份从0 开始， 西方中星期天为第一天
            calendar.set(i, 11, 31);
            System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}
