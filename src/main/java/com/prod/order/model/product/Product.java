package com.prod.order.model.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    //seq, prod_cd, ctgr_nm, prod_nm, std, color, price, note, reg_dts, regr_no
    private long seq;
    private String prodCd;
    private String ctgrNm;
    private String prodNm;
    private String std;
    private String color;
    private long price;
    private String note;
    private String regDts;
    private String regrNo ;
}
