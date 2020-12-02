package com.vitorassi.cachedemo.controller;

import com.vitorassi.cachedemo.model.Product;
import com.vitorassi.cachedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @GetMapping
    private @ResponseBody List<Product> findProductByName(@RequestParam(value = "nameProduct", required = false) String name){
        return productService.findProduct(name);
    }

}
