import java.util.*;
class Solution {

    String[] arr;
    int m;
    int n;
    int[][][] dp;
    int[][] cnt;   // cnt[i][0] = zeros, cnt[i][1] = ones

    int fun(int index,int count0,int count1,int count){
        if(index == arr.length){
            return 0;
        }

        if(dp[index][count0][count1] != -1){
            return dp[index][count0][count1];
        }

        int c0 = cnt[index][0];
        int c1 = cnt[index][1];

        boolean flag = false;

        
        if(count0 + c0 > m){
            flag = true;
        }
        if(count1 + c1 > n){
            flag = true;
        }

        int take;
        if(!flag){
            take = fun(index+1,count0+c0,count1+c1,count+1) + 1;
        } else {
            take = 0;
        }

        int skip = fun(index+1,count0,count1,count);

        int ans;
        if(skip > take){
            ans = skip;
        } else {
            ans = take;
        }

        dp[index][count0][count1] = ans;
        return ans;
    }

    public int findMaxForm(String[] arr, int m, int n) {

        if(arr == null){
            return 0;
        }
        if(arr.length == 0){
            return 0;
        }

        // Arrays.sort(arr, new Comparator<String>(){
        //     public int compare(String a, String b){
        //         return a.length() - b.length();
        //     }
        // });

        this.arr = arr;
        this.m = m;
        this.n = n;

        dp = new int[arr.length][m+1][n+1];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        cnt = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            int zeros = 0;
            int ones = 0;
            for(char c : arr[i].toCharArray()){
                if(c == '0'){
                    zeros++;
                } else {
                    ones++;
                }
            }
            cnt[i][0] = zeros;
            cnt[i][1] = ones;
        }

        return fun(0,0,0,0);
    }
}
