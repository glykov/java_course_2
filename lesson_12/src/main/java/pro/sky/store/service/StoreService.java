package pro.sky.store.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import pro.sky.store.model.Cart;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final Cart cart;

    public StoreService(Cart cart) {
        this.cart = cart;
    }

    public void addProducts(List<Integer> input) {
        cart.addAll(input);
    }

    public List<Integer> getProducts() {
        return cart.getAll();
    }
}
