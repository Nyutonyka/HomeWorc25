package homeWork10;
//
//import java.util.ArrayList;
//import java.util.ConcurrentModificationException;
//import java.util.NoSuchElementException;
//
//public class Iterator implements java.util.Iterator<E> {
//
//    int cursor;       // index of next element to return
//    int lastRet = -1; // index of last element returned; -1 if no such
//    private int modCount;
//    int expectedModCount = modCount;
//
//    // prevent creating a synthetic constructor
//    Iterator() {
//    }
//
//    public boolean hasNext() {
//        return cursor != size;
//    }
//
//    @SuppressWarnings("unchecked")
//    public E next() {
//        checkForComodification();
//        int i = cursor;
//        if (i >= size)
//            throw new NoSuchElementException();
//        Object[] elementData = ArrayList.this.elementData;
//        if (i >= elementData.length)
//            throw new ConcurrentModificationException();
//        cursor = i + 1;
//        return (E) elementData[lastRet = i];
//    }
//
//    public void remove() {
//        if (lastRet < 0)
//            throw new IllegalStateException();
//        checkForComodification();
//
//        try {
//            ArrayList.this.remove(lastRet);
//            cursor = lastRet;
//            lastRet = -1;
//            expectedModCount = modCount;
//        } catch (IndexOutOfBoundsException ex) {
//            throw new ConcurrentModificationException();
//        }
//    }
//}
