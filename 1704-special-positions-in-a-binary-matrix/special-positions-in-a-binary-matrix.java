import java.util.*;

class Solution {
    public int numSpecial(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> mapy = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(mat[i][j] == 1){
                    if(map.containsKey(i)){
                        map.put(i,-1);
                    }else{
                        map.put(i,j);
                    }
                }

                if(mat[i][j] == 1){
                    if(mapy.containsKey(j)){
                        mapy.put(j,Integer.MIN_VALUE);
                    }else{
                        mapy.put(j,i);
                    }
                }

            }
        }

        // System.out.println(map);
        // System.out.println(mapy);

        int count = 0;

        for(Integer k : map.keySet()){
            int v = map.get(k);

            if(mapy.containsKey(v)){
                int k2 = mapy.get(v);

                if(k == k2){
                    count++;
                }
            }
        }

        return count;
    }
}