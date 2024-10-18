package com.example.ac2.services;

import java.util.*;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.models.Projeto;

public interface ProjetoService {
    Projeto salvar(ProjetoDTO projetoDTO);
    DadosProjetoDTO obterProjetoPorId(Long id);
    void remover(Long id);
    void editar(Long id, ProjetoDTO projetoDto);
    List<DadosProjetoDTO> obterTodos();
}
