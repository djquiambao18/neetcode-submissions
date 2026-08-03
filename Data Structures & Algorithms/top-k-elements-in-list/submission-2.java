class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        // bucket-sorting:
        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entrySet : frequencyMap.entrySet()) {
            int frequency = entrySet.getValue();
            if(buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entrySet.getKey());
        }

        int[] result = new int[k];
        int resultIndex = 0;

        // walk backward from highest possible frequency to 1
        for(int freq = nums.length; freq >= 1 && resultIndex < k; freq--) {
            if(buckets[freq] == null) continue;
            for(int num : buckets[freq]) {
                result[resultIndex] = num;
                resultIndex++;
                if(resultIndex == k) break;
            }
        }

        return result;
    }
}