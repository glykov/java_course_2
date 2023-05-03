package pro.sky.store.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
@SessionScope
public class Cart {
    List<Integer> products = new ArrayList<>();

    public void add(Integer value) {
        products.add(value);
    }

    public void addAll(Collection<Integer> values) {
        products.addAll(values);
    }

    public List<Integer> getAll() {
        return products;
    }
}
