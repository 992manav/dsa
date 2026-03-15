import java.util.*;

class Fancy {

    class Pair<K,V>{
        public K key;
        public V value;

        Pair(K k,V v){
            key = k;
            value = v;
        }
    }

    List<Pair<Integer,Boolean>> ops;
    List<Pair<Long,Integer>> lst;
    int MOD = 1000000007;

    public Fancy() {
        ops = new ArrayList<>();
        lst = new ArrayList<>();
    }
    
    public void append(int val) {
        lst.add(new Pair<>((long)val, ops.size()));
    }
    
    public void addAll(int inc) {
        ops.add(new Pair<>(inc, true));
    }
    
    public void multAll(int m) {
        ops.add(new Pair<>(m, false));
    }
    
    public int getIndex(int idx) {

        if(idx >= lst.size()){
            return -1;
        }

        Pair<Long,Integer> p = lst.get(idx);

        long v = p.key;
        int j = p.value;

        for(int i = j; i < ops.size(); i++){

            Pair<Integer,Boolean> op = ops.get(i);
            int n = op.key;

            if(op.value){
                v = (v + n) % MOD;
            }
            else{
                v = (v * n) % MOD;
            }
        }

        p.key = v;
        p.value = ops.size();

        return (int)v;
    }
}