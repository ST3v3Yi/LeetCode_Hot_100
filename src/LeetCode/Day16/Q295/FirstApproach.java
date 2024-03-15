package LeetCode.Day16.Q295;

import org.junit.Test;

import java.util.*;

public class FirstApproach {
    @Test
    public void justTest() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
class MedianFinder {
    List<Integer> arr;
    public MedianFinder() {
        arr = new ArrayList<>();
    }

    public void addNum(int num) {
        arr.add(num);
        Collections.sort(arr);
    }

    public double findMedian() {
        if (arr.size() % 2 == 1) {
            return (double)arr.get(arr.size() / 2);
        }
        return (double)(arr.get(arr.size() / 2 ) + arr.get(arr.size() / 2 - 1)) / 2;
    }
}
