package test2;

import java.util.Arrays;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Student> set=new TreeSet<>();
        set.add(new Student(19));
        set.add(new Student(17));
        System.out.println(set);
    }
    static class Student implements Comparable<Student>{
        int age;
        public Student(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Student o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    '}';
        }
    }
}
