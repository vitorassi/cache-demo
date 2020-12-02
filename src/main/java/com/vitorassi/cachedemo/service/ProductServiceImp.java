package com.vitorassi.cachedemo.service;

import com.vitorassi.cachedemo.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImp implements ProductService{

    private final List<Product> mockProductsDB = initProduct();

    private List<Product> initProduct() {
        ArrayList<Product> list = new ArrayList(
                Arrays.asList(
                        Product.builder().id(1l).name("BANANA").build(),
                        Product.builder().id(2l).name("GRAPE").build(),
                        Product.builder().id(3l).name("WATERMELON").build(),
                        Product.builder().id(4l).name("APPLE").build(),
                        Product.builder().id(5l).name("MELON").build(),
                        Product.builder().id(6l).name("KHAKI").build(),
                        Product.builder().id(7l).name("LEMON").build(),
                        Product.builder().id(8l).name("TANGERINE").build(),
                        Product.builder().id(9l).name("TANGERINE").build()));

        return  list;

    }

    @Override
    @Cacheable("findProduct")
    public List<Product> findProduct(String name) {

        simulateSlowService();

        if(name != null) {
            Stream<Product> result
                    = mockProductsDB.stream().filter(product -> product.getName().contains(name.toUpperCase()));
            return result.collect(Collectors.toList());
        }
        return mockProductsDB;
    }

    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
