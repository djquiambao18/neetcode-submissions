class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // convert to adjList, key is the source node, the values are the destination node and cost to get there:
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        // initialize the vertices up to 'n'
        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        // i.e. insert v, w as values to 'u'.
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            // add the entry into the map
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
        }

        // we need to use priority queue for picking and updating the shortest path so far
        // each entry will be the values v, w
        // we mark visits after we poll them from the queue since they will be ranked accordingly.
        // [0] = key/index/node 'v', [1] is w
        PriorityQueue<int[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(val -> val[1]));
        // also need a map as return value for this method
        // this will contain the mapping of each of the nodes distance starting from src
        // after we process / visit them.
        Map<Integer, Integer> visited = new HashMap<>();
        //start from src with a distance of 0
        toVisit.offer(new int[]{src, 0});
        // dont mark visited yet until it gets processed
        while(!toVisit.isEmpty()) {
            int[] current = toVisit.poll();
            int v = current[0]; // index of 'v' node
            int w = current[1]; // cost of v from source
            // check if the current node has already been stored in the shortest paths, skip if so
            if(visited.containsKey(v))
                continue;
            // otherwise, mark visited:
            visited.put(v, w);
            // explore the neighbors of 'v' to be queued into the heap
            for(int[] nextNode : adjList.get(v)) {
                int nextV = nextNode[0];
                int nextW = nextNode[1];
                // dont add to heap if the nextNode is already visited
                if(!visited.containsKey(nextV)) {
                    // relaxation
                    int dist = w + nextW;
                    // if(dist < w) {
                        toVisit.offer(new int[]{nextV, dist});
                    // }
                }

            }
        }
        // for all unreachable vertices, add them to the map with distance of -1
        for(int i : adjList.keySet()) {
            visited.putIfAbsent(i, -1);
        }
        return visited;
    }  
}
