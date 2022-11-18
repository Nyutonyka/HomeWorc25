package homeWork9;

public class MyList implements CustomCollection{

    private Element first;
    private int size;

    public MyList() {

    }

    public Element getFirst() {
        return first;
    }

    public void setFirst(Element first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public boolean add(int iD,String dD) {
        Element newElement = new Element(iD,dD);
        newElement.setNext(first);
        first = newElement;
        size++;
        return true;
        }


    @Override
    public boolean add(String dD) {
        Element newElement = new Element(dD);
        newElement.setNext(first);
        first = newElement;
        size++;
        return true;
    }

    @Override
    public boolean addAll(MyList element) {
        Element current = element.first;
        add(current.getdData());
        while (current.getNext() != null) {
            add(current.getNext().getdData());
            current = current.getNext();
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        Element current = first;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        delete(current.getdData());
        return true;
    }

    @Override
    public boolean delete(String str) {
        Element previous = first;
        Element current = first;
        while (!current.getdData().equals(str)) {
            if (current.getdData() == null) return false;
            else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current == first) {
            first = first.getNext();
        } else previous.setNext(current.getNext());
        size--;
        return true;
    }

    @Override
    public String get(int index) {
        Element current = first;
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        return i + " - " + current.getdData();
    }

    @Override
    public boolean contains(String str) {
        Element current = first;
        while (current.getNext() != null) {
            current = current.getNext();
            if (current.getdData().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        first.setNext(null);
        first = null;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean trim() {
        return false;
    }

    public void showMyList () {

        Element current = first;
        if (current == null) System.out.println("Collection is empty.");
        while (current != null) {
            current.showElement();
            current = current.getNext();
        }
        System.out.println("");
    }

}



