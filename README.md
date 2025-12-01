# 项目目标
演示jar包的使用

## 基本概念
什么是JAR包？
JAR（Java Archive）文件是一种压缩文件格式，以.jar作为扩展名。它是Java的归档文件，包含了：
• 编译后的Java类文件（.class）
• 相关的资源文件（图片、配置文件等）
• 元数据信息（META-INF/MANIFEST.MF）
JAR包的优势
• 便于分发：将多个文件打包成单一文件
• 简化部署：直接运行，无需单独管理多个类文件
• 版本控制：便于管理不同版本的程序
• 依赖管理：可以包含所有必需的依赖库

## 方式一：引用自己创建的jar包
1. 打包

```bash
# 进入项目根目录
cd JarTest

# 创建普通jar包（包含所有编译好的class文件）
jar cvf mylibrary.jar -C bin .
```

2. 编写测试文件`JarTest\TestJarUsage.java`,内容如下：

```java
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
```

3. 编译运行，命令如下：

```bash
# 编译测试文件
javac -cp mylibrary.jar TestJarUsage.java

# 运行测试类
java -cp "mylibrary.jar;." TestJarUsage
```

4. 输出如下：

```bash
(base) PS H:\javaSpace\DaBao\JarTest> java -cp "mylibrary.jar;." TestJarUsage
hello
false
true
true
true
Hello Bob, Alice, Grace!
Exception in thread "main" java.lang.NumberFormatException: For input string: "Hello, World!"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:662)
        at java.base/java.lang.Integer.parseInt(Integer.java:778)
        at itranswrap.world.Person.main(Person.java:22)
        at TestJarUsage.main(TestJarUsage.java:11)
```

## 方式二：直接运行jar包
1. 同方式一；
2. 运行jar包中的特定类：

```bash
# 运行App类（主类在JAR包中）
java -cp mylibrary.jar App

# 运行Person类
java -cp mylibrary.jar itranswrap.world.Person

# 运行Main类
java -cp mylibrary.jar itranswrap.sample.Main
```

## 查看java包内容
1. 查看jar包内容，命令：`jar tf mylibrary.jar`, 输出如下：

```bash
(base) PS H:\javaSpace\DaBao\JarTest> jar tf .\mylibrary.jar
META-INF/
META-INF/MANIFEST.MF
App.class
itranswrap/
itranswrap/sample/
itranswrap/sample/Hello.class
itranswrap/sample/Main.class
itranswrap/sample/Person.class
itranswrap/sample/Student.class
itranswrap/world/
itranswrap/world/Person.class
```

2. 详细查看jar包内容，包含大小和创建时间，命令：`jar tvf mylibrary.jar`, 输出如下：

```bash
(base) PS H:\javaSpace\DaBao\JarTest> jar tvf .\mylibrary.jar
     0 Mon Dec 01 11:40:58 GMT+08:00 2025 META-INF/
    66 Mon Dec 01 11:40:58 GMT+08:00 2025 META-INF/MANIFEST.MF
   562 Mon Dec 01 11:16:30 GMT+08:00 2025 App.class
     0 Mon Dec 01 11:17:30 GMT+08:00 2025 itranswrap/
     0 Mon Dec 01 11:19:26 GMT+08:00 2025 itranswrap/sample/
   492 Mon Dec 01 11:40:26 GMT+08:00 2025 itranswrap/sample/Hello.class
  1769 Mon Dec 01 11:18:46 GMT+08:00 2025 itranswrap/sample/Main.class
   417 Mon Dec 01 11:18:46 GMT+08:00 2025 itranswrap/sample/Person.class
   575 Mon Dec 01 11:18:46 GMT+08:00 2025 itranswrap/sample/Student.class
     0 Mon Dec 01 11:17:30 GMT+08:00 2025 itranswrap/world/
  2240 Mon Dec 01 11:18:24 GMT+08:00 2025 itranswrap/world/Person.class
```

3. 解压查看jar包内容：
```bash
# 新建一个目录（例如 unpacked）
mkdir unpacked

# 把 jar 内容解压到该目录
cd unpacked
jar xvf ../mylibrary.jar
```