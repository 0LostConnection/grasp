package com.gs;

import com.gs.controller.OrderController;
import com.gs.model.Order;
import com.gs.repository.ProductRepository;

import java.math.BigDecimal;

/**
 * Classe principal que simula a camada de apresentação (UI) da aplicação.
 * Ela interage com o sistema através do OrderController, demonstrando o
 * padrão GRASP Controller.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Inicialização da infraestrutura (repositórios e controllers)
        ProductRepository productRepository = new ProductRepository();
        OrderController orderController = new OrderController(productRepository);

        System.out.println("Bem-vindo ao sistema de pedidos!");
        System.out.println("===================================");

        // 2. Simulação do fluxo de usuário através do Controller
        // O Main (UI) não interage diretamente com o modelo (Order), apenas com o Controller.
        System.out.println("Criando um novo pedido...");
        Order myOrder = orderController.createOrder();

        System.out.println("\nAdicionando produtos ao pedido:");
        // Adiciona o produto com ID 1 (Notebook Gamer)
        boolean added1 = orderController.addProductToOrder(myOrder, 1, 1);
        if (added1) {
            System.out.println("- Produto ID 1 adicionado com sucesso.");
        }

        // Adiciona o produto com ID 3 (Teclado Mecânico)
        boolean added2 = orderController.addProductToOrder(myOrder, 3, 2);
        if (added2) {
            System.out.println("- Produto ID 3 adicionado com sucesso.");
        }

        // Tenta adicionar um produto que não existe
        boolean added3 = orderController.addProductToOrder(myOrder, 99, 1);
        if (!added3) {
            System.out.println("- Produto ID 99 não encontrado.");
        }

        // 3. Exibição do resultado final
        System.out.println("\n===================================");
        System.out.println("Resumo do Pedido:");
        myOrder.getItems().forEach(item ->
                System.out.printf("  - Item: %s | Quantidade: %d | Subtotal: R$ %.2f%n",
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getSubtotal())
        );

        BigDecimal total = myOrder.getTotal();
        System.out.printf("%nTotal do Pedido: R$ %.2f%n", total);
        System.out.println("===================================");
    }
}
