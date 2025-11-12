package com.gs.controller;

import com.gs.model.Order;
import com.gs.model.Product;
import com.gs.repository.ProductRepository;

import java.util.Optional;

/**
 * GRASP: Controller (Controlador)
 *
 * Justificativa: Esta classe atua como um intermediário entre a camada de
 * apresentação (a classe Main, que simula a UI) e a camada de domínio (model).
 * Ela recebe as requisições, como "criar um pedido" ou "adicionar um item",
 * e coordena as ações necessárias, delegando o trabalho para as classes de
 * domínio e repositórios apropriados.
 *
 * Benefícios:
 * 1. Low Coupling (Baixo Acoplamento): A camada de apresentação (Main) não
 *    conhece os detalhes da lógica de negócio. Ela apenas se comunica com o
 *    controlador. Isso significa que a lógica de negócio pode mudar sem que
 *    a UI precise ser alterada.
 * 2. High Cohesion (Alta Coesão): As responsabilidades de controle do fluxo
 *    de eventos do sistema estão centralizadas aqui, enquanto as classes de
 *    domínio (Order, Product) mantêm seu foco em suas próprias responsabilidades.
 */
public class OrderController {

    private final ProductRepository productRepository;

    public OrderController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Order createOrder() {
        return new Order();
    }

    public boolean addProductToOrder(Order order, int productId, int quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            order.addItem(productOpt.get(), quantity);
            return true;
        }
        return false; // Produto não encontrado
    }
}
