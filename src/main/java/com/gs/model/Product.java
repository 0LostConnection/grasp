package com.gs.model;

import java.math.BigDecimal;

/**
 * Representa um produto na loja.
 * É uma classe simples de dados (POJO/DTO) com alta coesão,
 * pois sua única responsabilidade é representar os dados de um produto.
 */
public class Product {
    private final int id;
    private final String name;
    private final BigDecimal price;

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
