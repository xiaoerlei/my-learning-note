package zhulei.DesignMode.Strategy;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:25
 * @Description:
 */
@Data
@AllArgsConstructor
public class StrategyDetail {

    private double discount;

    private Pair<Integer, Integer> reduction;
}
