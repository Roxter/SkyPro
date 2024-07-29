package pro.sky.java.course2.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String calcPlus(String numStr1, String numStr2) {
        double num1 = Double.parseDouble(numStr1);
        double num2 = Double.parseDouble(numStr2);
        double result = num1 + num2;
        return String.format("%f", result);
    }

    public String calcMinus(String numStr1, String numStr2) {
        double num1 = Double.parseDouble(numStr1);
        double num2 = Double.parseDouble(numStr2);
        double result = num1 - num2;
        return String.format("%f", result);
    }

    public String calcMultiple(String numStr1, String numStr2) {
        double num1 = Double.parseDouble(numStr1);
        double num2 = Double.parseDouble(numStr2);
        double result = num1 * num2;
        return String.format("%f", result);
    }

    public String calcDivide(String numStr1, String numStr2) {
        double num1 = Double.parseDouble(numStr1);
        double num2 = Double.parseDouble(numStr2);
        if (num1 == 0 || num2 == 0) {
            return "0";
        } else {
            double result = num1 / num2;
            return String.format("%f", result);
        }
    }
}