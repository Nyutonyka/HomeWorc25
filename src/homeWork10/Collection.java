package homeWork10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collection {

    static public List<Number> collection;

    public static void main(String[] args) {

        collection = new ArrayList<>();

        collection.add(new Number(1));
        collection.add(new Number(2));
        collection.add(new Number(1));
        collection.add(new Number(3));
        collection.add(new Number(2));
        collection.add(new Number(0));
        collection.add(new Number(1));
        collection.add(new Number(4));
        collection.add(new Number(5));

        for (Number item : collection) {
            System.out.print(item);
        }
        System.out.print("\n");

        //Set<Number> numberSet = Service.removingDuplicates();

        Set<Number> numberSet = new HashSet<>(collection);

        for (Number item : numberSet) {
            System.out.print(item);
        }
    }
}
