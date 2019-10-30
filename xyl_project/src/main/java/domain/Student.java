package domain;

import java.io.Serializable;

/**
 * Created by meridian on 2019/7/27.
 */
public class Student implements Serializable{
    private String name;
    private String sex;
    private int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age=" + age +
                '}';
    }
}
