import heapq
class Solution:
    def topKFrequent(self, nums: List[int], y: int) -> List[int]:
        map={}
        for x in nums:
            map[x] = map.get(x, 0) + 1
        
        # print(map)
        pq = []
        for k,v in map.items():
            heapq.heappush(pq,(-v,k))

        # print(pq)
        lst=[]
        while pq:
            # print(y)
            y -= 1
            f, num = heapq.heappop(pq)
            lst.append(num)
            if(y<=0):
                break
            

        return lst

        
        
        
        
        

            
        