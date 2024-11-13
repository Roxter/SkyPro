package calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String sum(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }

    public String substract(Integer num1, Integer num2) {
        Integer result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    public String multiply(Integer num1, Integer num2) {
        Integer result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;
    }

    public String divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Ошибка второго аргумента. Нельзя делить на 0");
        }
        Integer result = num1 / num2;
        return num1 + " / " + num2 + " = " + result;
    }
}
