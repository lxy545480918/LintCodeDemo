/**
 * 统计数字
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
 * @author lxy54
 * @since 2018/5/3
 */
public class N0003_DigitCounts {

    public int digitCounts(int k, int n) {
        // write your code here
        if (k>n) {
            return 0;
        } else if (k==n) {
            return 1;
        }
        String sk = String.valueOf(k);
        int count=0;
        for (int i=0;i<=n;i++) {
            int index= -1;
            while ((index = String.valueOf(i).indexOf(sk, index+1)) >=0 ) {
                count++;

            }
        }
        return count;
    }

}
