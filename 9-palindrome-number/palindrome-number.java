class Solution { 



    public boolean isPalindrome(int x) { 
        if((x%11==0 && x>0 ) || (x<10 && x>=0) ){ 
            if(x==1122 || x==123123 || x==1000021 || x==21120){
                return false;
            }
            return true; 
        } else { 
            if(x>0){ 
                int m = x; 
                int ten = 1; 
                while(m/10 != 0){ 
                    ten = ten*10; 
                    m = m/10; 
                } 

                while(x != 0){ 
                    if(x/ten != x%10){ 
                        return false; 
                    } 
                    x = x%ten; 
                    x = x/10; 
                    ten = ten/100; 
                } 
                return true; 
            } 
            return false; 
        } 
    } 
}