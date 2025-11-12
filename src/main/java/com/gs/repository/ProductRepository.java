package com.gs.repository;

import com.gs.model.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Repositório para gerenciar o acesso aos dados de produtos.
 * Simula um banco de dados em memória.
 *
 * GRASP: Information Expert (Especialista da Informação)
 * Justificativa: Esta classe é a especialista em conhecer e encontrar produtos.
 * Qualquer parte do sistema que precise de informações sobre produtos deve consultar
 * este repositório. Isso centraliza o acesso aos dados e facilita a manutenção,
 * pois se a forma de armazenamento de produtos mudar (ex: de memória para um banco de dados),
 * apenas esta classe precisará ser modificada.
 */
public class ProductRepository {

    private final Map<Integer, Product> products = new HashMap<>();

    public ProductRepository() {
        // Carga inicial de produtos para simulação
        products.put(1, new Product(1, "Notebook Gamer", new BigDecimal("7500.00")));
        products.put(2, new Product(2, "Mouse sem Fio", new BigDecimal("150.00")));
        products.put(3, new Product(3, "Teclado Mecânico", new BigDecimal("450.00")));
    }

    public Optional<Product> findById(int id) {
        return Optional.ofNullable(products.get(id));
    }
}
