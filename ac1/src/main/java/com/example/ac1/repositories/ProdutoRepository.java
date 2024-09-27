package com.example.ac1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ac1.models.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select p from Produto p join p.produtos where produtos.preco > :preco")
    List<Produto> findByMaiorPreco(Double preco);

    @Query("select p from Produto p join p.produtos where produtos.preco < :preco")
    List<Produto> findByMenorPreco(Double preco);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :nome%")
    List<Produto> findByNome(String nome);
}