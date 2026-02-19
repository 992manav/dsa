class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        arr=[]

        count=1
  
        for i in range(1,len(s)):
            if s[i]==s[i-1]:
                count+=1
            else:
                arr.append(count)
                count=1
               

        if count>0:
            arr.append(count)

        ans=0
        for i in range(len(arr)-1):
            m=min(arr[i],arr[i+1])
            ans+=m

        return ans

            
        