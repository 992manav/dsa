// import javafx.util.Pair;
import java.util.*;
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}


class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        Queue<Pair<Integer, Pair<TreeNode, Integer>>> q = new LinkedList<>();

        q.add(new Pair<>(0, new Pair<>(root, 0))); // fixed wrong use of add()

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {

                Pair<Integer, Pair<TreeNode, Integer>> main_pair = q.remove();

                int col = main_pair.getKey();

                Pair<TreeNode, Integer> p = main_pair.getValue();

                TreeNode node = p.getKey();
                int row = p.getValue();

                if (node.left != null) {
                    q.offer(new Pair<>(col - 1, new Pair<>(node.left, row + 1)));
                }

                if (node.right != null) {
                    q.offer(new Pair<>(col + 1, new Pair<>(node.right, row + 1)));
                }

                if (map.containsKey(col)) {

                    TreeMap<Integer, List<Integer>> newMap = map.get(col);

                    if (newMap.containsKey(row)) {

                        List<Integer> lst = newMap.get(row);
                        lst.add(node.val);
                        Collections.sort(lst);
                        newMap.put(row, lst); // fixed wrong map.put

                    } else {

                        List<Integer> lst = new ArrayList<>();
                        lst.add(node.val);
                        newMap.put(row, lst); // fixed wrong map.put
                    }

                } else {

                    TreeMap<Integer, List<Integer>> newMap = new TreeMap<>();
                    List<Integer> lst = new ArrayList<>();
                    lst.add(node.val);
                    newMap.put(row, lst); // fixed wrong map.put
                    map.put(col, newMap); // fixed wrong map.put
                }
            }

        }

        List<List<Integer>> final_lst = new ArrayList<>();

        for (Integer key1 : map.keySet()) {
                TreeMap<Integer, List<Integer>> newMap = map.get(key1);
                List<Integer> lst = new ArrayList<>();

                for (Integer key2 : newMap.keySet()) {
                        List<Integer> temp = new ArrayList<>(newMap.get(key2));
                        Collections.sort(temp);
                        lst.addAll(temp);
                }

                final_lst.add(lst);
        }


        return final_lst;
    }
}
