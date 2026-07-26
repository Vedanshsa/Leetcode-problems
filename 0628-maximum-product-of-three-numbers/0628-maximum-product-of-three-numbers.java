class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int x : nums) {
            maxHeap.offer(x);
            minHeap.offer(x);
        }
        
        int max1 = maxHeap.poll(), max2 = maxHeap.poll(), max3 = maxHeap.poll();
        int min1 = minHeap.poll(), min2 = minHeap.poll();
        
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
