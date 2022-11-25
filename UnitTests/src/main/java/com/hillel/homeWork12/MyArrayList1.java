package com.hillel.homeWork12;

import java.util.Arrays;

import static java.lang.System.arraycopy;


public class MyArrayList1 implements Collection{

    private static String[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    static int size;
    private int filledCellCounter;

    public static String[] getElementData() {
        return elementData;
    }

    public static void setElementData(String[] elementData) {
        MyArrayList1.elementData = elementData;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        MyArrayList1.size = size;
    }

    public int getFilledCellCounter() {
        return filledCellCounter;
    }

    public void setFilledCellCounter(int filledCellCounter) {
        this.filledCellCounter = filledCellCounter;
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
        if (e == null) return false;
        getExpandArray();
        for (int i = 0; i < elementData.length; ) {
            if (elementData[i] != null) i++;
            else if (elementData[i] == null) {
                elementData[i] = e;
                size++;
                break;
            }
        }
        return true;
    }

    @Override
    public boolean add(int index, String e) {
        if (index < 0 || index > elementData.length - 1) return false;
        else if (index >= 0 && index <= (elementData.length - 1)) {
            addOneCell(index);
            elementData[index] = e;
            size++;
        }
        return true;
    }

    @Override
    public boolean delete(String e) {
        boolean found = false;
        for (int i = 0; i < elementData.length; i++) {
            if (e.equals(elementData[i])) {
                int index = i;
                deleteOneCell(index);
                size--;
                found = true;
            }
        }
        return found;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= elementData.length) {
            return null;
        }
        return elementData[index];
    }

    @Override
    public boolean contain(String e) {
        for (int i = 0; i < elementData.length; i++) {
            if (e.equals(elementData[i])) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        if (this == str) return true;
        if (!(str instanceof MyArrayList1 that)) return false;
        return Arrays.equals(getElementData(), that.getElementData());
    }

    @Override
    public boolean clear() {
        int length = elementData.length;
        elementData = new String[length];
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

private void countBusyCells(String[] elementData) {
    filledCellCounter = 0;
    for (int i = 0; i < elementData.length; i++) {
        if (elementData[i] != null) filledCellCounter++;
    }
}

    private void addOneCell(int index) {
        String[] newArray;
        newArray = new String[elementData.length + 1];
        arraycopy(elementData, 0, newArray, 0, elementData.length);
        elementData = new String[newArray.length];
        arraycopy(newArray, 0, elementData, 0, newArray.length);
        arraycopy(newArray, index, elementData, index + 1, elementData.length - (index + 1));
        countBusyCells(elementData);
    }

    private void deleteOneCell(int index) {
        String[] newArray;
        newArray = new String[elementData.length];
        arraycopy(elementData, 0, newArray, 0, elementData.length);
        arraycopy(newArray, index + 1, elementData, index, elementData.length - (index + 1));
        elementData[elementData.length -1] = null;
    }


    private void getExpandArray() {
        countBusyCells(elementData);
        String[] newArray;
        if (filledCellCounter > (elementData.length - 3)) {
            newArray = new String[elementData.length + 5];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = new String[newArray.length];
            System.arraycopy(newArray, 0, elementData, 0, newArray.length);
            countBusyCells(elementData);
        }
    }
}
