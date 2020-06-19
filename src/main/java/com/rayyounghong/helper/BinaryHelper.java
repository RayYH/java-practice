package com.rayyounghong.helper;

/**
 * @author ray
 * @date 2020/5/9
 */
public class BinaryHelper {

    public static Integer convertDecimalToBinary(Integer decimalNumber) {

        if (decimalNumber == 0) {
            return decimalNumber;
        }

        StringBuilder binaryNumber = new StringBuilder();
        int quotient = decimalNumber;
        while (quotient > 0) {
            int remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }

        binaryNumber = binaryNumber.reverse();

        return Integer.valueOf(binaryNumber.toString());
    }

    public static Integer convertBinaryToDecimal(Integer binaryNumber) {
        int decimalNumber = 0;
        int base = 1;

        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            binaryNumber = binaryNumber / 10;
            decimalNumber += lastDigit * base;
            base = base * 2;
        }
        return decimalNumber;
    }

    public static Integer addBinaryNumber(Integer firstNum, Integer secondNum) {
        StringBuilder output = new StringBuilder();
        int carry = 0;
        int temp;
        while (firstNum != 0 || secondNum != 0) {
            temp = (firstNum % 10 + secondNum % 10 + carry) % 2;
            output.append(temp);
            carry = (firstNum % 10 + secondNum % 10 + carry) / 2;
            firstNum = firstNum / 10;
            secondNum = secondNum / 10;
        }

        if (carry != 0) {
            output.append(carry);
        }

        return Integer.valueOf(output.reverse().toString());
    }
}
