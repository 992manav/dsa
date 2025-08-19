class Solution {

    int[] segTree;        // segment tree
    int[] heightsArr;     // original heights

    int target;           // target height for query
    int qStart;           // query start index
    int qEnd;             // query end index

    void build(int node, int start, int end) {

        if (start == end) {
            segTree[node] = heightsArr[start];
            return;
        }

        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        build(leftChild, start, mid);
        build(rightChild, mid + 1, end);

        segTree[node] = Math.max(segTree[leftChild], segTree[rightChild]);
    }

    int query(int node, int start, int end) {

        int nodeMax = segTree[node];

        if (nodeMax <= target) return -1;
        if (end < qStart || start > qEnd) return -1;

        if (start == end) return start;

        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;

        int leftResult = query(leftChild, start, mid);
        int rightResult = query(rightChild, mid + 1, end);

        if (leftResult == -1 && rightResult == -1) return -1;
        if (leftResult != -1 && rightResult == -1) return leftResult;
        if (leftResult == -1 && rightResult != -1) return rightResult;

        return Math.min(leftResult, rightResult);
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

        this.heightsArr = heights;
        this.segTree = new int[4 * heights.length];
        build(0, 0, heights.length - 1);

        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];

            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }

            int hLeft = heights[left];
            int hRight = heights[right];

            if (hRight > hLeft || left == right) {
                ans[idx] = right;
            } else {
                target = Math.max(hLeft, hRight);
                qStart = right + 1;
                qEnd = heights.length - 1;
                ans[idx] = query(0, 0, heights.length - 1);
            }

            idx++;
        }

        return ans;
    }
}
