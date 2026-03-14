class Solution {
    List<String>lst;
    int n;
    void fun(int i,String s){
        if(i>=n){
            lst.add(s);
            return;
        }

        if(i==0){
            fun(i+1,s+'a');
            fun(i+1,s+'b');
            fun(i+1,s+'c');
        }else{
                 if(s.charAt(s.length()-1)=='a'){
                    fun(i+1,s+'b');
                    fun(i+1,s+'c');
                }
                else if(s.charAt(s.length()-1)=='b'){
                    fun(i+1,s+'a');
                    fun(i+1,s+'c');
                }else{
                    fun(i+1,s+'a');
                    fun(i+1,s+'b');
                }
        }
       

    }
    public String getHappyString(int n, int k) {
        this.n=n;
        lst=new ArrayList<>();
        fun(0,"");

        Collections.sort(lst,(a,b)->a.compareTo(b));

        if(lst.size()<k){
            return "";
        }
        return lst.get(k-1);

    }
}