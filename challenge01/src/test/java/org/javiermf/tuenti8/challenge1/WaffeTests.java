package org.javiermf.tuenti8.challenge1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaffeTests {

    @Test
    public void voidDeberiaCalcularLosCuadrados() {

        assertEquals(new Waffle(2, 2).squares(), 1);
        assertEquals(new Waffle(3, 2).squares(), 2);
        assertEquals(new Waffle(4, 3).squares(), 6);
    }
}
