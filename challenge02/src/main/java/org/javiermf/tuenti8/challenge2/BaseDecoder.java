package org.javiermf.tuenti8.challenge2;

import java.math.BigDecimal;

public class BaseDecoder {

    private final int base;

    public BaseDecoder(String code) {
        this.base = code.length();
    }

    public BigDecimal rangeDifference() {
        return getMaxInBase().subtract(getMinInBase());
    }

    protected BigDecimal getMinInBase() {
        // 1023456whatever
        int highestPos = base - 1;
        BigDecimal min = valueInPos(highestPos, 1);

        for (int pos = base - 3, value = 2; pos >= 0; pos--, value++) {
            min = min.add(valueInPos(pos, value));
        }

        return min;
    }

    protected BigDecimal getMaxInBase() {
        BigDecimal max = BigDecimal.valueOf(0);
        for (int pos = 0; pos < base; pos++) {
            max = max.add(valueInPos(pos, pos));
        }
        return max;
    }

    private BigDecimal valueInPos(int pos, int value) {
        return new BigDecimal(base).pow(pos).multiply(new BigDecimal(value));
    }

}
