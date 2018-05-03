/**
 *  分糖果
 *
 *
 * 有 N 个小孩站成一列。每个小孩有一个评级。

 按照以下要求，给小孩分糖果：

 每个小孩至少得到一颗糖果。

 评级越高的小孩可以比他相邻的两个小孩得到更多的糖果。

 需最少准备多少糖果？


 给定评级 = [1, 2], 返回 3.

 给定评级 = [1, 1, 1], 返回 3.

 给定评级 = [1, 2, 2], 返回 4. ([1,2,1]).
 *
 * @author lxy54
 * @since 2018/5/3
 */
public class N0412_Candy {

    /**
     * @param ratings: Children's ratings
     * @return: the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // write your code here
        if (ratings.length<=1) {
            return 1;
        }
        if (ratings.length==2){
            if (ratings[0]-ratings[1]!=0){
                return 3;
            } else {
                return 2;
            }
        }

        return findNextLow(ratings,-1, 0);
    }

    //写个递归了看来,start是下一个低地

    public int findNextLow(int[] ratings, int start, int maxStep){
        int total = 0;
        //重新向前走没有必要，这里用步长直接计算出结果，然后使用递归开始下一段路程
        int step = 1;//距离1的步长
        for(int i=start+1;i<ratings.length;i++) {//走
            if (i==ratings.length-1) {//已经循环到最后一步了
                if (ratings[i]>ratings[i-1]) {
                    total+= ++step;
                } else {
                    total+=1;
                }
                if (maxStep!=0 && maxStep>step) {
                    total+= maxStep-step;
                }
                continue;
            }

            if(ratings[i]>ratings[i+1]){//如果我比后面的大，那么假设后面是1，我就是2
                //问题出在这里，没有做到承上启下的作用
                total+= ++step;
            } else if ( ratings[i]<=ratings[i+1] && (i==0|| ratings[i]<=ratings[i-1])) {
                //我比后面的小，且，我比前面的也小，那么我就是1
                total+=1;//我就是1，同时递归
                if (maxStep!=0 && maxStep>step) {
                    total+= maxStep-step;
                }
                total+=findNextLow(ratings, i, 0);
                //此处就要跳出
                break;
            } else if ( ratings[i]>=ratings[i+1] && ratings[i]<=ratings[i-1]) {
                //我比后面的大，但是比前面的小，此时就要stop，把这个点放入递归
                total+=findNextLow(ratings, i-1, 0);
                //此处就要跳出
                break;
            } else if (ratings[i]>ratings[i-1] && ratings[i]<ratings[i+1]) {
                //我比前面的大，但是比后面的小，跟着步长走！
                total+= ++step;
                int needAdd = 1;
                if (maxStep!=0 && maxStep>step) {
                    needAdd +=maxStep-step;
                    total+= maxStep-step;
                }
                total+=findNextLow(ratings, i, step+needAdd);//
                break;
            } else if (ratings[i]>ratings[i-1] && ratings[i]==ratings[i+1]) {
                //我比前面的大，但是和后面的相等？
                //加几并不能确定
                total+= ++step;

                if (maxStep!=0 && maxStep>step) {
                    total+= maxStep-step;
                }

                total+=findNextLow(ratings, i, 0);
                //此处就要跳出
                break;
            } else if (ratings[i]>ratings[i-1] && ratings[i]>ratings[i+1]) {
                //我比前面的大，但是和后面的相等？
                //加几并不能确定
                //total+= ++step;
                total+=findNextLow(ratings, i-1, step+1);//这里还有一个最大最小值的取舍
                //此处就要跳出
                break;
            }
        }
        return total;
    }

}
