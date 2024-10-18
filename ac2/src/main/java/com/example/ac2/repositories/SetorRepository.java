package com.example.ac2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.ac2.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long>{
    @Query("select cc from Setor cc left join fetch cc.setores c where cc.id = :id ")
    Setor findSetorFetchSetores(@Param("id") Long id);
}