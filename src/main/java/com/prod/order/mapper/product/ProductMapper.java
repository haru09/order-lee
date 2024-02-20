package com.prod.order.mapper.product;

import com.prod.order.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> getProductList();
}
