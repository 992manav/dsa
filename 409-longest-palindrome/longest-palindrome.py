class Solution:
    def longestPalindrome(self, s: str) -> int:
        map={}
        for c in s:
            map[c]=map.get(c,0)+1

        even=0
        odd=0
        c=0
        for k,v in map.items():
            if v%2==0:
                even+=v
            else:
                odd+=v  
                c+=1
        
        if odd>0:
            return even+odd-c+1
        else:
            return even
