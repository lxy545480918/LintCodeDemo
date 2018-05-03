/**
 * 第k个排列
 * 给定 n 和 k，求123..n组成的排列中的第 k 个排列。
 *
 * O(n*k) in time complexity is easy, can you do it in O(n^2) or less?
 * @author lxy54
 * @since 2018/5/3
 */
public class N0388_PermutationSequence {

    public static String getPermutation(int n, int k) {
        if (n<=1) {
            return ""+n;
        }
        int total = 1;
//        List<Integer> list = new LinkedList<Integer>();
        int[] nums = new int[n];
        for (int i=1;i<=n;i++) {
            total *= i;
//            list.add(i);
            nums[i-1]=i;
        }


        StringBuffer str = new StringBuffer();
        int nowLength = n;
        while(true) {
            //有小数就不动，没有小数就要减1
            //此处，如果没有小数，直接把剩余的项目排列好

            int yushu = k*nowLength%total;
            int index;//
            if (yushu==0) {
                index = k*nowLength/total-1;
            } else {
                index = k*nowLength/total;
            }
            total /= nowLength;
            k = k-index*total;
//            while (nums[index+isAddOne]<0){//这个1应该n在上面的基础上+1，
//                index++;
//            }
            int aa = nums[index];
            //nums[index] = -1;
            str.append(aa);//主要修改这里

            for(int j=0;j<nowLength-index-1;j++) {
                nums[j+index] = nums[j+index+1];
            }

            //deleteIndex++;
//            System.arraycopy(nums, index+1, nums, index,
//                    nowLength - index - 1);
            nowLength--;
//            list.remove(index);
            if (yushu==0) {//倒序
                for (int j=nowLength-1;j>-1;j--) {
                    str.append(nums[j]);
                }
                break;
            }
            if (k==0) {//正序
                for (int j=0;j<nowLength;j++) {
                    str.append(nums[j]);
                }
                break;
            }
        }
        return str.toString();

    }

}
