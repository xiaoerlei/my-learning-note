package zhulei.DesignMode.SimpleFactory;

/**
 * @Author: zl
 * @Date: 2022/8/5 22:42
 * @Description:
 */
public class Factory {

    public static Operation createFactory(String opt) {
        Operation operation = null;
        switch (opt) {
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Sub();
                break;
            case "*":
                operation = new Mul();
                break;
            case "/":
                operation = new Div();
                break;
            default:
                System.out.println("输入有误");
                break;
        }
        return operation;
    }
}
