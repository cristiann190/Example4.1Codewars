package src;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionTest {
    private final Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("I", conversion.solution(1), "solution(1) should equal to I");
        assertEquals("IV", conversion.solution(4), "solution(4) should equal to IV");
        assertEquals("VI", conversion.solution(6), "solution(6) should equal to VI");
        assertEquals("MIX", conversion.solution(1009), "solution(6) should equal to VI");
        assertEquals("MLXVI", conversion.solution(1066), "solution(6) should equal to VI");
        assertEquals("MDCCLXXVI", conversion.solution(1776), "solution(6) should equal to VI");
    }
}