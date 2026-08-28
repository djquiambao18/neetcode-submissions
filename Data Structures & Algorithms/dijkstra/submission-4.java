class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // n - vertices labeled from 0 to n - 1 (0 to 99 if 100 nodes)
        // edges - list of directed edge(s) in the form (u, v, w)
        // u - source vertex
        // v - destination vertex
        // w - weight of the edge
        // src - starting vertex
        // return a Map of integer whose values are the shortest distance from src

        // 1. convert edges from edgelist to adjacency list - need this to use dijkstra's algorithm
        // - it makes the best local choice, assuming no negative edge weights.
        // adjList.get()[0] -> v
        // adjList.get()[1] -> w
        Map<Integer, List<int[]>> adjList = toAdjList(edges, n);
        // let us assume the constraint is a dense graph (E ~ V^2)
        // so we use array-based dijkstra, distance is used to track the distance so far for each of the nodes
        int[] distance = new int[n];
        // initialize all distances to be infinite
        Arrays.fill(distance, Integer.MAX_VALUE);
        // start with src to be
        distance[src] = 0;

        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for(int i = 0; i < n; i++) {
            // we'll use this for node index
            int v = -1;
            // do linear scan over the distance array to check for the shortest distance so far
            for(int node = 0; node < n; node++) {
                // check if its not already the shortest distance, and 
                if(!shortestPaths.containsKey(node) && (v == -1 || distance[node] < distance[v])) {
                    v = node;
                }
            }
            // skip if 'v' is unreachable from src
            if(v == -1 || distance[v] == Integer.MAX_VALUE) {
                break;
            }
            // Otherwise, insert into the shortestPaths for visited:
            shortestPaths.put(v, distance[v]);
            // explore next possible paths from 'v' 
            for(int[] next : adjList.get(v)) {
                int nextV = next[0], w = next[1];
                // relaxation
                if(!shortestPaths.containsKey(nextV) && distance[v] + w < distance[nextV]) {
                    distance[nextV] = distance[v] + w;
                }
            }
        }
        // then, for all unreachable nodes, just add in -1:
        for(int i = 0; i < n; i++) {
            if(!shortestPaths.containsKey(i)) {
                shortestPaths.put(i, -1);
            }
        }
        return shortestPaths;
    }
    // converts edge list to adjacency list:
    private Map<Integer, List<int[]>> toAdjList(List<List<Integer>> edges, int n) {
        // assuming edgeList, convert it to adjacency list:
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++) {
            // initialize the entries with an empty arraylist as its value
            adjList.put(i, new ArrayList<>());
        }
        // insert the values from edges
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            int[] val = new int[]{v, w};
            adjList.get(u).add(val);
        }
        return adjList;
    }
}
