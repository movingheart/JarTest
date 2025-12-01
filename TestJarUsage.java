import itranswrap.sample.Hello;
import itranswrap.world.Person;

public class TestJarUsage {
    public static void main(String[] args) {
        // 使用Hello类
        Hello hello = new Hello();
        hello.hi();
        
        // 使用Person类
        Person.main(new String[]{});
    }
}