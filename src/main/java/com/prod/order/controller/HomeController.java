package com.prod.order.controller;

import com.prod.order.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class HomeController {

    private final ProductService productService;

    @GetMapping("/")
    public String home(){
        log.info("productList: {}", productService.getProductList());
        return "/page/home";
    }
}
