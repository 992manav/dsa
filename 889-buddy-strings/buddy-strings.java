import java.util.*;

class Solution {
    public boolean buddyStrings(String s, String g) {
        if(s.length()!=g.length()){
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = g.toCharArray();
        int n=s.length();
        if(Arrays.equals(a, b)){
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(a[i]==b[j] &&a[j]==b[i] ){
                            return true;
                    }
                }
            }

            return false;
        }   

        List<Integer>lst=new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(a[i]!=b[i]){
                lst.add(i);
                count++;
            }
        }

    

       if(count==2){
        if(a[lst.get(0)]==b[lst.get(1)] &&a[lst.get(1)]==b[lst.get(0)] ){
            return true;
        }
       }
       return false;
    }
}
