class Solution:
    def compress(self, c: List[str]) -> int:
        n = len(c)
        count = 1
        s = ""
        i = 0
        for i in range(1, n):
            if c[i] != c[i - 1]:
                if count == 1:
                    s = s + c[i - 1]
                else:
                    s = s + c[i - 1] + str(count)
                count = 1
            else:
                count += 1
        
        
        if count == 1:
            s = s + c[i]
        else:
            s = s + c[i] + str(count)

        for i in range(len(s)):
            c[i] = s[i]

        return len(s)
