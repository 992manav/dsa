import java.util.*;
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int maj1 = 0;
        int count = 0;

        int[] prefix = new int[n];
        for(int i=0;i<n;i++){
            if(count==0){
                maj1 = nums.get(i);
            }
            if(nums.get(i) != maj1){
                count--;
            }else{
                count++;
            }
            if(count>0){
                prefix[i] = maj1;
            }else{
                prefix[i] = -1;
            }
        }

        int maj2 = 0;
        count = 0;
        int[] suffix = new int[n];
        for(int i=n-1;i>=0;i--){
            if(count==0){
                maj2 = nums.get(i);
            }
            if(nums.get(i) != maj2){
                count--;
            }else{
                count++;
            }
            if(count>0){
                suffix[i] = maj2;
            }else{
                suffix[i] = -1;
            }
        }

        int x = maj1;
        int[] preCnt = new int[n];
        int[] sufCnt = new int[n];

        int c = 0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==x){
                c++;
            }
            preCnt[i] = c;
        }

        c = 0;
        for(int i=n-1;i>=0;i--){
            if(nums.get(i)==x){
                c++;
            }
            sufCnt[i] = c;
        }

        for(int i=0;i<n-1;i++){
            if(prefix[i]==x && suffix[i+1]==x){
                if(preCnt[i]*2 > i+1 && sufCnt[i+1]*2 > n-(i+1)){
                    return i;
                }
            }
        }

        return -1;
    }
}
