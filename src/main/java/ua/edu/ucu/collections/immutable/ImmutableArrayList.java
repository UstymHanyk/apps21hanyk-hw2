package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] arrayList;

    public ImmutableArrayList(Object[] elements) {
        arrayList = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        arrayList = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return add(arrayList.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index < 0 || index > arrayList.length) {
            throw new IllegalArgumentException();
        }
        Object[] addedObjectList = new Object[arrayList.length + 1];
        System.arraycopy(arrayList, 0, addedObjectList, 0, index);
        addedObjectList[index] = e;
        System.arraycopy(arrayList, index, addedObjectList, index + 1, arrayList.length - index);
        return new ImmutableArrayList(addedObjectList);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(arrayList.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > arrayList.length) {
            throw new IllegalArgumentException();
        }
        Object[] addedObjectList = new Object[arrayList.length + c.length];
        System.arraycopy(arrayList, 0, addedObjectList, 0, index);
        System.arraycopy(c, 0, addedObjectList, index, c.length);
        System.arraycopy(arrayList, index, addedObjectList, index + c.length, arrayList.length - index);
        return new ImmutableArrayList(addedObjectList);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > arrayList.length) {
            throw new IllegalArgumentException();
        }
        return arrayList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index > arrayList.length) {
            throw new IllegalArgumentException();
        }
        Object[] removedList = new Object[arrayList.length - 1];
        int newIndex = 0;
        for (int oldIndex = 0; oldIndex < arrayList.length; oldIndex++) {
            if (oldIndex != index) {
                removedList[newIndex] = arrayList[oldIndex];
                newIndex++;
            }
        }
        return new ImmutableArrayList(removedList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index > arrayList.length) {
            throw new IllegalArgumentException();
        }
        Object[] newArrayList = toArray();
        newArrayList[index] = e;
        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arrayList.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arrayList, arrayList.length);
    }

}
