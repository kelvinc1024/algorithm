package collection;

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
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (parentA == parentB) {
            return false;
        }
        totalGroup--;
        if (parentA < parentB) {
            this.parent[parentB] = parentA;
        } else {
            this.parent[parentA] = parentB;
        }
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
