/**
 * 反转一个只有3位数的整数。
 *
 * @author lxy54
 * @since 2018/5/4
 */
public class N0037_Reverse3DigitInteger {

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public static int reverseInteger(int number) {

        //123 -->321
        // write your code here
        //直接计算个十百，
        return (number%10*100)+(number/100) + (number/10%10*10);
        //拼接字符串
        //return Integer.valueOf(number%10+""+number/10%10+""+number/100);

    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
    }
}
