import java.util.Arrays;

/**
 * 给定一个字符串和一个偏移量，根据偏移量旋转字符串(从左向右旋转)
 *
 *对于字符串 "abcdefg".
 * offset=0 => "abcdefg"
 offset=1 => "gabcdef"
 offset=2 => "fgabcde"
 offset=3 => "efgabcd"
 * @author lxy54
 * @since 2018/5/7
 */
public class N0008_RotateString {
    public static void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length==0 || offset%str.length==0){
            return;
        } else if (offset>str.length) {
            offset = offset%str.length;
        }
        int count=0;
        // abcde fg
        //
        System.out.println("需要旋转的字符串长度:" + str.length + "  偏移量：" + offset);
        rotateStringFun(str, offset, str.length, count);
        System.out.println(Arrays.toString(str));
    }
    //递归实现
    public static void rotateStringFun(char[] str, int offset, int strLength, int count){
        System.out.println("进入一次递归"+count);
        int lastsome = (strLength-offset)%offset;//还差多少位的时候，开始内部交换，内部交换完了，再继续外部交换
        for (int i=strLength-offset-1;i>-1;i--) {//倒序
            char tmp = str[i];
            str[i] = str[i+offset];
            str[i+offset] = tmp;
            count++;
            //当不够换的时候，内部先按照不够量移动一次，再继续
        }
        if (lastsome>0) {//向左2次，等于向右 3-2
            rotateStringFun(str, offset-lastsome, offset, count);
            return;
        }
        System.out.println("循环的次数"+count);
    }

    public static void main(String[] args) {
        rotateString("abcdefghijklmnopqrstuvwx".toCharArray(), 23);
    }
}
