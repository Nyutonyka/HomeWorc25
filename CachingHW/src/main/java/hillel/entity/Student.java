package hillel.entity;

import javax.persistence.*;

/**
 * @author Anna Babich
 */

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "Id" )
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Last_Name")
    private String lustName;


    public Student() {
    }

    public Student(String name, String lastName) {
        this.name = name;
        this.lustName = lastName;
    }

    public Student(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lustName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLustName() {
        return lustName;
    }

    public void setLustName(String lustName) {
        this.lustName = lustName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lustName='" + lustName + '\'' +
                '}';
    }
}
