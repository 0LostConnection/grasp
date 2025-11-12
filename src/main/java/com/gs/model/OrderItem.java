package com.gs.model;

import java.math.BigDecimal;

/**
 * Representa um item dentro de um pedido.
 * Contém o produto e a quantidade.
 * Esta classe também possui Alta Coesão, focada apenas em representar um item de pedido.
 */
public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    /**
     * Calcula o subtotal para este item (preço do produto * quantidade).
     * @return O subtotal do item.
     */
    public BigDecimal getSubtotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
