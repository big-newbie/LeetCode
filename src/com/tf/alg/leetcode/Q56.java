package com.tf.alg.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tingfang
 * 2018-09-13
 */
public class Q56 {
    private static List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }
        if (intervals.size() == 1) {
            return intervals;
        }
        intervals.sort(Comparator.<Interval>comparingInt(a -> a.start).thenComparingInt(a -> a.end));
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start == 0 ? o1.end - o2.end : o1.start - o2.start;
            }
        });
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (cur.end < next.start) {
                list.add(cur);
                cur = next;
            } else {
                cur.end = Math.max(cur.end, next.end);
            }
        }
        list.add(cur);
        return list;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}