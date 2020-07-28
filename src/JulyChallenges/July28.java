package JulyChallenges;

import java.util.Arrays;

/*
July 28

Question: Task Scheduler
You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
You need to return the least number of units of times that the CPU will take to finish all the given tasks.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/
*/

class July28 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char task : tasks)
            count[task - 'A']++;

        Arrays.sort(count);
        int max = count[25] - 1;
        int idleSlots = max * n;

        for (int i = 24; i >= 0; i--)
            idleSlots -= Math.min(count[i], max);

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
