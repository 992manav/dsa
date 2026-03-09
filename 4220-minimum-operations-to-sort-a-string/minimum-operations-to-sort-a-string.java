import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        boolean sorted = true;
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                sorted = false;
                break;
            }
        }
        if(sorted){
            return 0;
        }

        if(n == 2){
            return -1;
        }

        char globalMax = arr[0];
        char globalMin = arr[0];

        for(int i = 0; i < n; i++){
            if(arr[i] > globalMax){
                globalMax = arr[i];
            }
            if(arr[i] < globalMin){
                globalMin = arr[i];
            }
        }

        if(arr[0] == globalMin || arr[n-1] == globalMax){
            return 1;
        }

        char[] c = arr.clone();
        char[] d = arr.clone();

        Arrays.sort(c,0,n-1);
        Arrays.sort(c,1,n);

        Arrays.sort(d,1,n);
        Arrays.sort(d,0,n-1);

        boolean cSorted = true;
        boolean dSorted = true;

        for(int i = 1; i < n; i++){
            if(c[i] < c[i-1]){
                cSorted = false;
                break;
            }
        }

        for(int i = 1; i < n; i++){
            if(d[i] < d[i-1]){
                dSorted = false;
                break;
            }
        }

        if(cSorted || dSorted){
            return 2;
        }

        return 3;
    }
}