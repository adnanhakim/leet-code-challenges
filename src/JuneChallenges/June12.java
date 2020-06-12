package JuneChallenges;

import java.util.ArrayList;
import java.util.HashMap;

/*
June 12

Question: Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.
1 -> insert(val): Inserts an item val to the set if not already present.
2 -> remove(val): Removes an item val from the set if present.
3 -> getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
*/

class June12 {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    /* Initialize your data structure here. */
    public June12() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /* Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /* Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index = map.getOrDefault(val, -1);
        if (index == -1)
            return false;
        int oldValue = list.get(index);
        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);

        list.remove(list.size() - 1);
        map.remove(oldValue);

        return true;
    }

    /* Get a random element from the set. */
    public int getRandom() {
        return list.get((int) Math.floor(Math.random() * list.size()));
    }
}

/*
  Your RandomizedSet object will be instantiated and called as such:
  RandomizedSet obj = new RandomizedSet();
  boolean param_1 = obj.insert(val);
  boolean param_2 = obj.remove(val);
  int param_3 = obj.getRandom();
*/
