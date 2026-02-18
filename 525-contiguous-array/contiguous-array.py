class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        mp = {}
        mp[0] = -1   # diff 0 at index -1

        c = 0
        c1 = 0
        maxlen = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                c += 1
            else:
                c1 += 1

            diff = c1 - c

            if diff in mp:
                idx = mp[diff]
                length = i - idx
                maxlen = max(length, maxlen)
            else:
                mp[diff] = i

        return maxlen
