// You have an undirected graph of n nodes labeled from 0 to n - 1. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.

// Return the number of connected components in the graph.

// we can check the connected components using a depth-first search (DFS) or breadth-first search (BFS).
// in this case, let's use BFS
// first: convert the edge list to adjacency list
// second: keep track of visited nodes with a visited set
// third: for each unvisited node, perform BFS and mark all reachable nodes as visited
// fourth: increment the connected components count each time a BFS is initiated

// example:
// in: n = 5, edges = [[0,1], [1,2], [3,4]] -> [(u,v)]

// import java.util.Map;
// import java.util.HashMap;
// import java.util.Set;
// import java.util.HashSet;

// import java.util.List;
// import java.util.ArrayList;
// import java.util.Queue;
// import java.util.ArrayDeque;

class Solution {
  public int countComponents(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjList = adjacencyList(edges, n);
    Set<Integer> visited = new HashSet<>();
    int count = 0;
    // nodes start from 0 to n-1
    // edges = [[src, dest]]
    // edge[0] == src
    for(int i = 0; i < n; i++) {
      if(!visited.contains(i)) {
        count++;
        bfs(i, adjList, visited);
      }
    }
    return count;
  }
  private void bfs(int start, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
    Queue<Integer> q = new ArrayDeque<>();
    // start from the given node
    q.offer(start);
    // add it to visited set
    visited.add(start);
    while(!q.isEmpty()) {
      int curr = q.poll();
      // explore its neighbors
      for(int neighbor : adjList.get(curr)) {
        if(!visited.contains(neighbor)) {
          visited.add(neighbor);
          q.offer(neighbor);
        }
      }
    }
  }

  private Map<Integer, List<Integer>> adjacencyList(int[][] edges, int n) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    // initialize the map
    for(int i = 0; i < n; i++) {
      adjList.put(i, new ArrayList<>());
    }
    for(int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      adjList.get(u).add(v);
      // since it's undirected, create an edge back towards u
      adjList.get(v).add(u);
      
    }
    return adjList;
  }
}