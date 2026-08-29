class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // convert to adjacency list first
        Map<Integer, List<int[]>> adjList = toAdjList(edges, n);

        // need to use PriorityQueue E*log(V) runtime for sparse graphs when E ~ V
        // using minHeap, we can determine the shortest path so far, keep polling it
        // [v, w] - it also takes care of the relaxation / updation property in Dijkstra's greedy
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // add the src with distance of 0 to start exploration of graph with adjlist
        pq.offer(new int[]{src, 0});
        // this will act as our visited entries
        Map<Integer, Integer> shortest = new HashMap<>();
        // do not add to visited yet until we poll;
        while(!pq.isEmpty()) {
            // gets the shortest distance so far
            int[] current = pq.poll();
            int v = current[0];
            int w = current[1];
            // check if it's already visited, otherwise add it to the shortest path so far
            if(!shortest.containsKey(v)) {
                shortest.put(v, w);
            }
            for(int[] neighbor : adjList.get(v)) {
                int nextNode = neighbor[0];
                int nextW = neighbor[1];
                if(shortest.containsKey(nextNode)) {
                    continue;
                }
                // relaxation will happen naturally in the minHeap
                int dist = w + nextW;
                pq.offer(new int[]{nextNode, dist});
            }
        }
        // then, for all unreachable nodes, we just set it as -1 dist
        for(int i = 0; i < n; i++) {
            if(!shortest.containsKey(i)) {
                shortest.put(i, -1);
            }
        }
        return shortest;
    }

    private Map<Integer, List<int[]>> toAdjList(List<List<Integer>> edges, int n) {
        // since every node is denoted by its index (from 0 to n - 1), we need to allocate an arraylist (as neighbors)
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        // for each edge - (u, v, w)
        // then insert the vertices neighbors
        for(List<Integer> edge : edges) {
            // start node
            int u = edge.get(0);
            // dest node
            int v = edge.get(1);
            // weight
            int w = edge.get(2);
            adjList.computeIfAbsent(u, (k) -> new ArrayList<>()).add(new int[]{v, w});
        }
        return adjList;
    }
}
