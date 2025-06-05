package com.example.myrealestateproject;

import java.util.Arrays;

// a heap based priority queue implementation
public class KonutPriorityQueue {
    private Konut[] heap;
    private int size;

    public KonutPriorityQueue(int capacity) {
        heap = new Konut[capacity];
    }

    public Konut[] getHeap() {
        return heap;
    }

    public void insert(Konut value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        } else {
            heap[size] = value;
            fixUp(size++);
        }

    }

    public Konut delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        Konut max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        fixDown(0);

        return max;
    }

    private void fixUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (parentIndex >= 0 && (heap[parentIndex]).compareTo(heap[index]) < 0) {
            swap(parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void fixDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < size && (heap[leftChildIndex]).compareTo(heap[index]) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < size && (heap[rightChildIndex]).compareTo(heap[largestIndex]) > 0) {
            largestIndex = rightChildIndex;
        }

        if (index != largestIndex) {
            swap(index, largestIndex);
            fixDown(largestIndex);
        }
    }

    private void swap(int i, int j) {
        Konut temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isFull() {
        return size == heap.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(heap, 0, size));
    }
}
