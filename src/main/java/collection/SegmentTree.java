package collection;

public class SegmentTree {

    private final SegmentTreeMerger merger;
    private final long[] data;
    private final long[] segmentTree;
    private final long oufOfBoundDefaultValue;

    public SegmentTree(long[] data, SegmentTreeMerger merger, long oufOfBoundDefaultValue) {
        this.data = data;
        this.merger = merger;
        this.oufOfBoundDefaultValue = oufOfBoundDefaultValue;

        int height = (int) (Math.ceil(Math.log(data.length) / Math.log(2)));
        int size = 2 * (int) Math.pow(2, height) - 1;
        this.segmentTree = new long[size];
        constructSegmentTree(0, data.length - 1, 0);
    }

    private long constructSegmentTree(int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = data[start];
            return segmentTree[index];
        }
        int mid = start + (end - start) / 2;
        segmentTree[index] = merger.merge(
                constructSegmentTree(start, mid, index * 2 + 1),
                constructSegmentTree(mid + 1, end, index * 2 + 2)
        );
        return segmentTree[index];
    }

    private long rangeQuery(int dataStart, int dataEnd, int queryStart, int queryEnd, int index) {
        if (dataStart > queryEnd || dataEnd < queryStart) {
            return oufOfBoundDefaultValue;
        }
        if (queryStart <= dataStart && queryEnd >= dataEnd) {
            return segmentTree[index];
        }
        int mid = dataStart + (dataEnd - dataStart) / 2;
        return merger.merge(
                rangeQuery(dataStart, mid, queryStart, queryEnd, index * 2 + 1),
                rangeQuery(mid + 1, dataEnd, queryStart, queryEnd, index * 2 + 2)
        );
    }

    public long rangeQuery(int start, int end) {
        return rangeQuery(0, data.length - 1, start, end, 0);
    }

    private long update(int dataStart, int dataEnd, int dataIndex, int segmentIndex, long value) {
        if(dataStart > dataEnd) {
            return oufOfBoundDefaultValue;
        }
        if (dataIndex < dataStart || dataIndex > dataEnd) {
            return segmentTree[segmentIndex];
        }
        if (dataStart == dataEnd) {
            segmentTree[segmentIndex] = value;
            return segmentTree[segmentIndex];
        }

        int mid = dataStart + (dataEnd - dataStart) / 2;
        segmentTree[segmentIndex] = merger.merge(
                update(dataStart, mid, dataIndex, segmentIndex * 2 + 1, value),
                update(mid + 1, dataEnd, dataIndex, segmentIndex * 2 + 2, value)
        );
        return segmentTree[segmentIndex];
    }

    public void update(int index, long value) {
        update(0, data.length - 1, index, 0, value);
    }


    interface SegmentTreeMerger {
        long merge(long a, long b);
    }
}