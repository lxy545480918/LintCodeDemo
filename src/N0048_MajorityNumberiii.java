import java.util.*;

/**
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
 *
 * 给出数组 [3,1,2,3,2,3,3,4,4,4] ，和 k = 3，返回 3
 * @author lxy54
 * @since 2018/5/4
 */
public class N0048_MajorityNumberiii {


    public static int majorityNumber(List<Integer> nums, int k) {
        if (nums.size()==0) {
            return -1;
        }
        if (nums.size()==1) {
            return nums.get(0);
        }
        int count = nums.size()/k+1;//必须出现这么多次，
        if (count==1) {
            return nums.get(0);
        }
        //尽量不使用map去做,map是别人写好的数据结构，
        //只要等于了这个count，就可以了
        //但是要有个地方去存储这个key，value
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i=0;i<nums.size();i++) {
            Integer num = nums.get(i);
            Integer tmpValue = map.get(num);
            if (tmpValue==null) {
                map.put(num, 1);
            } else if (tmpValue==count-1) {
                return num;
            } else {
                map.put(num, tmpValue+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityNumber(Arrays.asList(7,3,1,4,5,6,17,8,9,1), 9));
    }
}

