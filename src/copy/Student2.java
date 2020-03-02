package copy;

/**
 * @Author JH
 *
 **/
public class Student2 implements Cloneable{
    private String name;
    private int age;
    private Teacher teacher;

    public Student2(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
//        Object object = super.clone();
//        return object;
        //通过将teacher进行拷贝实现深拷贝
        Student2 student = (Student2) super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }


}
