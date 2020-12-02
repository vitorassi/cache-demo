package com.vitorassi.cachedemo.service;

import com.vitorassi.cachedemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findProduct(String name);

}
