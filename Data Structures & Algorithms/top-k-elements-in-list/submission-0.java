class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // top 'k': use heap
        // for each element in nums, store it into a map, counting its occurence,
        // insert it into a heap, then poll 'k' times
        // PriorityQueue<Integer> frequentElements = new LinkedList<>();
        // count the frequency of each element:
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : nums) {
            int currentFrequency = frequencyMap.getOrDefault(i, 0);
            currentFrequency++;
            frequencyMap.put(i, currentFrequency);

        }
        // [{key:val}]
        // [{1:1},{2:2},{3:3}] k = 2
        // [{7:1},{1:2}], k = 1

        // the integer-array obj type for heap is for storing the frequency and the associated number
        // pass a custom comparator where we compare the first element in the array (which is the frequency in this case) ([0])
        // the second element ([1]) would be the actual value, which is the key in the map.
        // because there is no inherent comparator for int[] type, we MUST tell it how to compare the items.
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // insert each element in the map with their frequencies into the heap:
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            // insert the element into the heap, the custom-comparator defined in the constructor will
            // determine how to "rank" the elements based on their frequency
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            // check if we have inserted enough items in the heap ('k' items).
            // If there is more than 'k' items, remove the 'least'/min item, hence the use of min-heap.
            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        // retrieve items from the heap, this will only be 'k' elements so just poll the size:
        for(int i = 0; i < k; i++) {
            // just poll the heap (remove the head) since there will only be 'k' items and order does not matter.
            result[i] = heap.poll()[1];
        }
        return result;
    }
}
