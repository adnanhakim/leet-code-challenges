package JulyChallenges;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
July 17

Question: Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
*/

class July17 {
    static class Key {
        int val;
        int frequency;

        Key(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] arr = new int[k];
        int index = 0;

        for (int num : nums)
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

        PriorityQueue<Key> queue = new PriorityQueue<>(hashMap.size(), (k1, k2) -> k2.frequency - k1.frequency);

        for (Map.Entry element : hashMap.entrySet()) {
            queue.add(new Key((int) element.getKey(), (int) element.getValue()));
        }

        while (k > 0) {
            arr[index++] = queue.remove().val;
            k--;
        }

        return arr;
    }
}
