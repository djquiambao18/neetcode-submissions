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
        // deep copy cannot be the same object as the input node.
        // Map<Node, Node> where key = original Node, value = copy Node
        // do BFS, iterative:
        if (node == null)
            return null;
        Node copy = new Node(node.val);
        // insert the copy into the Map
        Map<Node, Node> copies = new HashMap<>();
        copies.put(node, copy);
        // Queue for BFS:
        Queue<Node> adjList = new LinkedList<>();
        adjList.offer(node);
        while(adjList.peek() != null) {
            Node curr = adjList.poll();
            Node currCopy = copies.get(curr);
            for(Node neighbor : curr.neighbors) {
                // check if the map already contains this neighbor, otherwise add it in, enqueue.
                if(!copies.containsKey(neighbor)) {
                    copies.put(neighbor, new Node(neighbor.val));
                    adjList.offer(neighbor);
                }
                // for each neighbor, we need to also add that into the copy's list:
                currCopy.neighbors.add(copies.get(neighbor));
            }
            currCopy.val = curr.val;
        }
        return copy;
    }
}