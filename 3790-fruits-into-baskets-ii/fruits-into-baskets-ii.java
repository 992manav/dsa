class Solution { 
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) { 
        int count = 0; 
         
        for (int i = 0; i < fruits.length; i++) { 
            int num = fruits[i]; 
         
            for (int j = 0; j < baskets.length; j++) { 
                if (num <= baskets[j]) { 
                    baskets[j] = 0; 
                    count++; 
                    break; 
                } 
            } 
        } 
 
        return fruits.length - count; 
    } 
}
