class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        i = 0
        j = 0
        n = len(s)
        max = 0
        st = set()

        while j < n:
            if s[j] not in st:
                st.add(s[j])
                j += 1
            else:
                if j - i >= max:
                    max = j - i

                while i < j:
                    if s[i] == s[j]:
                        st.remove(s[i])
                        i += 1
                        break
                    else:
                        st.remove(s[i])
                        i += 1

                st.add(s[j])
                j += 1

        if j - i >= max:
            max = j - i

        return max
