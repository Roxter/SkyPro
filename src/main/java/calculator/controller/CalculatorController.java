package calculator.controller;

import calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("plus")
    public String plus(@RequestParam(value = "num1") Integer num1,
                       @RequestParam(value = "num2") Integer num2) {
        return calculatorService.sum(num1, num2);
    }

    @GetMapping("minus")
    public String minus(@RequestParam(value = "num1") Integer num1,
                        @RequestParam(value = "num2") Integer num2) {
        return calculatorService.substract(num1, num2);
    }

    @GetMapping("multiply")
    public String multiply(@RequestParam(value = "num1") Integer num1,
                           @RequestParam(value = "num2") Integer num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("divide")
    public String divide(@RequestParam(value = "num1") Integer num1,
                         @RequestParam(value = "num2") Integer num2) {
        try {
            return calculatorService.divide(num1, num2);
        } catch (IllegalArgumentException e1) {
            return "Ошибка второго аргумента. Нельзя делить на 0";
        }
    }
}
