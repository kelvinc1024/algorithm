package graph;

import math.GCD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SegmentTreeTest {

    static class GCDSegmentTree {
        @Test
        public void gcdRangeQueryShouldGCDALlValueInIndexRange() {
            long[] data = new long[]{6, 9, 3, 12, 2, 14, 7, 10};

            SegmentTree segmentTree = new SegmentTree(data, GCD::gcd, 0);

            Assertions.assertEquals(3, segmentTree.rangeQuery(0, 3));
            Assertions.assertEquals(1, segmentTree.rangeQuery(1, 4));
            Assertions.assertEquals(7, segmentTree.rangeQuery(5, 6));
            Assertions.assertEquals(6, segmentTree.rangeQuery(0, 0));
        }

        @Test
        public void updateValueShouldReturnUpdatedGCDAllValueInIndexRange() {
            long[] data = new long[]{6, 9, 3, 12, 2, 14, 7, 10};

            SegmentTree segmentTree = new SegmentTree(data, GCD::gcd, 0);

            Assertions.assertEquals(1, segmentTree.rangeQuery(0, 4));
            segmentTree.update(4, 6);
            Assertions.assertEquals(3, segmentTree.rangeQuery(0, 4));
        }
    }

    static class RangeSumSegmentTree {
        @Test
        public void sumRangeQueryShouldSumAllValueInIndexRange() {
            long[] data = new long[]{6, 9, 3, 12, 2, 14, 7, 10};
            SegmentTree segmentTree = new SegmentTree(data, Long::sum, 0);

            Assertions.assertEquals(18, segmentTree.rangeQuery(0, 2));
            Assertions.assertEquals(31, segmentTree.rangeQuery(2, 5));
        }

        @Test
        public void updateValueShouldReturnUpdatedSumAllValueInIndexRange() {
            long[] data = new long[]{6, 9, 3, 12, 2, 14, 7, 10};
            SegmentTree segmentTree = new SegmentTree(data, Long::sum, 0);

            Assertions.assertEquals(46, segmentTree.rangeQuery(0, 5));
            segmentTree.update(1, 20);
            Assertions.assertEquals(57, segmentTree.rangeQuery(0, 5));
        }
    }

}