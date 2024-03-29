package collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DSUTest {

    @Test
    void dsuGroupSizeShouldReturnSizeOfGroupFromGivenNode() {
        DSU dsu = new DSU(10);

        Assertions.assertEquals(1, dsu.groupSize(1));

        dsu.union(1, 2);
        dsu.union(1, 5);

        Assertions.assertEquals(3, dsu.groupSize(1));
        Assertions.assertEquals(3, dsu.groupSize(5));
        Assertions.assertEquals(3, dsu.groupSize(2));
        Assertions.assertEquals(1, dsu.groupSize(3));
    }

    @Test
    public void dsuGetTotalGroupShouldReturnUniqueNumberOfGroup() {
        DSU dsu = new DSU(10);

        Assertions.assertEquals(10, dsu.getTotalGroup());

        dsu.union(0, 1);
        Assertions.assertEquals(9, dsu.getTotalGroup());

        dsu.union(0, 1);
        Assertions.assertEquals(9, dsu.getTotalGroup());


        dsu.union(1, 2);
        Assertions.assertEquals(8, dsu.getTotalGroup());

        dsu.union(5, 6);
        Assertions.assertEquals(7, dsu.getTotalGroup());
    }

    @Test
    public void dsuUnionShouldReturnTrueWhenOriginallyDifferentGroup() {
        DSU dsu = new DSU(10);

        Assertions.assertTrue(dsu.union(0, 1));
        Assertions.assertFalse(dsu.union(0, 1));

        Assertions.assertTrue(dsu.union(0, 2));
        Assertions.assertFalse(dsu.union(0, 2));

        dsu.union(5, 6);

        Assertions.assertTrue(dsu.union(6, 0));
        Assertions.assertFalse(dsu.union(6, 0));
        Assertions.assertFalse(dsu.union(6, 0));
    }

    @Test
    public void dsuFindParentShouldReturnSameParentWhenUnderSameGroup() {
        DSU dsu = new DSU(10);

        Assertions.assertNotEquals(dsu.findParent(1), dsu.findParent(0));

        dsu.union(0, 1);
        Assertions.assertEquals(dsu.findParent(1), dsu.findParent(0));

        dsu.union(0, 2);
        Assertions.assertEquals(dsu.findParent(1), dsu.findParent(2));
        Assertions.assertEquals(dsu.findParent(0), dsu.findParent(2));

        dsu.union(5, 6);
        dsu.union(0, 6);
        Assertions.assertEquals(dsu.findParent(1), dsu.findParent(6));
        Assertions.assertNotEquals(dsu.findParent(9), dsu.findParent(6));
    }

    @Test
    public void dsuUnionAlwaysAssignSmallestParentId() {
        DSU dsu = new DSU(10);
        dsu.union(5, 8);
        Assertions.assertEquals(5, dsu.findParent(5));
        Assertions.assertEquals(5, dsu.findParent(5));

        DSU dsu2 = new DSU(10);
        dsu2.union(8, 5);
        Assertions.assertEquals(5, dsu.findParent(5));
        Assertions.assertEquals(5, dsu.findParent(5));
    }

}