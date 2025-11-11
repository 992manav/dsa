import java.util.*;
class Solution {

    String[] arr;
    int m;
    int n;
    int[][][] dp;

    int fun(int index,int count0,int count1,int count){
        if(index == arr.length){
            return 0;
        }

        if(dp[index][count0][count1] != -1){
            return dp[index][count0][count1];
        }

        String s = arr[index];

        int c0 = 0;
        int c1 = 0;
        boolean flag = false;

        for(char c : s.toCharArray()){
            if(c == '0'){
                c0++;
            } else {
                c1++;
            }
            if(c1 > n){
                break;
            }
            if(c0 > m){
                break;
            }
        }

        if(c1 > n){
            flag = true;
        }
        if(c0 > m){
            flag = true;
        }
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

        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        });

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

        return fun(0,0,0,0);
    }
}
