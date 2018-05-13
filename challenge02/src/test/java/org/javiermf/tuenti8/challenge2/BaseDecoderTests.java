package org.javiermf.tuenti8.challenge2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseDecoderTests {

    @Test
    public void voidDeberiaCalcularElMaximo() {
        assertEquals(21, new BaseDecoder("bfd").getMaxInBase().intValue());
    }

    @Test
    public void voidDeberiaCalcularElMinimo() {
        assertEquals(11, new BaseDecoder("bfd").getMinInBase().intValue());
    }

    @Test
    public void voidDeberiaCalcularLosRangos() {
        assertEquals(10, new BaseDecoder("bfd").rangeDifference().longValue());
        assertEquals(153, new BaseDecoder("xwyz").rangeDifference().longValue());
        assertEquals(36445, new BaseDecoder("qwerty").rangeDifference().longValue());
        assertEquals(0, new BaseDecoder("bf").rangeDifference().longValue());
    }
}
