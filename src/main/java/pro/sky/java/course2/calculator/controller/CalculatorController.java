package pro.sky.java.course2.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;
    String result;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("plus")
    public String calcPlus(@RequestParam(value = "num1", required = false) String num1Str,
                           @RequestParam(value = "num2", required = false) String num2Str) {
        if (num1Str == null || num2Str == null) {
            return "Введите два параметра";
        }
        result = calculatorService.calcPlus(num1Str, num2Str);
        return "Результат сложения чисел " + num1Str + " и " + num2Str + ": " + result;
    }

    @GetMapping("/minus")
    public String calcMinus(@RequestParam(value = "num1", required = false) String num1Str,
                            @RequestParam(value = "num2", required = false) String num2Str) {
        if (num1Str == null || num2Str == null) {
            return "Введите два параметра";
        }
        result = calculatorService.calcMinus(num1Str, num2Str);
        return "Результат вычитания чисел " + num1Str + " и " + num2Str + ": " + result;
    }

    @GetMapping("/multiple")
    public String calcMultiple(@RequestParam(value = "num1", required = false) String num1Str,
                               @RequestParam(value = "num2", required = false) String num2Str) {
        if (num1Str == null || num2Str == null) {
            return "Введите два параметра";
        }
        result = calculatorService.calcMultiple(num1Str, num2Str);
        return "Результат умножения чисел " + num1Str + " и " + num2Str + ": " + result;
    }

    @GetMapping("/divide")
    public String calcDivide(@RequestParam(value = "num1", required = false) String num1Str,
                             @RequestParam(value = "num2", required = false) String num2Str) {
        if (num1Str == null || num2Str == null) {
            return "Введите два параметра";
        }
        result = calculatorService.calcDivide(num1Str, num2Str);
        return "Результат деления чисел " + num1Str + " и " + num2Str + ": " + result;
    }
}