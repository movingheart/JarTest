import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class App {
    public static void main(String[] args) throws Exception {
        Log var1 = LogFactory.getLog(App.class);
        var1.debug("这是一个调试信息");
        var1.info("这是一个普通信息");
        var1.warn("这是一个警告信息");
        var1.error("这是一个错误信息");
        var1.fatal("这是一个致命错误信息");
        System.out.println("Hello, World!");
    }
}
