package com.prod.order.controller;

import com.prod.order.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Slf4j
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public ModelAndView product(){
        ModelAndView view = new ModelAndView();

        view.addObject("productList", productService.getProductList());
        view.setViewName("/prod/product");
        return view;
    }
}
