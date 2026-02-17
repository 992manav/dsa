class Solution:
    def frequencySort(self, s: str) -> str:
        def get_value(item):
            return item[1]
        map={}
        for c in s:
            if c in map:
                map[c]+=1
            else:
                map[c]=1
        
        sorted_d = dict(sorted(map.items(), key=get_value, reverse=True))

        str=""
        for k,v in sorted_d.items():
            str+=(k*v)
        
        return str
        
        
            
            

        

        