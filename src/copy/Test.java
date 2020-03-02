package copy;

import java.io.IOException;

/**
 * @Author JH
 **/
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
//        Teacher teacher = new Teacher("Delacey",29);
//        Student student1 = new Student("Dream",18,teacher);
//        Student student2 = (Student) student1.clone();
//        System.out.println("拷贝后");
//        System.out.println(student2.getName());
//        System.out.println(student2.getAge());
//        System.out.println(student2.getTeacher().getName());
//        System.out.println(student2.getTeacher().getAge());
//        System.out.println("修改老师的信息后-------------");
//
//        teacher.setName("Jam");
//        System.out.println(student1.getTeacher().getName());
//        System.out.println(student2.getTeacher().getName());

//        拷贝后
//                Dream
//        18
//        Delacey
//        29
//        修改老师的信息后-------------
//                Jam
//        Jam


//        Teacher teacher = new Teacher("Delacey",29);
//        Student2 student1 = new Student2("Dream",18,teacher);
//        Student2 student2 = (Student2) student1.clone();
//        System.out.println("拷贝后");
//        System.out.println(student2.getName());
//        System.out.println(student2.getAge());
//        System.out.println(student2.getTeacher().getName());
//        System.out.println(student2.getTeacher().getAge());
//        System.out.println("修改老师的信息后-------------");
//
//        teacher.setName("Jam");
//        System.out.println(student1.getTeacher().getName());
//        System.out.println(student2.getTeacher().getName());

//        拷贝后
//                Dream
//        18
//        Delacey
//        29
//        修改老师的信息后-------------
//                Jam
//        Delacey

        Teacher teacher = new Teacher("Delacey",29);
        Student3 student1 = new Student3("Dream",18,teacher);
        Student3 student2 = (Student3) student1.deepClone();
        System.out.println("拷贝后");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getAge());
        System.out.println("修改老师的信息后-------------");

        teacher.setName("Jam");
        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());

//        拷贝后
//                Dream
//        18
//        Delacey
//        29
//        修改老师的信息后-------------
//                Jam
//        Delacey


//        深拷贝是一个整个独立的对象拷贝，深拷贝会拷贝所有的属性,并拷贝属性指向的动态分配的内存。当对象和它所引用的对象一起拷贝时即发生深拷贝。深拷贝相比于浅拷贝速度较慢并且花销较大。
//
//        简而言之，深拷贝把要复制的对象所引用的对象都复制了一遍。

//        被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。即对象的浅拷贝会对“主”对象进行拷贝，但不会复制主对象里面的对象。”里面的对象“会在原来的对象和它的副本之间共享。
//
//        简而言之，浅拷贝仅仅复制所考虑的对象，而不复制它所引用的对象

    }
}
