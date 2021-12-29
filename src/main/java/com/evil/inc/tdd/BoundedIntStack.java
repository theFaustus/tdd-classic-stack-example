package com.evil.inc.tdd;

public class BoundedIntStack {
    private int size = 0;
    private int capacity;
    private int[] elements;
    private int top;

    public BoundedIntStack(int capacity) {
        if(capacity < 0){
            throw new IllegalStackCapacityException("Capacity must be greater or equal than 0");
        }
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public int size() {
        return size;
    }

    public void push(int element) {
        if (size == capacity) {
            throw new StackOverflowException("Stack overflow exception");
        }
        this.top = element;
        this.elements[size++] = element;
    }

    public int pop() {
        if (size == 0) {
            throw new StackUnderflowException("Stack underflow exception");
        }
        int element = elements[--size];
        this.top = elements[size == 0 ? size : size - 1];
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int top() {
        if (size == 0) {
            throw new StackUnderflowException("Stack underflow exception");
        }
        return this.top;
    }

    static class StackUnderflowException extends RuntimeException {
        public StackUnderflowException(String message) {
            super(message);
        }
    }

    static class StackOverflowException extends RuntimeException {
        public StackOverflowException(String message) {
            super(message);
        }
    }

    static class IllegalStackCapacityException extends RuntimeException {
        public IllegalStackCapacityException(String message) {
            super(message);
        }
    }
}
