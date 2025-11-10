class MedianFinder {

    List<Integer> lst;

    int binary_search(int target){
        int low = 0;
        int high = lst.size() - 1;
        int ans = lst.size();

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(lst.get(mid) <= target){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public MedianFinder() {
        lst = new ArrayList<>();
    }
    
    public void addNum(int num) {
        int index = binary_search(num);
        lst.add(index, num);
    }
    
    public double findMedian() {
        int n = lst.size();
        if(n % 2 == 0){
            double a = lst.get(n/2);
            double b = lst.get(n/2 - 1);
            return (a + b) / 2.0;
        }else{
            return lst.get(n/2);
        }
    }
}
