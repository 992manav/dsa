class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if(len(s)!=len(goal)):
            return False
        s=s+s
        if(s.find(goal)==-1):
            return False
        else:
            return True