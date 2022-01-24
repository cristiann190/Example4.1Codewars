package src;


import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConversionTest {
    private Conversion conversion = new Conversion();

    @Test
    public void shouldConvertToRoman() {
        assertEquals("I", conversion.solution(1), "solution(1) should equal to I");
        assertEquals("IV", conversion.solution(4), "solution(4) should equal to IV");
        assertEquals("VI", conversion.solution(6), "solution(6) should equal to VI");
        assertEquals("MIX", conversion.solution(1009), "solution(6) should equal to VI");
        assertEquals("MLXVI", conversion.solution(1066), "solution(6) should equal to VI");
        assertEquals("MDCCLXXVI", solution(1776), "solution(6) should equal to VI");
    }

    private static TreeMap<Integer, String> MAP;
    static {
        MAP = new TreeMap<Integer, String>(Collections.reverseOrder());
        MAP.put( 1, "I" );
        MAP.put( 4, "IV" );
        MAP.put( 5, "V" );
        MAP.put( 9, "IX" );
        MAP.put( 10, "X" );
        MAP.put( 40, "XL" );
        MAP.put( 50, "L" );
        MAP.put( 90, "XC" );
        MAP.put( 100, "C" );
        MAP.put( 400, "CD" );
        MAP.put( 500, "D" );
        MAP.put( 900, "CM" );
        MAP.put( 1000, "M" );
    }

    public String solution(int n) {
        StringBuilder builder = new StringBuilder();
        for( Map.Entry<Integer, String> entry: MAP.entrySet() ){
            int i = entry.getKey();
            String s = entry.getValue();
            while( n>=i ){
                builder.append(s);
                n -= i;
            }
        }
        return builder.toString();
    }
}