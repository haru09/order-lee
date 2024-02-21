package com.prod.order.domain.product;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    private long seq;
    private String prodCd;
    private long price;
    private String regDts;
    private String regrNo ;
}
