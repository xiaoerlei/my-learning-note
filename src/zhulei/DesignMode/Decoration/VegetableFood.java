package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:59
 * @Description: 青菜（具体装饰）
 */
public class VegetableFood extends FoodDecorate {

    public VegetableFood(Food food) {
        super(food);
    }

    @Override
    public int cost() {
        return 1 + super.cost();
    }

    @Override
    public String description() {
        return "青菜" + super.description();
    }
}
