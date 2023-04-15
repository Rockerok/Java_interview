package HW5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    int    id;
    String name;
    String mark;

    public Student() {}

    public Student(int id, String name, String mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMark(String s) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student {id = " + String.valueOf(id) + ", name = '" + name + "', mark = '" + mark + "'}";
    }
}
