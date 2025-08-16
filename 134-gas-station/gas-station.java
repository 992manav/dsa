class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Idea: gas[i] - cost[i] = ek prakar no profit/loss per station
        // So aa array banavie to tamne ek "subarray sum" ni problem javi lage che

        int sum1 = 0;
        int[] arr = new int[gas.length];   
        for (int i = 0; i < gas.length; i++) {
            arr[i] = gas[i] - cost[i];
            sum1 += arr[i];
        }  
        
        // Jo total profit < 0 → to koi circuit complete karvo possible nathi
        if (sum1 < 0) {
            return -1;
        }
        
        int sum = 0;
        int start = -1;
    
        for (int i = 0; i < arr.length; i++) {
            // Kadane’s javu: jyare running sum khali (0) hoy, etle new subarray start kariye
            if (sum == 0) {
                start = i;
            }
            
            sum = sum + arr[i];  
                
            // Kadane’s ma jyare sum < 0 thay → reset kari ne navi subarray start kariye
            if (sum < 0) {   
                sum = 0;
            }
        }
        return start;
    }
}
