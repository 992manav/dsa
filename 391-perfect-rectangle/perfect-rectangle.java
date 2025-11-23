import java.util.*;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return x == p.x && y == p.y;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution {
    public boolean isRectangleCover(int[][] rect) {
        Map<Pair, Integer> map = new HashMap<>();
        long area = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < rect.length; i++) {
            int x1 = rect[i][0];
            int y1 = rect[i][1];
            int x2 = rect[i][2];
            int y2 = rect[i][3];

            area += (long)(x2 - x1) * (y2 - y1);

            if (x1 < minX) minX = x1;
            if (y1 < minY) minY = y1;
            if (x2 > maxX) maxX = x2;
            if (y2 > maxY) maxY = y2;

            Pair p1 = new Pair(x1, y1);
            Pair p2 = new Pair(x1, y2);
            Pair p3 = new Pair(x2, y1);
            Pair p4 = new Pair(x2, y2);

            map.put(p1, map.getOrDefault(p1, 0) + 1);
            map.put(p2, map.getOrDefault(p2, 0) + 1);
            map.put(p3, map.getOrDefault(p3, 0) + 1);
            map.put(p4, map.getOrDefault(p4, 0) + 1);
        }

        long big = (long)(maxX - minX) * (maxY - minY);
        if (area != big) return false;

        Pair a = new Pair(minX, minY);
        Pair b = new Pair(minX, maxY);
        Pair c = new Pair(maxX, minY);
        Pair d = new Pair(maxX, maxY);

        if (!map.containsKey(a) || !map.containsKey(b) || !map.containsKey(c) || !map.containsKey(d)) return false;

        if (map.get(a) != 1) return false;
        if (map.get(b) != 1) return false;
        if (map.get(c) != 1) return false;
        if (map.get(d) != 1) return false;

        map.remove(a);
        map.remove(b);
        map.remove(c);
        map.remove(d);

        for (int v : map.values()) {
            if (v % 2 != 0) return false;
        }

        return true;
    }
}
