package copy;

import java.io.Serializable;

/**
 * @Author JH
 **/
public class Teacher implements Cloneable,Serializable {

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        //对象拷贝
//        Teacher teacher = new Teacher("swift",26);
//        Teacher otherteacher = (Teacher) teacher.clone();
//        System.out.println(teacher);
//        System.out.println(otherteacher);
//        System.out.println(teacher == otherteacher); false

        //引用拷贝
//        Teacher teacher = new Teacher("swift",26);
//        Teacher otherteacher = teacher;
//        System.out.println(teacher);
//        System.out.println(otherteacher);
//        System.out.println(teacher == otherteacher); true

        //深拷贝 浅拷贝都是对象拷贝

    }


}
