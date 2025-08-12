import java.util.*;

class Solution { 
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) { 
        int[] arr = new int[101]; // To store state of each number (1..100)
        List<Integer> lst = new ArrayList<>(); 
        Arrays.fill(arr, 0); 
         
        for (int i = 0; i < nums1.length; i++) { 
            arr[nums1[i]] = 1; 
        } 
        for (int i = 0; i < nums2.length; i++) { 
            if (arr[nums2[i]] == 1 || arr[nums2[i]] == -1) { 
                arr[nums2[i]] = -1; // Appeared in nums1 and nums2
            } else { 
                arr[nums2[i]] = 2; 
            } 
        } 
        for (int i = 0; i < nums3.length; i++) { 
            if (arr[nums3[i]] != 0) { 
                arr[nums3[i]] = 3; // Appeared in nums3 + (nums1 or nums2)
            } 
        } 
 
        for (int i = 0; i < arr.length; i++) { 
            if (arr[i] == -1 || arr[i] == 3) { 
                lst.add(i); 
            } 
        } 
 
        return lst; 
    } 
}
