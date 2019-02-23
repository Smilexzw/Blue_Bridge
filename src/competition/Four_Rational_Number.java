package competition;

/**
 * @Auther: xuzhangwang
 * @Description: 有理数类
 * 有理数就是可以表示两个整数的比值的数字，一般情况下，我们近似的小数表示，但是有的时候
 * 不允许出现误差， 必须用两个整数表示一个有理数
 *
 *
 *
 * gcd 使用的方法欧几里得算法 ，是求两个数字之间的最大公约数
 */
public class Four_Rational_Number {
    public static void main(String[] args) {
        Rational a = new Rational(4, 7);
        Rational b = new Rational(1, 6);
        Rational c = a.add(b);
        System.out.println(a + "+" + b + "=" + c);
    }


}
class Rational {
    private long ra;
    private long rb;

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public Rational(long a, long b) {
        ra = a;
        rb = b;
        long k = gcd(ra, rb);
        if (k > 1) {  // 需要约分
            ra /= k;
            rb /= k;
        }
    }


    // 加法
    public Rational add(Rational x) {
        // 此处是填空的位置
        return new Rational(ra * x.rb + x.ra * rb , rb * x.rb);
    }

    // 乘法
    public Rational mul(Rational x) {
        return new Rational(ra * x.ra, rb * x.rb);
    }

    public String toString() {
        if (rb == 1) return "" + ra;
        return ra + "/" + rb;
    }
}


