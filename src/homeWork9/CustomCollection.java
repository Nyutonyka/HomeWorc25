package homeWork9;

public interface CustomCollection {


    boolean add(String str);

    boolean addAll(MyList name);

    boolean delete (int index);

    boolean delete (String str);

    String get(int index);

    boolean contains(String str);

    boolean clear();

    int size();

    boolean trim();
}
