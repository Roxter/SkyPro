package collections.controller;

import collections.service.StoreService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public String showGreetings() {
        return "Добро пожаловать в интернет-магазин";
    }

    @GetMapping("/add")
    public String addObject(@RequestParam(value = "id") Integer id) {
        storeService.addToBasket(id);
        return "Товар с Id " + id + " добавлен.";
    }

    @GetMapping("/get")
    public String getFromBasket() throws JsonProcessingException {
        try {
            String goods = storeService.getFromBasket();
        } catch (JsonProcessingException n) {
            n.getStackTrace();
        }
        return "Список товаров по id: \n" + goods;
    }
}
