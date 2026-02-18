class Solution:
    def longestCommonPrefix(self, lst: List[str]) -> str:
        prefix=lst[0]
        for s in lst:
            while s[0:len(prefix)]!=prefix:
                prefix=prefix[0:-1]
                if(len(prefix)==0):
                    return ""

        return prefix
