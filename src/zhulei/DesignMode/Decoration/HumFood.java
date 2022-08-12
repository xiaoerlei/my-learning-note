package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:50
 * @Description: 火腿（具体装饰）
 */
public class HumFood extends FoodDecorate {

    public HumFood(Food food) {
        super(food);
    }

    @Override
    public int cost() {
        return 2 + super.cost();
    }

    @Override
    public String description() {
        return "火腿" + super.description();
    }
}
