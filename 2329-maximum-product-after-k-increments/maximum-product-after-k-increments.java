class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue <Integer> queue = new PriorityQueue<>();
        int mod = 1000000007;
        int answer = 1;
        for(int i =0; i<nums.length; i++)
        {
            queue.add(nums[i]);
        }
        while(k>0)
        {
            int val = queue.poll();
            val += 1;
            queue.add(val);
            k--;
        }
        while(!queue.isEmpty())
        {
            answer = (int)((answer * 1L * queue.poll()) % mod);
        } 
    return answer;
    }
}