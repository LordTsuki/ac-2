package com.example.ac2.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ac2.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    List<Projeto> findByNomeLike(Long nome);

    @Query("select cc from Projeto cc left join fetch cc.projetos c where cc.id = :id")
    Projeto findProjetoFetchProjetos(@Param("id") Long id);

    @Query("select cc from Projeto cc left join fetch cc.projetos c where cc.dataInicio < :dataFim and cc.dataFim > :dataInicio ")
    Projeto findProjetoFetchProjetos(@Param("data") LocalDate data);
}
