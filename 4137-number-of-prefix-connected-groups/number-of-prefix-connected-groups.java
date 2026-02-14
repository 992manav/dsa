class Solution {
    int calc(String s,int k){

        int mod=1000000007; 
        long hash=0;

        for(int i=k-1;i>=0;i--){
            char c=s.charAt(i);
            hash=(hash*26+(c-'a'+1))%mod;
        }

        return (int)hash;
    }

    public int prefixConnected(String[] words, int k) {

        int n=words.length;
        Map<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            String s=words[i];

            if(s.length()<k){
               continue;
            }

            int hash=calc(s,k);
            map.put(hash,map.getOrDefault(hash,0)+1);
        }

        int ans=0;

        for(Integer key: map.keySet()){
            int c=map.get(key);
            if(c>=2){
                ans++;
            }
        }

        return ans;
    }
}
