
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int n = nums.length;
        int[] result = new int[n-k+1];

        for(int i = 0; i < n; i++) {

            // Step 1: Remove expired indexes
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            // Step 2: Remove smaller elements
            while(!dq.isEmpty() &&
                  nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Step 3: Add current index
            dq.offerLast(i);

            // Step 4: Store maximum
            if(i >= k-1) {
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
