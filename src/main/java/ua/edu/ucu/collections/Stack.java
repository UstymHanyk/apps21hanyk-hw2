package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList;

    public Stack() {
        linkedList = new ImmutableLinkedList();
    }

    public void push(Object e) {
        linkedList = linkedList.addLast(e);
    }

    public Object pop() {
        Object lastStackElement = peek();
        linkedList = linkedList.removeLast();
        return lastStackElement;
    }

    public Object peek() {
        return linkedList.getLast();
    }
}
