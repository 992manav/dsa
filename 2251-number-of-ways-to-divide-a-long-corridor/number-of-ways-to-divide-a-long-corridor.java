class Solution {
    public int numberOfWays(String c) {
        List<Integer> list = new ArrayList<>();
        int MOD = (int)1e9+7;
        for(int i=0;i<c.length();i++){
            if(c.charAt(i)=='S') list.add(i);
        }
        if(list.size()==0 || list.size()%2!=0) return 0;
        if(list.size()==2) return 1;
        long ans = 1;

        for(int i=1;i<list.size()-1;i+=2){
            int first = list.get(i);
            int sec = list.get(i+1);
            ans = (ans*(sec-first))%MOD;
        }
        return (int)ans;
    }
}