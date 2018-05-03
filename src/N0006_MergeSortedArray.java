import java.util.Arrays;

/**
 *  合并排序数组 II
 *
 *  合并两个排序的整数数组A和B变成一个新的数组。
 *
 *  给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 *
 * @author lxy54
 * @since 2018/5/3
 */
public class N0006_MergeSortedArray {

    //TODO 此题需要重新写。
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] C = new int[A.length+B.length];
        for (int i=0;i<A.length;i++) {
            C[i] = A[i];
        }
        for (int i=0;i<B.length;i++) {
            C[i+A.length] = B[i];
        }
        Arrays.sort(C);
        return C;
    }

}
