package catsbi.me.datastructure.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MyHeap<T extends Comparable<T>> {
    private List<T> heapArr;

    public MyHeap(T data) {
        initialize(data);
    }

    public boolean insert(T data) {
        int insertedIdx;
        int parentIdx;

        if (Objects.isNull(heapArr)) {
            initialize(data);
            return true;
        }

        this.heapArr.add(data);
        insertedIdx = this.heapArr.size() - 1;

        while (isMoveUp(insertedIdx)) {
            parentIdx = getParentIdx(insertedIdx);
            Collections.swap(heapArr, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    private boolean isMoveUp(Integer insertedIdx) {
        if (insertedIdx <= 1) {
            return false;
        }

        Integer parentIdx = getParentIdx(insertedIdx);
        return this.heapArr.get(insertedIdx)
                .compareTo(this.heapArr.get(parentIdx)) > 0;
    }

    private void initialize(T data) {
        this.heapArr = new ArrayList<>();
        this.heapArr.add(null);
        this.heapArr.add(data);
    }

    public T pop() {
        T returnData;
        int poppedIdx;
        int leftChildIdx;
        int rightChildIdx;

        if (this.heapArr.size() <= 1) {
            return null;
        }
        returnData = removeRootNode();
        poppedIdx = 1;

        while (isMoveDown(poppedIdx)) {
            leftChildIdx = getLeftChildIdx(poppedIdx);
            rightChildIdx = getRightChildIdx(poppedIdx);

            poppedIdx = getIndexAfterCompareAndSwap(leftChildIdx, rightChildIdx, poppedIdx);
        }

        return returnData;
    }

    private int getIndexAfterCompareAndSwap(int leftChildIdx, int rightChildIdx, int poppedIdx) {
        if (isEmptyChildNode(rightChildIdx)
                && this.heapArr.get(poppedIdx).compareTo(this.heapArr.get(leftChildIdx)) < 0
                || this.heapArr.get(leftChildIdx).compareTo(this.heapArr.get(rightChildIdx)) > 0
                && this.heapArr.get(poppedIdx).compareTo(this.heapArr.get(leftChildIdx)) < 0) {
            Collections.swap(this.heapArr, poppedIdx, leftChildIdx);
            return leftChildIdx;
        }

        if (this.heapArr.get(poppedIdx).compareTo(this.heapArr.get(rightChildIdx)) < 0) {
            Collections.swap(this.heapArr, poppedIdx, rightChildIdx);
            return rightChildIdx;
        }

        throw new IllegalStateException();
    }

    private boolean isMoveDown(int poppedIdx) {
        int leftChildIdx = getLeftChildIdx(poppedIdx);
        int rightChildIdx = getRightChildIdx(poppedIdx);

        //Case 1. 자식 노드가 없는 경우(양측)
        if (isEmptyChildNode(leftChildIdx)) {
            return false;
        }

        //Case 2. 우측 자식 노드만 없는 경우
        if (isEmptyChildNode(rightChildIdx)) {
            return this.heapArr.get(poppedIdx).compareTo(this.heapArr.get(leftChildIdx)) < 0;
        }

        //Case 3. 양측 노드가 모두 있는 경우
        if (this.heapArr.get(leftChildIdx).compareTo(this.heapArr.get(rightChildIdx)) > 0) {
            return this.heapArr.get(poppedIdx).compareTo(this.heapArr.get(leftChildIdx)) < 0;
        }

        return this.heapArr.get(poppedIdx).compareTo(this.heapArr.get(rightChildIdx)) < 0;
    }

    private boolean isEmptyChildNode(int idx) {
        return idx >= this.heapArr.size();
    }

    private int getRightChildIdx(int idx) {
        return getLeftChildIdx(idx) + 1;
    }

    private int getLeftChildIdx(int idx) {
        return idx * 2;
    }

    private T removeRootNode() {
        final T rootData = this.heapArr.get(1);
        this.heapArr.set(1, this.heapArr.get(this.heapArr.size() - 1));
        this.heapArr.remove(this.heapArr.size() - 1);

        return rootData;
    }


    private Integer getParentIdx(Integer idx) {
        return idx / 2;
    }

    @Override
    public String toString() {
        return "MyHeap{" +
                "heapArr=" + heapArr +
                '}';
    }
}
