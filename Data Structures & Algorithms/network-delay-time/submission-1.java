class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // times[i][0] = ui, source node (start vertex)
        // times[i][1] = vi, target node (end vertex)
        // times[i][2] = ti, time to travel from ui -> vi (edge distance)
        // n = number of nodes
        // k = source/starting node where signal will come from
        // need to find, minimum time for all n nodes to receive signal from 'k'.
        // single source shortest path / greedy
        Map<Integer, List<int[]>> adjList = toAdjList(times, n);

        // use pq
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // start from 'k'
        minHeap.offer(new int[]{k, 0});
        // use modified dijkstra such that we only consider the total time it takes to reach all of the node
        // at minimum. it means we need to empty the pq, and if there are any "untouched" nodes, we return -1;
        Map<Integer, Integer> visited = new HashMap<>();
        int min = 0;

        while(!minHeap.isEmpty()) {
            if(visited.size() == n) {
                // no use draining the heap since everything is already visited
                break;
            }
            int[] current = minHeap.poll();
            int v = current[0];
            int t = current[1];
            if(visited.containsKey(v)) {
                continue;
            }
            visited.put(v, t);
            min = t;
            for(int[] neighbor : adjList.get(v)) {
                // query the neighbors of 'v'
                int nextNode = neighbor[0];
                int nodeTime = neighbor[1];
                if(visited.containsKey(nextNode))
                    continue;
                minHeap.offer(new int[]{nextNode, nodeTime + t});
            }
        }
        // then check if there are still nodes in adjList not in visited if that's the case, there are some unreachable nodes
        if(visited.size() < n) {
            return -1;
        }
        return min;
    }
    private Map<Integer, List<int[]>> toAdjList(int[][] edgeList, int n) {
        // init map
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        // 1 to n:
        for(int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        // load the adjacency list with data from edgelist
        for(int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
        }
        return adjList;
    }
}
