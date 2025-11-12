# Projeto GRASP: Sistema de Pedidos Simples

## Princípios GRASP Aplicados

Foram aplicados os seguintes princípios GRASP:

1.  **Creator (Criador)**
2.  **Controller (Controlador)**
3.  **High Cohesion (Alta Coesão)**
4.  **Information Expert (Especialista da Informação)** - Implícito no `ProductRepository` e `Order`.

### Detalhes da Aplicação dos Princípios

*   **Creator (Criador)**
    *   **Onde:** Classe `com.gs.model.Order` no método `addItem(Product product, int quantity)`.
    *   **Por que:** A classe `Order` é responsável por criar instâncias de `OrderItem`. Isso faz sentido porque `Order` "agrega" ou "contém" `OrderItem`s. A criação de um `OrderItem` está intimamente ligada à existência de um `Order`, tornando `Order` o candidato ideal para ser o criador de `OrderItem`.

*   **Controller (Controlador)**
    *   **Onde:** Classe `com.gs.controller.OrderController`.
    *   **Por que:** Esta classe atua como um intermediário entre a camada de apresentação (simulada pela classe `Main`) e a camada de domínio (`Order`, `Product`). Ela recebe as requisições (ex: "criar um pedido", "adicionar um item") e coordena as ações necessárias, delegando o trabalho para as classes de domínio e repositórios apropriados. Isso promove **Low Coupling** (Baixo Acoplamento) entre a UI e a lógica de negócio.

*   **High Cohesion (Alta Coesão)**
    *   **Onde:** Classes `com.gs.model.Product`, `com.gs.model.OrderItem`, `com.gs.model.Order`.
    *   **Por que:** Cada uma dessas classes possui responsabilidades bem definidas e focadas. Por exemplo, `Product` apenas representa dados de um produto, `OrderItem` representa um item de pedido e `Order` gerencia a coleção de `OrderItem`s e calcula o total. A responsabilidade de calcular o total do pedido está na própria classe `Order`, pois ela possui as informações necessárias (a lista de itens) para realizar o cálculo.

*   **Information Expert (Especialista da Informação)**
    *   **Onde:** Classe `com.gs.repository.ProductRepository` e `com.gs.model.Order`.
    *   **Por que:** `ProductRepository` é o especialista em conhecer e fornecer dados de produtos. `Order` é o especialista em calcular seu próprio total, pois possui todos os `OrderItem`s.