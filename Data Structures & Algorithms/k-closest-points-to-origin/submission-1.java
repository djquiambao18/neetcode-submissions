class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // [[0, 2], [1,3], [2,3]]
        //  points[i][0] == x, points[i][1] == y
        //  top 'k' closest points to the origin (0,0)
        //  distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        //  since we're always comparing to 0,0 -> it simplifies to:
        //  distance = Math.sqrt(Math.pow((x1), 2) + Math.pow((y1), 2));
        //  furthermore, we dont need the squareroot at all, we can just simply do x1*x1 + y1*y1 as its linear Distance
        //  int[]{xi, yi, distSquare to origin}
        //  PriorityQueue<int[]> comparingInt(a -> -a[2]) in reverse order (max heap) such that the minimum is at the bottom of the heap
        //  and we continuously pop off any points when we've reached "k" points size in heap AFTER pushing in the new points
        // at the end, we just pop off the elements from the heap, add them into an int[][] result whose size is k and the intermediate results
        // from the heap is formatted like int[] heapRes = new int[2]; (pq.poll()[0] is x, pq.poll()[1] is y)
        // return result

        // use max-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[2]));
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            // check the distance:
            int distSquared = calc(x, y);
            // push into the max-heap:
            pq.offer(new int[]{x, y, distSquared});
            // then check if the size of heap > k, pop the top of the heap if so:
            if(pq.size() > k) {
                pq.poll();
            }
        }
        // extract the items from the heap and plug into result:
        int i = 0;
        int[][] closestPoints = new int[k][2];
        while(!pq.isEmpty()) {
            int[] tempRes = pq.poll();
            closestPoints[i][0] = tempRes[0];
            closestPoints[i][1] = tempRes[1];
            i++;
        }
        return closestPoints;
    }
    // dist calculation
    private int calc(int x, int y) {
        return x*x + y*y;
    }
}
