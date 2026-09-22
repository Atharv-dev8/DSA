class Solution {

    class Node {
        int product;
        int[] count;

        Node(int k) {
            count = new int[k];
            product = 1;
        }
    }

    int k;
    Node[] tree;

    // Create a node for one element
    Node createNode(int value) {

        Node node = new Node(k);

        int rem = value % k;

        node.product = rem;

        // Only one NON-EMPTY prefix:
        // [value]
        node.count[rem] = 1;

        return node;
    }

    // Merge two segments
    Node merge(Node left, Node right) {

        Node result = new Node(k);

        // Product of complete segment
        result.product =
                (left.product * right.product) % k;

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            result.count[r] = left.count[r];
        }

        // Prefixes which start in left
        // and continue into right
        for (int r = 0; r < k; r++) {

            int newRemainder =
                    (left.product * r) % k;

            result.count[newRemainder] +=
                    right.count[r];
        }

        return result;
    }

    // Build segment tree
    void build(int index,
               int left,
               int right,
               int[] nums) {

        if (left == right) {
            tree[index] = createNode(nums[left]);
            return;
        }

        int mid = (left + right) / 2;

        build(index * 2,
              left,
              mid,
              nums);

        build(index * 2 + 1,
              mid + 1,
              right,
              nums);

        tree[index] =
                merge(tree[index * 2],
                      tree[index * 2 + 1]);
    }

    // Update nums[position]
    void update(int index,
                int left,
                int right,
                int position,
                int value) {

        if (left == right) {
            tree[index] = createNode(value);
            return;
        }

        int mid = (left + right) / 2;

        if (position <= mid) {

            update(index * 2,
                   left,
                   mid,
                   position,
                   value);

        } else {

            update(index * 2 + 1,
                   mid + 1,
                   right,
                   position,
                   value);
        }

        tree[index] =
                merge(tree[index * 2],
                      tree[index * 2 + 1]);
    }

    // Query range [queryLeft, queryRight]
    Node query(int index,
               int left,
               int right,
               int queryLeft,
               int queryRight) {

        // Completely inside
        if (queryLeft <= left &&
            right <= queryRight) {

            return tree[index];
        }

        int mid = (left + right) / 2;

        // Query only left side
        if (queryRight <= mid) {

            return query(index * 2,
                         left,
                         mid,
                         queryLeft,
                         queryRight);
        }

        // Query only right side
        if (queryLeft > mid) {

            return query(index * 2 + 1,
                         mid + 1,
                         right,
                         queryLeft,
                         queryRight);
        }

        // Query both sides
        Node leftNode =
                query(index * 2,
                      left,
                      mid,
                      queryLeft,
                      queryRight);

        Node rightNode =
                query(index * 2 + 1,
                      mid + 1,
                      right,
                      queryLeft,
                      queryRight);

        return merge(leftNode, rightNode);
    }

    public int[] resultArray(int[] nums,
                             int k,
                             int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        // Build segment tree
        build(1,
              0,
              n - 1,
              nums);

        int[] answer =
                new int[queries.length];

        for (int i = 0;
             i < queries.length;
             i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Permanent update
            update(1,
                   0,
                   n - 1,
                   index,
                   value);

            // Query [start ... n-1]
            Node result =
                    query(1,
                          0,
                          n - 1,
                          start,
                          n - 1);

            // Number of valid ways
            answer[i] = result.count[x];
        }

        return answer;
    }
}