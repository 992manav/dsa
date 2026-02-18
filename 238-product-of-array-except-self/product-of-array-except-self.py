class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
    
        n=len(nums)
        prefix=[0]*n
        prefix[0]=1
        for i in range(1,n):
            prefix[i]=prefix[i-1]*nums[i-1]
        
        suffix=[0]*n
        suffix[n-1]=1
        for i in range(n-2,-1,-1):
            suffix[i]=suffix[i+1]*nums[i+1]


        # print(prefix)
        # print(suffix)
        lst=[]
        for i in range(n):
            lst.append(prefix[i]* suffix[i])

        return lst
        

        

        