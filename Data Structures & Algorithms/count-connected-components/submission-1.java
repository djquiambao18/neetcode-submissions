class Solution {
    // union-find
    private int[] parents;
    // merge the set which has i and the set that has j
    private void union(int i, int j) {
        // find the parents of the elements (in whichever set they belong to)
        int iparent = find(i);
        int jparent = find(j);
        // then, make the parent of i be the rep of j's set, unioning them
        parents[iparent] = jparent;
    }

    private int find(int i) {
        if(parents[i] == i) {
            return i;
        }
        return find(parents[i]);
    }

    public int countComponents(int n, int[][] edges) {
        int count = n;
        // initialize the parent set with "n" as number of nodes:
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // then, for each edge in the graph:
        for(int i = 0; i < edges.length; i++) {
            int rootA = find(edges[i][0]);
            int rootB = find(edges[i][1]);
            if(rootA != rootB) {
                union(rootA, rootB);
                count--;
            }
        }
        return count;
    }
}
