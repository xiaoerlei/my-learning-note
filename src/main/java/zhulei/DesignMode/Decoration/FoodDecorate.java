package zhulei.DesignMode.Decoration;

/**
 * @Author: zl
 * @Date: 2022/8/12 21:38
 * @Description: 装饰器
 */
public abstract class FoodDecorate extends Food {

    private Food food;

    public FoodDecorate(Food food) {
        this.food = food;
    }

    @Override
    public int cost() {
        return food.cost();
    }

    @Override
    public String description() {
        return food.description();
    }
}
