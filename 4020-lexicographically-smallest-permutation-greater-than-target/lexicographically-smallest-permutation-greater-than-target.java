import java.util.*;

class Solution {

    String nextPermutation(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1]) i--;

        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) j--;
            swap(arr, i, j);
        }

        reverse(arr, i + 1, n - 1);
        return new String(arr);
    }

    void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(char[] nums, int start, int end) {
        while (start < end) {
            char temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public String lexGreaterPermutation(String s, String target) {

        if (s.compareTo(target) == 0) {
            String p = nextPermutation(s);
            return (p.compareTo(target) <= 0) ? "" : p;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String reverse = new StringBuilder(new String(arr)).reverse().toString();

        if (reverse.compareTo(target) < 0) {
            return "";
        }

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        boolean flag1 = false;
        int i;

        for (i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int idx = c - 'a';
            if (freq[idx] > 0) {
                freq[idx]--;
                sb.append(c);
            } else {
                flag = true;
                break;
            }
        }

        if (!flag) {
            String p = nextPermutation(target);
            return (p.compareTo(target) <= 0) ? "" : p;
        }

        if (flag) {
            char c = target.charAt(i);
            int idx = c - 'a';

            // \U0001f527 FIX: try to place next greater character than target[i]
            boolean placed = false;
            for (int j = idx + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    sb.append((char) (j + 'a'));
                    freq[j]--;
                    placed = true;
                    flag1 = true;
                    break;
                }
            }

            // if not found, backtrack one step and try next greater
            if (!placed) {
                while (sb.length() > 0) {
                    char last = sb.charAt(sb.length() - 1);
                    freq[last - 'a']++;
                    sb.deleteCharAt(sb.length() - 1);
                    for (int j = (last - 'a') + 1; j < 26; j++) {
                        if (freq[j] > 0) {
                            sb.append((char) (j + 'a'));
                            freq[j]--;
                            flag1 = true;
                            placed = true;
                            break;
                        }
                    }
                    if (placed) break;
                }
            }

            // append smallest remaining
            for (int k = 0; k < 26; k++) {
                while (freq[k] > 0) {
                    sb.append((char) (k + 'a'));
                    freq[k]--;
                }
            }
        }

        if (flag || flag1) {
            if (reverse.compareTo(target) <= 0) {
                return "";
            } else {
                String str = sb.toString();
                if (str.compareTo(target) <= 0) {
                    String p = nextPermutation(str);
                    if (p.compareTo(target) <= 0) {
                        return "";
                    } else {
                        return p;
                    }
                } else {
                    return str;
                }
            }
        }

        return sb.toString();
    }
}
