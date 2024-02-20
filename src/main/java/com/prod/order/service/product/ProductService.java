package com.prod.order.service.product;

import com.prod.order.domain.product.Product;
import com.prod.order.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductMapper productMapper;

    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
}
