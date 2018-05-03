import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 *
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
 *
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
 * @author lxy54
 * @since 2018/5/3
 */
public class N0056_TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] result = new int[2];
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i=0;i<numbers.length;i++) {

            if (cache.containsKey(numbers[i])) {
                result[0] = cache.get(numbers[i]);
                result[1] = i;
            } else {
                cache.put(target-numbers[i],i);
            }

        }
        return result;

    }

}
