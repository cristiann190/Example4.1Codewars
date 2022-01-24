package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Conversion {

    public String solution(int n) {
        ArrayList<Integer> digits = getDigits(n);
        StringBuilder romanNumber = new StringBuilder();
        int index = digits.size();
        for (Integer digit : digits) {
            romanNumber.append(getRomanNumberForDigit(digit, index--));
        }
        return romanNumber.toString();
    }

    private ArrayList<Integer> getDigits(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(0, n % 10);
            n = n / 10;
        }
        return digits;
    }

    private String getRomanNumberForDigit(int digit, int index) {
        if (digit == 0) {
            return "";
        }
        switch (index) {
            case 4:
                return getThousands(digit);
            case 3:
                return getHundreds(digit);
            case 2:
                return getTens(digit);
            case 1:
                return getUnits(digit);
            default:
                return "";
        }
    }

    private String getThousands(int digit) {
        return "M".repeat(digit);
    }

    private String getHundreds(int digit) {
        return getRomanNumberValue(digit, "C", "D", "M");
    }

    private String getTens(int digit) {
        return getRomanNumberValue(digit, "X", "L", "C");
    }

    private String getUnits(int digit) {
        return getRomanNumberValue(digit, "I", "V", "X");
    }

    private String getRomanNumberValue(int digit, String unitValue, String halfValue, String maxValue) {
        switch (digit) {
            case 1:
                return unitValue;
            case 2:
                return unitValue.repeat(2);
            case 3:
                return unitValue.repeat(3);
            case 4:
                return unitValue + halfValue;
            case 5:
                return halfValue;
            case 6:
                return halfValue + unitValue;
            case 7:
                return halfValue + unitValue.repeat(2);
            case 8:
                return halfValue + unitValue.repeat(3);
            case 9:
                return unitValue + maxValue;
        }
        return "";
    }

    ///////////////////////////////////////BEST OPTIMIZED EXAMPLE////////////////////////////////////////////////

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

    public String solutionOptimized(int n) {
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