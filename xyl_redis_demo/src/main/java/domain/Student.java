package domain;

import java.io.Serializable;

/**
 * Created by meridian on 2019/7/27.
 */
public class Student implements Serializable{
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
