package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:58
 * @Description: 牛肉（具体装饰）
 */
public class BeefFood extends FoodDecorate {

    public BeefFood(Food food) {
        super(food);
    }

    @Override
    public int cost() {
        return 5 + super.cost();
    }

    @Override
    public String description() {
        return "牛肉" + super.description();
    }
}
