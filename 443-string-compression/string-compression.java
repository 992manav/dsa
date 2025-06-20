class Solution {
    public int compress(char[] a) {
        int index = 0;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            count++;
            if (i == a.length - 1 || a[i] != a[i + 1]) {
                a[index] = a[i];

                if (count > 1) {
                    index++;

                    if (count > 9) {
                        String str = Integer.toString(count);
                        for (char c : str.toCharArray()) {
                            a[index] = c;
                            index++;
                        }
                    } else {
                        a[index] = (char)(count + '0');
                        index++;
                    }
                } else {
                    index++;
                }
                count = 0;
            }
        }
        return index;
    }
}
