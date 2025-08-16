class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // -2,-2,-2,3,3
        
        int sum1 = 0;
        int[] arr = new int[gas.length];   
        for (int i = 0; i < gas.length; i++) {
            arr[i] = gas[i] - cost[i];
            sum1 += arr[i];
        }  
        
        if (sum1 < 0) {
            return -1;
        }
        
        int sum = 0;
        int start = -1;
    
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i;
            }
            sum = sum + arr[i];  
                
            if (sum < 0) {   
                sum = 0;
            }
        }
        return start;
    }
}
