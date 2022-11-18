package homeWork9;

import java.util.Objects;

public class Element {

    private int iData;
    private String dData;
    private Element next;

    public Element(String dData) {
    }

    public Element( int iD, String dD) {
        this.iData = iD;
        this.dData = dD;
    }

    public String getdData() {
        return dData;
    }

    public void setdData(String dData) {
        this.dData = dData;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return iData == element.iData && Objects.equals(dData, element.dData) && Objects.equals(next, element.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iData, dData, next);
    }

    public void showElement() {
        System.out.print(dData + ", " );
    }
}
