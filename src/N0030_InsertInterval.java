import java.util.ArrayList;
import java.util.List;

/**
 *  插入区间
 *
 *
 * Insert (2, 5) into [(1,2), (5,9)], we get [(1,9)].
 * Insert (3, 4) into [(1,2), (5,9)], we get [(1,2), (3,4), (5,9)].
 * @author lxy54
 * @since 2018/5/3
 */
public class N0030_InsertInterval {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {


        // write your code here
        List<Interval> intervalsNew = new ArrayList<>();
        if (intervals==null || intervals.size()==0) {
            intervalsNew.add(newInterval);
            return intervalsNew;
        }
        //is add
        boolean isAdd = false;
        int modify = -1;
        for (int i=0;i<intervals.size();i++) {
            Interval interval = intervals.get(i);
            if (!isAdd) {//如果没有处理的话
                if (interval.start<=newInterval.start && interval.end>=newInterval.end) {//在区间内
                    isAdd = true;
                    intervalsNew.add(interval);
                } else if (interval.start>=newInterval.start && interval.end<=newInterval.end) {
                    modify = i;
                    isAdd = true;
                    intervalsNew.add(newInterval);
                }  else if (interval.start<=newInterval.start && interval.end>=newInterval.start) {//如果尾巴相等，那么就要合并
                    isAdd = true;
                    Interval interval2 = new Interval(interval.start,
                            newInterval.end>=interval.end?newInterval.end:interval.end);
                    intervalsNew.add(interval2);
                    modify = i;
                } else if (interval.start<=newInterval.end && interval.end>=newInterval.end) {//头相等
                    isAdd = true;
                    modify = i;
                    Interval interval2 = new Interval(newInterval.start<=interval.start?newInterval.start:interval.start,
                            interval.end);
                    intervalsNew.add(interval2);
                } else if (interval.start>newInterval.end) {//我的开始比你的结束还要大
                    isAdd = true;
                    intervalsNew.add(newInterval);
                    intervalsNew.add(interval);
                } else {
                    intervalsNew.add(interval);
                }
            } else {//已经处理
                intervalsNew.add(interval);
            }
            if (i==intervals.size()-1 && !isAdd) {
                intervalsNew.add(newInterval);
            }

        }
        System.out.println(modify);

        if (modify==-1 || modify+1>intervalsNew.size()) {
            return intervalsNew;
        }
        Interval i1 = intervalsNew.get(modify);//只有可能向后合并
        int i = 1;
        while (modify+1<intervalsNew.size()) {
            Interval i2 = intervalsNew.get(modify+1);
            if (i1.end<i2.start) {//说明要合并
                break;
            }
            intervalsNew.set(modify, new Interval(i1.start,
                    i1.end>=i2.end?i1.end:i2.end));
            intervalsNew.remove(modify+1);
        }
        return intervalsNew;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}