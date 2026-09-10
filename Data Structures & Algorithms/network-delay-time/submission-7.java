class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // convert edge list to adjacency list:
        // [[1,2]] -> {1: [2]}
        // perform dijkstra's shortest path algorithm on edge list, storing it in a priority queue (min heap)
        // for processing the shortest path so far
        // add them to the visited map and their distance from 'k' node
        // we can also short-circuit when the size of the visited paths is the same as adjacency list
        // after processing, if there are unreachable nodes, return -1.
        Map<Integer, List<int[]>> adj = convertToAdjacencyList(times, n);
        // pq for relaxing the edge distances
        // keeps track of "v" and "t" in graph times
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        Set<Integer> visited = new HashSet<>();

        pq.offer(new int[]{k, 0});
        // visited.add(k);
        int minimum = 0;
        
        while(!pq.isEmpty()) {
          System.out.println("visited: " + visited.size() + ", adjSize: " + adj.size());
          if(visited.size() == adj.size()) {
            break;
          }
          int[] curr = pq.poll();
          int v = curr[0];
          int t = curr[1];
          // skip this if it's already been visited
          if(visited.contains(v)) {
            continue;
          }
          // otherwise add to the visited set
          visited.add(v);
          minimum = t;
          // get the neighbors of v
          for(int[] neighbor : adj.get(v)) {
            int nextV = neighbor[0];
            int nextT = neighbor[1];
            if(!visited.contains(nextV)) {
              pq.offer(new int[]{nextV, t + nextT});
            }
          }
        }
        return visited.size() == adj.size() ? minimum : -1;
    }
    // takes in the edge list array, and the number of nodes in the graph
    // output: adjacency list (node -> neighbor list)
    private Map<Integer, List<int[]>> convertToAdjacencyList(int[][] times, int n) {
      Map<Integer, List<int[]>> adj = new HashMap<>();
      for(int i = 1; i <= n; i++) {
        adj.put(i, new ArrayList<int[]>());
      }
      // for each entry in times, add them into the map as neighbors into the keyed entries
      for(int[] time : times) {
        int u = time[0];
        int v = time[1];
        int t = time[2];
        adj.computeIfAbsent(u, k -> new ArrayList<int[]>()).add(new int[]{v, t});
      }
      return adj;
    }
}

