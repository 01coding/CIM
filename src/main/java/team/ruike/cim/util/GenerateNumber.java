package team.ruike.cim.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 编号生成工具类
 * 单列类
 *
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

    /*随机数11位*/
    public Integer getUUID() {
        String uuid = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        uuid.substring(0).toString();
        uuid = uuid.substring(0, 11);
        return Integer.valueOf(uuid);
    }

    //生产批次 11
    public  String getRandomFileName() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (999 - 100 + 1)) + 100;// 获取5位随机数

        return rannum + str;// 当前时间
    }

    public static void main(String[] args) {
        System.out.println(getRandomFileName());
    }
}
