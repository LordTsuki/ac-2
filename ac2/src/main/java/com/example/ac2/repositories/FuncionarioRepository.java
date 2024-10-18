package com.example.ac2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findByNomeLike(String nome);

    @Query("select cc from Funcionario cc left join fetch cc.funcionarios c where cc.id = :id")
    Funcionario findFuncionarioFetchFuncionarios(@Param("id") Long id);
}
