import java.util.*;

class Solution {

    Set<String> wordSet;
    String endWord;

    boolean check(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff > 1) return false;
            }
        }
        return diff == 1;
    }

    int bfs(String beginWord) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return level;

                for (String next : wordSet) {
                    if (!visited.contains(next) && check(word, next)) {
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWordInput, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        endWord = endWordInput;
        if (!wordSet.contains(endWord)) return 0;

        return bfs(beginWord);
    }
}
