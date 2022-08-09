package zhulei.DesignMode.Strategy;

import lombok.Getter;

/**
 * @Author: zl
 * @Date: 2022/8/9 23:32
 * @Description:
 */
@Getter
public enum StrategyEnum {

    NORMAL(1, "正常模式"),
    DISCOUNT_7(11, "打7折模式"),
    DISCOUNT_8(12, "打8折模式"),
    REDUCTION_300_20(21, "满300减20模式"),
    REDUCTION_500_40(22, "满500减40模式"),
    ;


    private int type;
    private String name;

    StrategyEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

}
