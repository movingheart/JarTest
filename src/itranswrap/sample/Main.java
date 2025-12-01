package itranswrap.sample;

import java.lang.reflect.Method;

// reflection
public class Main {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));
        // 获取public方法getScore，参数为String: 
        System.out.println(stdClass.getMethod("getScore", String.class));
        // 获取继承的public方法getName，无参数:
        System.out.println(stdClass.getMethod("getName", null));
        // 获取private方法getGrade，参数为int:
        System.out.println(stdClass.getDeclaredMethod("getGrade", int.class));

        System.out.println("***********调用方法***************");
        String s = "Hello World";
        Method m = String.class.getMethod("substring", int.class);
        String r = (String) m.invoke(s, 6);
        System.out.println(r);
        System.out.println("***********调用静态方法***************");
        Method mb = Integer.class.getMethod("parseInt", String.class);
        Integer n = (Integer) mb.invoke(null, "12345");
        System.out.println(n);

    }
}

class Student extends Person {
    public int score;
    private int grade;
    public int getScore(String type) {
        return score;
    }
    private int getGrade(int year) {
        return grade+year;
    }
}

class Person {
    public String name;
    public String getName() {
        return name;
    }
}
