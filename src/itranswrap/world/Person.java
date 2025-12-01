package itranswrap.world;

import java.util.StringJoiner;

public class Person {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("".isEmpty());
        System.out.println(" ".isBlank());

        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        String s3 = "Hello, World!";
        int n = Integer.parseInt(s3);
        // 这行代码会抛出 NumberFormatException，因为 "Hello, World!" 不能转换为整数
        try {
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("无法将字符串转换为整数: " + e.getMessage());
        }
    }

}
