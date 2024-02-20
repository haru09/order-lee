package com.prod.order.domain.product;

import lombok.Data;

@Data
public class Product {
    private long seq;
    private String prod_cd;
    private long price;
    private Data reg_dts;
    private String regr_no ;
}
