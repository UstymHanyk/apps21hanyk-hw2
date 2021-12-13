package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableList arrayList;

    @Before
    public void setUp() {
        arrayList = new ImmutableArrayList();
    }

    @Test
    public void testAdd() {
        ImmutableList actualResult = arrayList.add(5);
        Object[] expRes = {5};
        assertArrayEquals(expRes, actualResult.toArray());
    }


    @Test
    public void testAddAll() {
        ImmutableList actualResult = arrayList.addAll(new Object[]{5,10});
        Object[] expRes = {5,10};
        assertArrayEquals(expRes, actualResult.toArray());
    }

    @Test
    public void testGet() {
        ImmutableList actualResult = arrayList.addAll(new Object[]{5,10});
        Object expRes = 10;
        assertEquals(expRes, actualResult.get(1));
    }

    @Test
    public void testRemove() {
        ImmutableList actualResult = arrayList.addAll(new Object[]{5,10});
        ImmutableList resArr = actualResult.remove(0);
        Object[] expRes = {10};
        assertArrayEquals(expRes, resArr.toArray());
    }

    @Test
    public void testSet() {
        ImmutableList newArr = arrayList.addAll(new Object[]{1, 2, 3});
        ImmutableList actualResult = newArr.set(1, 5);
        Object[] expRes = {1, 5, 3};
        assertArrayEquals(expRes, actualResult.toArray());
    }

    @Test
    public void testIndexOf() {
        ImmutableList actualResult = arrayList.addAll(new Object[]{5});
        assertEquals(0, actualResult.indexOf(5));
        assertEquals(-1, actualResult.indexOf(1));
    }

    @Test
    public void testSize() {
        assertEquals(0, arrayList.size());
        ImmutableList actualResult = arrayList.addAll(new Object[]{5,10});
        assertEquals(2, actualResult.size());

    }

    @Test
    public void testClear() {
        ImmutableList newArr = arrayList.addAll(new Object[]{5,10});
        ImmutableList actualResult = newArr.clear();
        Object[] expRes = {};
        assertArrayEquals(expRes, actualResult.toArray());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(arrayList.isEmpty());
        ImmutableList actualResult = arrayList.addAll(new Object[]{1, 2, 3});
        assertTrue(!actualResult.isEmpty());
    }

    @Test
    public void testToArrayEmpty() {
        Object[] expRes = {};
        assertArrayEquals(expRes, arrayList.toArray());
    }
    @Test
    public void testToArray(){
        Object[] expRes = {5};
        ImmutableList actualResult = arrayList.addAll(new Object[]{5});
        assertArrayEquals(expRes, actualResult.toArray());
    }
}