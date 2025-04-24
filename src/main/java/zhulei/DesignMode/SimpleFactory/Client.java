package zhulei.DesignMode.SimpleFactory;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2022/8/5 20:59
 * @Description:
 */
public class Client {

    @Test
    void fun() {
        // 加法工厂
        Operation add = Factory.createFactory("+");
        System.out.println(add.getResult(1.2, 2.5));

        // 除法工厂
        Operation div = Factory.createFactory("/");
        System.out.println(div.getResult(2.5, 0));
    }
}
