package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head, tail;
    private int listLength;

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length == 0) {
            head = null;
            tail = null;
            return;
        }
        listLength = elements.length;
        head = new Node();
        head.setValue(elements[0]);
        Node prevNode = head;
        Node currNode;
        for (int i = 1; i < elements.length; i++) {
            currNode = new Node();
            currNode.setValue(elements[i]);
            currNode.setPrevious(prevNode);
            prevNode.setNext(currNode);
            prevNode = currNode;
        }
        tail = prevNode;
    }

    public ImmutableLinkedList() {
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(listLength, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > listLength) {
            throw new IllegalArgumentException();
        }
        Node iterHeadNode = head;

        Object[] addedList = new Object[listLength + c.length];

        int i = 0;
        while (i < index) {
            addedList[i] = iterHeadNode.getValue();
            iterHeadNode = iterHeadNode.getNext();
            i++;
        }

        for (int j = 0; j < c.length; j++) {
            addedList[i] = c[j];
            i++;
        }

        while (iterHeadNode != null) {
            addedList[i] = iterHeadNode.getValue();
            iterHeadNode = iterHeadNode.getNext();
            i++;
        }

        return new ImmutableLinkedList(addedList);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > listLength) {
            throw new IllegalArgumentException();
        }
        Object[] arr = toArray();
        return arr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > listLength) {
            throw new IllegalArgumentException();
        }
        Object[] listArray = toArray();

        Object[] removedList = new Object[size() - 1];

        System.arraycopy(listArray, 0, removedList, 0, index);
        System.arraycopy(listArray, index + 1, removedList, index, size() - index - 1);
        return new ImmutableLinkedList(removedList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] listArray = toArray();
        listArray[index] = e;
        return new ImmutableLinkedList(listArray);
    }

    @Override
    public int indexOf(Object e) {

        Node iterHeadNode = head;
        int i = 0;
        while (iterHeadNode != null) {
            if (iterHeadNode.getValue() == e) {
                return i;
            }
            iterHeadNode = iterHeadNode.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        return listLength;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Object[] toArray() {
        Object[] resultArray = new Object[size()];
        int i = 0;
        Node iterHeadNode = head;
        while (iterHeadNode != null) {
            resultArray[i] = iterHeadNode.getValue();
            iterHeadNode = iterHeadNode.getNext();
            i++;
        }
        return resultArray;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return getHead().getValue();
    }

    public Object getLast() {
        return getTail().getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] removedArray = toArray();
        Object[] resultList = new Object[removedArray.length - 1];
        System.arraycopy(removedArray, 1, resultList, 0, removedArray.length - 1);
        return new ImmutableLinkedList(resultList);
    }

    public ImmutableLinkedList removeLast() {
        Object[] removedArray = toArray();
        Object[] resultList = new Object[removedArray.length - 1];
        System.arraycopy(removedArray, 0, resultList, 0, removedArray.length - 1);
        return new ImmutableLinkedList(resultList);
    }
}
