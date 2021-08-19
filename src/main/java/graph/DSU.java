package graph;

public class DSU {

    private int[] parent;
    private int totalGroup;

    public DSU(int n) {
        parent = new int[n];
        totalGroup = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public boolean union(int a, int b) {
        if (findParent(a) == findParent(b)) {
            return false;
        }
        totalGroup--;
        parent[findParent(a)] = findParent(b);
        return true;
    }

    public int findParent(int a) {
        if (parent[a] != a) {
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }

    public int getTotalGroup() {
        return totalGroup;
    }
}
