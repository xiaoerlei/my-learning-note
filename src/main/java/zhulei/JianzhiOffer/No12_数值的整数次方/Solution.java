package zhulei.JianzhiOffer.No12_数值的整数次方;

/**
 * @Author: zl
 * @Date: 2019/5/26 10:45
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Power(2.5, 2));

        System.out.println(otherSolution(2.5, 2));
    }

    // 直接调库
    public static double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    // 一般做法(不调用Math库)
    // 分别从exponent = 1、0、<0 和 >0 四种情况来判断
    public static double otherSolution(double base, int exponent) {
        if(exponent == 0)
            return 1;

        if(exponent == 1)
            return base;

        double result = base;

        if(exponent < 0){
            exponent = -exponent;
            while (exponent > 1){
                result *= base;
                exponent--;
            }
            result = 1 / result;
        } else {
            while (exponent > 1){
                result *= base;
                exponent--;
            }
        }
        return result;
    }
}
