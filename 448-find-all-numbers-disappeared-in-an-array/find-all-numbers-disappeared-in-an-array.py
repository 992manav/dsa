class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        map={}

        for x in nums:
            if x in map:
                map[x]+=1
            else:
                map[x]=1
        
        n=len(nums)
        lst=[]
        for i in range(n):
            if i+1 not in map:
                lst.append(i+1)

        return lst 
        