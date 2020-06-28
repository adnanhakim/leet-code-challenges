package JuneChallenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
June 28

Question: Reconstruct Itinerary
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
Note:
1 -> If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
2 -> All airports are represented by three capital letters (IATA code).
3 -> You may assume all tickets form at least one valid itinerary.
4 -> One must use all the tickets once and only once.

https://leetcode.com/explore/featured/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
*/

class June28 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        buildGraph(graph, tickets);
        dfs(result, graph, "JFK");

        return result;
    }

    private void buildGraph(HashMap<String, PriorityQueue<String>> graph, List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!graph.containsKey(src))
                graph.put(src, new PriorityQueue<>());
            graph.get(src).offer(dst);
        }
    }

    private void dfs(LinkedList<String> result, HashMap<String, PriorityQueue<String>> graph, String src) {
        PriorityQueue<String> destinations = graph.get(src);
        while (destinations != null && !destinations.isEmpty()) {
            String dst = graph.get(src).poll();
            dfs(result, graph, dst);
        }

        result.addFirst(src);
    }
}
