/**
 *  A + B 问题
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 * @author lxy54
 * @since 2018/5/3
 */
public class N0001_AplusBProblem {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        int c=a&b;//如果c=0,那么说明直接用异或就能得到求和
        int d=a^b;//异或的结果
        //如果不为0，就一直递归位移到为0为止

        //  情况 1
        //2+1
        // c 10 & 01 = 00
        // d 10 ^ 01 = 11 = 3
        //  情况 2
        // 2+3
        // c 10 & 11 = 10 不等于0 << 1 = 100
        // d 10 ^ 11 = 01
        // ----第二次--
        // 100 & 001 = 000
        // 100 ^ 001 = 101 = 5

        return c==0?d:aplusb(d, c<<1);

    }
}



