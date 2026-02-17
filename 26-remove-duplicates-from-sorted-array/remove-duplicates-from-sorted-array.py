class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n=len(nums)

        i=0
        j=1

        nums.sort()
        while j<n:
            if nums[j]==nums[i]:
                j+=1
            else:
                i+=1
                nums[i]=nums[j]
                j+=1
                
        
        return i+1
        

        