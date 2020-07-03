package JulyChallenges;

import java.util.Arrays;
import java.util.HashSet;

/*
July 3

Question: Prison Cells After N Days
There are 8 prison cells in a row, and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:
If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/
*/

class July3 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) return cells;

        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) {
                set.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++)
                cells = nextDay(cells);
        }

        return cells;
    }

    public int[] nextDay(int[] cells) {
        int[] temp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++)
            temp[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
        return temp;
    }
}
