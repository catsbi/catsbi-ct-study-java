package catsbi.me.datastructure.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapTest {

    @Test
    void test() {
        MyHeap<Integer> heap = new MyHeap<>(15);
        heap.insert(10);
        heap.insert(8);
        heap.insert(5);
        heap.insert(4);
        heap.insert(20);

        System.out.println("heap.getArray() = " + heap);

        heap.pop();
        System.out.println("heap = " + heap);
    }

}
