package AugustChallenges;

import java.util.ArrayList;
import java.util.List;

/*
August 2

Question: Design HashSet
Design a HashSet without using any built-in hash table libraries.
To be specific, your design should include these functions:
1 -> add(value): Insert a value into the HashSet.
2 -> contains(value) : Return whether the value exists in the HashSet or not.
3 -> remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3410/
*/

class August2 {
    /** Initialize your data structure here. */
    int m = 10001;
    List<Integer>[] list;

    public August2() {
        this.list = new List[m];
    }

    public void add(int key) {
        int index = hash(key);
        List<Integer> indexList = this.list[index];
        if (indexList == null)
            indexList = new ArrayList<>();
        if (indexList.indexOf(key) < 0)
            indexList.add(key);
        list[index] = indexList;
    }

    public void remove(int key) {
        int index = hash(key);
        if (list[index] == null)
            return;
        List<Integer> indexList = this.list[index];
        if (indexList.contains(key))
            indexList.remove((Integer) key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        if (list[index] == null)
            return false;
        List<Integer> indexList = this.list[index];
        return indexList.contains(key);
    }

    public int hash(int n) {
        return n % m;
    }
}
