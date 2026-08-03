/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // need to keep track of already copied nodes
        // 1. can use map of nodes. key -> originalNode, value -> copiedNode
        // 2. we can traverse the graph with bfs
        // impt:
        // - process each node in the graph, enqueue its neighbors IF they are not yet in the map
        // - otherwise add the original into the map, then add a new copy into the neighbors list of the copy node
        // edge cases: empty graph ([]), one node with no neighbors ([[]])
        if(node == null) {
            return null;
        }
        // store the 
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> nodes = new ArrayDeque<>();
        visited.put(node, new Node(node.val));
        // enqueue current node
        nodes.offer(node);
        while(!nodes.isEmpty()) {
            // visit the current node, check if the neighbor already exists in the map
            Node curr = nodes.poll();
            // traverse its neighbors, and add them into the copy node currently
            // being explored
            for(Node neighbor : curr.neighbors) {
                // check if the neighbor is added into the map, otherwise, enqueue for
                // processing later:
                if(!visited.containsKey(neighbor)) {
                    // insert a new COPY of this neighbor, dont insert the original
                    // neighbor from the current node.
                    visited.put(neighbor, new Node(neighbor.val));
                    // enqueue the original neighbor, later it will be processed the same way for deep copy
                    nodes.offer(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}