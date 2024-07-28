package pro.sky.java.course2.weblibrary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.weblibrary.service.CounterService;

@RestController // Создать объект этого класса / Маршрутизировать запросы сюда / Вернуть обратно объект или строку
//@RequestMapping("/library")   // Определить уровень всех директорий от данного каталога
public class FirstController {
    private final CounterService counterService;
    private int requestCounter;

    public FirstController(CounterService counterservice) {
        this.counterService = counterservice;
    }

    @GetMapping // Приём HTTP запроса типа GET
    public String showHelloWorld() {
        return "Hello, world!";
    }

    @GetMapping("/counter")
    public String showCounter() {
        return "количество запросов: " + counterService.requestCount();
    }

    @GetMapping(path = "/greetings")   // Параметры не работают
    public String showGreetings(String userNameF, String userNameL) {
        return "Hello, " + userNameL + " " + userNameF + "!";
    }

    @GetMapping("/greetings1")   // Не работает вообще
    public String showGreetings1(@RequestParam String userNameF, @RequestParam String userNameL) {
        return "Hello, " + userNameL + " " + userNameF + "!";
    }

    @GetMapping("/greetings2")   // Не работает вообще
    public String showGreetings2(@RequestParam(required = true) String userNameF, @RequestParam(required = true) String userNameL) {
        return "Hello, " + userNameL + " " + userNameF + "!";
    }

    @GetMapping("/greetings3")   // Корректно и с параметрами работает только этот вариант
    public String showGreetings3(@RequestParam("name") String userNameF, @RequestParam("lastName") String userNameL) {
        return "Hello, " + userNameL + " " + userNameF + "!";
    }
}