package com.acmetelecom.billing.util;

import java.math.BigDecimal;

/**
 * 
 * @Static
 */
public class MoneyFormatter {
    public static String penceToPounds(BigDecimal pence) {
        BigDecimal pounds = pence.divide(new BigDecimal(100));
        return String.format("%.2f", pounds.doubleValue());
    }
}
