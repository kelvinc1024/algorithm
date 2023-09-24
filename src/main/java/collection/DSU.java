package collection;

public class DSU {

    private final int[] parent;
    private final int[] groupSize;
    private int totalGroup;

    public DSU(int n) {
        parent = new int[n];
        groupSize = new int[n];
        totalGroup = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            groupSize[i] = 1;
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
            this.groupSize[parentA] += this.groupSize[parentB];
            this.parent[parentB] = parentA;
        } else {
            this.groupSize[parentB] += this.groupSize[parentA];
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

    public int groupSize(int a) {
        return groupSize[findParent(a)];
    }

    public int getTotalGroup() {
        return totalGroup;
    }
}
