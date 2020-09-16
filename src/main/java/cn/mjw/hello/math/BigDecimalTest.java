package cn.mjw.hello.math;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author JiaweiMao 2017-05-02
 * @since 1.0-SNAPSHOT
 */
class BigDecimalTest
{
    @Test
    void setScale()
    {
        BigDecimal decimal = new BigDecimal("5.196469");
        decimal = decimal.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal.doubleValue());
    }

}
