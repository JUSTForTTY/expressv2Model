package com.hundsun.jresplus.quickstart.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.hundsun.jresplus.common.util.Money;

/**
 * 货币计算的工具类。
 * 
 * @version v1.0.0
 */
public class MoneyUtil {

    /**
     * 转化金额格式，以元为单位0.00元
     * @param money
     * @return
     */
    public static String getMoneyDesc(Long money) {
        if (money == null) {
            return "0.00";
        }
        Money costPriceM = new Money();
        costPriceM.setCent(money);
        return costPriceM.toString();
    }

    /**
     * 转化金额格式，以元为单位0.00元
     * @param money
     * @return
     */
    public static String getMoneyDesc(Double moneyYuan) {
        if (moneyYuan == null) {
            return "0.00";
        }
        Money costPriceM = new Money();
        costPriceM.setAmount(new BigDecimal(moneyYuan.toString()));
        return costPriceM.toString();
    }

    /*
     * 将价格左移2位小数
     */
    public static String priceFormat(Long price) {
        DecimalFormat ft1 = new DecimalFormat("0.00");
        String data = ft1.format(new BigDecimal((double) price / 100));
        return data;
    }

    /*
     * 将费率左移三位小数
     */
    public static String rateFormat(Integer rate) {
        DecimalFormat ft = new DecimalFormat("0.000");
        String data = ft.format(new BigDecimal((double) rate / 1000));
        return data;
    }
}
