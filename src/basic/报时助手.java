package basic;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 报时助手 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // h表示的为时, m 表示的是分钟
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(timeFomart(h, m));
    }

    /**
     * 报时助手
     * @param h
     * @param m
     * @return
     */
    public static String timeFomart(int h, int m) {
        if (h > 24 || m > 60) {
            return " ";
        }
        if (m == 0) {
            return numToEng(h) + " o'clock";
        }
        return valid(h) + " " + valid(m);
    }

    public static String valid(int time) {
        if (0 < time && time <= 20 || time % 10 == 0) {
            return numToEng(time);
        } else {
            return numToEng(time - time % 10) + " " + numToEng(time % 10);
        }
    }

    public static String numToEng(int time) {
        switch (time) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            case 20:
                return "twenty";
            case 30:
                return "thirty";
            case 40:
                return "forty";
            case 50:
                return "fifty";
        }
        return "o'clock";
    }
}
