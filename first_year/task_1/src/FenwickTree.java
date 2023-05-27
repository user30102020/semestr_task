public class FenwickTree {
    private final int[] tree;
    public FenwickTree(int size) {
        tree = new int[size + 1];
    }
    public void update(int index, int value) {
        while (index < tree.length) {
            tree[index] += value;
            index += index & -index;
        }
    }
    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }
}