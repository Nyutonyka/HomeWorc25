package homeWork8;

public class MyArrayList implements Collection{

    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    @Override
    public boolean add(String o) {
        return false;
    }

    @Override
    public boolean add(int index, String o) {
        return false;
    }

    @Override
    public boolean delete(String o) {
        return false;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean contain(String o) {
        return false;
    }

    @Override
    public boolean equals(Collection str) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
