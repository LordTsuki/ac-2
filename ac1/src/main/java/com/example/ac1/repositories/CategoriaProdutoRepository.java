package com.example.ac1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.ac1.models.CategoriaProduto;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer> {

    @Query("select pp from CategoriaProduto pp left join fetch pp.produtos p where pp.id = :id")
    CategoriaProduto findCategoriaProdutoFetchProdutos(@Param("id") Long id);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :nome%")
    List<CategoriaProduto> findByNome(String nome);

}
