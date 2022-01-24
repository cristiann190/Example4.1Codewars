package src;

import java.util.ArrayList;

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
}