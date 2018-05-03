/**
 * 查找字符串
 *
 * 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回 -1。
 *
 *
 * O(n2)的算法是可以接受的。如果你能用O(n)的算法做出来那更加好。（提示：KMP）
 * @author lxy54
 * @since 2018/5/3
 */
public class N0013_ImplementStrstr {



    public int strStr(String source, String target) {
        if (source==null||target==null) return -1;
        // write your code here
        return source.indexOf(target);
    }

}
