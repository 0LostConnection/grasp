package com.gs.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um pedido, que contém uma lista de itens.
 * Esta classe aplica os princípios GRASP de Creator e High Cohesion.
 */
public class Order {

    private final List<OrderItem> items = new ArrayList<>();

    /**
     * Adiciona um produto ao pedido com uma determinada quantidade.
     *
     * GRASP: Creator (Criador)
     * Justificativa: A classe Order é responsável por criar instâncias de OrderItem.
     * Isso faz sentido porque Order "agrega" ou "contém" OrderItems. A criação de um
     * OrderItem está intimamente ligada à existência de um Order. Portanto, Order é o
     * candidato ideal para ser o criador de OrderItem, conforme o princípio Creator.
     *
     * @param product O produto a ser adicionado.
     * @param quantity A quantidade do produto.
     */
    public void addItem(Product product, int quantity) {
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
    }

    /**
     * Calcula o valor total do pedido.
     *
     * GRASP: High Cohesion (Alta Coesão)
     * Justificativa: A responsabilidade de calcular o total do pedido está na própria
     * classe Order. Isso mantém a coesão alta, pois a classe Order é a que possui
     * as informações necessárias (a lista de itens) para realizar o cálculo.
     * Manter essa lógica aqui evita espalhar o conhecimento sobre a estrutura interna
     * de um pedido por outras partes do sistema.
     *
     * @return O valor total do pedido.
     */
    public BigDecimal getTotal() {
        return items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items); // Retorna uma cópia para proteger a lista original
    }
}
