import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 * 给定一个含不同整数的集合，返回其所有的子集
 * S = [1,2,3]
 * [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 *
 * @author lxy54
 * @since 2018/5/3
 */
public class N0017_Subsets {

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        //其实在排序的过程中，已经可以列出集合了
        Arrays.sort(nums);//先来一次排序，排序算法后面研究下

        List<List<Integer>> resultList = new ArrayList();
        resultList.add(new ArrayList());//先放入一个空的再说


        for (int i=0;i<nums.length;i++) {
            //每一次循环的时候，就放入所有和i相关的
            //1-1个 2-2个 3-4个4-8
            int count=0;
            List<Integer> l1 = new ArrayList();
            l1.add(nums[i]);
            resultList.add(l1);//此处是一个

            addNextList(nums, i+1, l1, resultList);


        }


        return resultList;
    }
    //数组和当前位置，结果集
    public void addNextList(int[] nums, int i, List<Integer> nowList, List<List<Integer>> resultList){

        for (int j=i;j<nums.length;j++) {
            List<Integer> addOneList = new ArrayList<>();
            addOneList.addAll(nowList);
            addOneList.add(nums[j]);
            resultList.add(addOneList);
            addNextList(nums, j+1, addOneList,resultList);
        }
    }
}
