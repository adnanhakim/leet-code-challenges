package MayChallenges;

import java.util.ArrayList;
import java.util.List;

/*
May 29

Question: Course Schedule
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

https://leetcode.com/explore/featured/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3344/
*/

class May29 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();

        for (int[] pre : prerequisites)
            graph[pre[0]].add(pre[1]);

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    public boolean dfs(List<Integer>[] graph, int[] visited, int val) {
        if (visited[val] == 1)
            return false;

        visited[val] = 1;
        for (int node: graph[val]) {
            if (!dfs(graph, visited, node))
                return false;
        }
        visited[val] = 2;
        return true;
    }
}
