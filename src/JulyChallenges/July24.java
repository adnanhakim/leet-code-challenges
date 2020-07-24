package JulyChallenges;

import java.util.ArrayList;
import java.util.List;

/*
July 24

Question: All Paths From Source to Target
Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

https://leetcode.com/explore/featured/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/
*/

class July24 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        List<Integer> path = new ArrayList<>();
        visited[0] = true;
        path.add(0);
        dfs(graph, visited, 0, path);
        return ans;
    }

    public void dfs(int[][] graph, boolean[] visited, int u, List<Integer> path) {
        if (u == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[u].length; i++) {
            int v = graph[u][i];
            visited[v] = true;
            path.add(v);
            dfs(graph, visited, v, path);
            visited[v] = false;
            path.remove(path.size() - 1);//}
        }
    }
}
