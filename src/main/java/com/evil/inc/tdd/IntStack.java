package com.evil.inc.tdd;

public class IntStack {
    public static final int DEFAULT_CAPACITY = 1;
    private int size;
    private int capacity;
    private int[] elements;

    public IntStack(final int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public IntStack() {
        this.capacity = DEFAULT_CAPACITY;
        this.elements = new int[DEFAULT_CAPACITY];
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(final int element) {
        if(size == capacity){
            throw new IntStackOverflowException("Overflow");
        }
        elements[size++] = element;
    }

    public int pop() {
        if(size == 0){
            throw new IntStackUnderflowException("Underflow");
        }
        return elements[--size];
    }

    private class IntStackOverflowException extends RuntimeException {
        public IntStackOverflowException(final String message) {
            super(message);
        }
    }

    private class IntStackUnderflowException extends RuntimeException {
        public IntStackUnderflowException(final String message) {
            super(message);
        }
    }
}
