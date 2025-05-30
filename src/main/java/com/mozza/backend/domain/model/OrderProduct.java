package com.mozza.backend.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {

    private Long id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Long productId;

    public BigDecimal getTotalITem(){
        return this.price.multiply(quantity);


    }
}
