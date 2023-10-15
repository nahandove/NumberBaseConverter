package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Converter {
    public void openMenu(String answer) {
        String[] entries = answer.split(" ");
        String number = "";
        while (true) {
            ConsoleHelper.writeMessage(String.format("Enter number in base %s to convert to base %s (to go back type /back) ",
                    entries[0], entries[1]));
            number = ConsoleHelper.readString();
            if ("/back".equals(number)) {
                break;
            }
            String decimalNumber = convertToDecimal(number, Integer.parseInt(entries[0]));
            String targetNumber = convertToTargetBase(decimalNumber, Integer.parseInt(entries[1]));
            ConsoleHelper.writeMessage(String.format("Conversion result: %s\n\n", targetNumber));
        }
        ConsoleHelper.writeMessage("\n");
        Main.mainMenu();
    }

    private String convertToDecimal(String number, int radix) {
        if (!number.contains(".")) {
            return new BigInteger(number, radix).toString();
        }
        String[] numberParts = number.split("\\.");
        return new BigInteger(numberParts[0], radix) + "." + convertFractionToDecimal(numberParts[1], radix);
    }

    private String convertToTargetBase(String decimalNumber, int radix) {
        if (!decimalNumber.contains(".")) {
            return new BigInteger(decimalNumber).toString(radix);
        }
        String[] numberParts = decimalNumber.split("\\.");
        return new BigInteger(numberParts[0]).toString(radix) + "." + convertFractionToTargetBase(numberParts[1], radix);
    }

    private String convertFractionToDecimal(String fractionalPart, int radix) {
        double total = 0;
        for (int i = 0; i < fractionalPart.length(); i++) {
            int value = Character.getNumericValue(fractionalPart.charAt(i));
            total += value * Math.pow(radix, -(i + 1));
        }
        BigDecimal bigDecimal = new BigDecimal(total);
        bigDecimal = bigDecimal.setScale(6, RoundingMode.HALF_UP);
        String decimalFractionalPart = String.valueOf(bigDecimal.multiply(BigDecimal.valueOf(Math.pow(10, 6))));
        String decimalIntPart = decimalFractionalPart.split("\\.")[0];
        if (decimalIntPart.length() < 6) {
            decimalIntPart = "0" + decimalIntPart;
        }
        return decimalIntPart;
    }

    private String convertFractionToTargetBase(String decimalPart, int radix) {
        int count = 0;
        String fractionalString = "0." + decimalPart;
        String convertedNumber = "";
        BigDecimal fractionalNumber = new BigDecimal(fractionalString);
        fractionalNumber = fractionalNumber.setScale(6, RoundingMode.HALF_UP);
        while(count < 5) {
            fractionalNumber = fractionalNumber.multiply(BigDecimal.valueOf(radix));
            String productString = "" + fractionalNumber;
            String[] numberParts = productString.split("\\.");
            convertedNumber += new BigInteger(numberParts[0]).toString(radix);
            fractionalNumber = fractionalNumber.subtract(BigDecimal.valueOf(Double.parseDouble(numberParts[0])));
            count++;
        }

        return convertedNumber;
    }
}
