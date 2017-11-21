package team.ruike.cim.util;

/**
 * 编号生成工具类
 * 单列类
 * @author 张振国
 * @version 1.0
 */
public class GenerateNumber {
    private GenerateNumber() {
    }
    private static final GenerateNumber generateNumber = new GenerateNumber();

    public static GenerateNumber getGenerateNumber() {
        return generateNumber;
    }
}
