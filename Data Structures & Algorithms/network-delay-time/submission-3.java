
// n directed nodes (1 to n)
// k is source of signal
// times is edge list where times[i] = {ui, vi, ti}, t == w
// find min time it takes for all n nodes to receive the signal
// return a single int result from the last node to receive the signal which should be the minimum

// example 1: times=[[1, 2, 3], [2, 3, 2], [2, 4, 7], [3, 4, 3], [4, 3, 5]]
// k = 1
// n = 5

// first convert to adjacency list (Map):
// Node -> List<int[]>
// { 1: [[2, 3]],
//   2: [[3, 2], [4, 7]],
//   3: [[4, 3]],
//   4: [[3, 5]]
// }


// in example above, the shortest time should be (through k = 1), 1 (0) -> 2 (3) -> 3 (2) -> 4 (3)
// min time: 3 + 2 + 3 = 8 units of time vs. 1(0) -> 2 (3) -> 4 (7) -> 3(5), 3 + 7 + 5 = 16 units of time

// we can perform dijkstra's shortest path on it, and use PriorityQueue (min heap) to keep track of the minimal time path
// there is a case when the result set (visited) already contains the same number of nodes as input, if so, stop traversal early

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static java.util.Comparator;

// import java.util.Map;
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.PriorityQueue;

class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
    int minimum = Integer.MAX_VALUE;
    Map<Integer, List<int[]>> adjacencyList = toAdjacencyList(times, n);
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    // need a visited map (mapping is node and time)
    // v, t
    Map<Integer, Integer> visited = new HashMap<>();
    // insert the first item (source k) into heap for exploration:
    pq.offer(new int[]{k, 0});
    while(!pq.isEmpty()) {
      // short-circuit:
      if(visited.size() == n) {
        break;
      }
      // poll:
      int[] curr = pq.poll();
      int v = curr[0];
      int t = curr[1];
      // check if it has been visited, if so, skip it
      if(visited.containsKey(v))
        continue;
      // mark as visited
      visited.put(v, t);
      minimum = t;
      // explore its neighbors and enqueue
      for(int[] neighbor : adjacencyList.get(v)) {
        int vNext = neighbor[0];
        int tNext = neighbor[1];
        // store local min into heap for relaxation and sorted order (O(log(V)) runtime
        int runningTotal = t + tNext;
        if(!visited.containsKey(vNext)) {
          pq.offer(new int[]{vNext, runningTotal});
        }
      }
    }
    // means not all nodes are reachable from 'k'
    if(visited.size() < n) {
      return -1;
    }
    return minimum;
  }

  private Map<Integer, List<int[]>> toAdjacencyList(int[][] times, int n) {
    // result map:
    Map<Integer, List<int[]>> adjList = new HashMap<>();
    for(int i = 1; i <= n; i++) {
        adjList.put(i, new ArrayList<>());
    }
    for(int[] time : times) {
      int u = time[0];
      int v = time[1];
      int t = time[2];
      adjList.computeIfAbsent(u, k -> new ArrayList<int[]>()).add(new int[]{v, t});
    }
    return adjList;
  }
}

// class Main {
//   public static void main(String[] args) {
//     Solution sol = new Solution();
//     int[][] times = {{1,2,3}, {2, 3, 2}, {2, 4, 7}, {3, 4, 3}, {4, 3, 5}};

//     // times arr, n = 4, k = 1
//     Assertions.assertEquals(sol.networkDelayTime(times, 4, 1), 8);
//   }
// }