package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:56
 * @Description: 鸡蛋（具体装饰）
 */
public class EggFood extends FoodDecorate {

    public EggFood(Food food) {
        super(food);
    }

    @Override
    public int cost() {
        return 2 + super.cost();
    }

    @Override
    public String description() {
        return "鸡蛋" + super.description();
    }
}
