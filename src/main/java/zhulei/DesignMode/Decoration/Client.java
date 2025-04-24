package zhulei.DesignMode.Decoration;

import org.junit.jupiter.api.Test;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:37
 * @Description:
 */
public class Client {

    @Test
    void fun() {
        Food noodles = new Noodles();
        EggFood eggNoodles = new EggFood(noodles);
        HumFood humNoodles = new HumFood(eggNoodles);
        System.out.println(humNoodles.description() + "花费：" + humNoodles.cost() + "元");

        Food rice = new Rice();
        VegetableFood vRice = new VegetableFood(rice);
        BeefFood beefRice = new BeefFood(vRice);
        System.out.println(beefRice.description() + "花费：" + beefRice.cost() + "元");
    }

}
