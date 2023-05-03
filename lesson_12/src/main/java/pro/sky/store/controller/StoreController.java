package pro.sky.store.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.store.service.StoreService;

import java.util.*;

@RestController
public class StoreController {
    private final StoreService service;

    public StoreController(StoreService service) {
        this.service = service;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to the best store ever";
    }

    @GetMapping("/order/add")
    public void addProducts(@RequestParam List<Integer> id){
        service.addProducts(id);
    }

    @GetMapping("/order/get")
    public List<Integer> getProducts() {
        return service.getProducts();
    }
}
