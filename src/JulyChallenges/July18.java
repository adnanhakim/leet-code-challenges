package JulyChallenges;

import java.util.LinkedList;
import java.util.List;

/*
July 18

Question: Course Schedule II
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3394/
*/

class July18 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < graph.length; i++)
            graph[i] = new LinkedList<Integer>();

        for (int[] prerequisite : prerequisites)
            graph[prerequisite[1]].add(prerequisite[0]);

        List<Integer> stack = new LinkedList<>();
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (visited[i] == 0 && dfs(i, graph, stack, visited))
                return new int[0];

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++)
            result[i] = stack.get(i);

        return result;
    }

    private boolean dfs(int index, List<Integer>[] graph, List<Integer> stack, int[] visited) {
        visited[index] = 1;

        for (int neighbour : graph[index]) {
            if (visited[neighbour] == 1)
                return true;
            if (visited[neighbour] == 0 && dfs(neighbour, graph, stack, visited))
                return true;
        }

        visited[index] = 2;
        stack.add(0, index);
        return false;
    }
}
