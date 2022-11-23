package homeWork8;

import java.util.Arrays;

import static java.lang.System.arraycopy;


public class MyArrayList1 implements Collection{

    private static final int DEFAULT_CAPACITY = 10;;
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    static String[] elementData;
    static int size;


    public static String[] getElementData() {
        return elementData;
    }

    public static void setElementData(String[] elementData) {
        MyArrayList1.elementData = elementData;
    }

    public MyArrayList1(int initialCapacity) {
        elementData = new String[initialCapacity];
    }

    public MyArrayList1() {
        elementData = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        return "MyArrayList1{}" + Arrays.toString(elementData)
                + " size " + size;
    }

    @Override
    public boolean add(String e) {
        add(e, elementData, size);
        return true;
    }

    private void add(String e, String[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size++;
    }

    @Override
    public boolean add(int index, String o) {
        if (index < 0 || index > elementData.length - 1) return false;
        else if (index >= 0 && index <= (elementData.length - 1)) {
            grow();
            elementData[index] = o;
            size++;
        }
            return true;
    }

    @Override
    public boolean delete(String o) {
        final String[] es = elementData;
        final int s = size;
        int i = 0;
        found: {
            if (o == null) {
                for (; i < s; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < s; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= elementData.length) {
            return null;
        }
        return elementData[index];
    }

    @Override
    public boolean contain(String o) {
            return indexOf(o) >= 0;
        }

        public int indexOf(Object o) {
            return indexOfRange(o, 0, size);
        }

        int indexOfRange(Object o, int start, int end) {
            Object[] es = elementData;
            if (o == null) {
                for (int i = start; i < end; i++) {
                    if (es[i] == null) {
                        return i;
                    }
                }
            } else {
                for (int i = start; i < end; i++) {
                    if (o.equals(es[i])) {
                        return i;
                    }
                }
            }
            return -1;
        }

    @Override
    public boolean equals(Collection str) {
        if (this == str) return true;
        if (!(str instanceof MyArrayList1 that)) return false;
        return Arrays.equals(getElementData(), that.getElementData());
    }

    @Override
    public boolean clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private String[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        String[] newArray;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            newArray = new String[elementData.length + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = new String[newArray.length];
            System.arraycopy(newArray, 0, elementData, 0, newArray.length);
            System.arraycopy(newArray, size, elementData, size + 1, elementData.length - (size + 1));
            return elementData;
        } else {
            newArray = new String[elementData.length];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            System.arraycopy(newArray, size + 1, elementData, size,
                    elementData.length - (size + 1));
             return elementData = new String[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private String[] grow() {
        return grow(size + 1);
    }
}
