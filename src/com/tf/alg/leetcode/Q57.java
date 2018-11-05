package com.tf.alg.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tingfang
 * 2018-11-05
 */
public class Q57 {
    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        List<Interval> ret = new LinkedList<>();
        if (intervals == null || intervals.isEmpty()) {
            ret.add(newInterval);
            return ret;
        }
        List<Interval> after = new LinkedList<>();
        List<Interval> hasIntersection = new LinkedList<>();
        for (Interval temp : intervals) {
            if (temp.end < newInterval.start) {
                ret.add(temp);
            } else if (temp.start > newInterval.end) {
                after.add(temp);
            } else {
                hasIntersection.add(temp);
            }
        }
        if (!hasIntersection.isEmpty()) {
            newInterval.start = Math.min(newInterval.start, hasIntersection.get(0).start);
            newInterval.end = Math.max(newInterval.end, hasIntersection.get(hasIntersection.size() - 1).end);
        }
        ret.add(newInterval);
        ret.addAll(after);
        return ret;
    }

    public static void main(String[] args) {

        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);
        System.out.println(insert(intervals, newInterval));

        intervals.clear();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        newInterval = new Interval(4, 8);

        System.out.println(insert(intervals, newInterval));
    }

    private static class Interval {
        int start;
        int end;

        public Interval() { }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}