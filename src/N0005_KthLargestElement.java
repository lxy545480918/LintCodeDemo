import java.util.Arrays;

/**
 * 第k大元素
 * 在数组中找到第k大的元素
 * 给出数组 [9,3,2,4,8]，第三大的元素是 4
 *
 *
 * @author lxy54
 * @since 2018/5/3
 */
public class N0005_KthLargestElement {

    //TODO 此题需要重新写。
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
