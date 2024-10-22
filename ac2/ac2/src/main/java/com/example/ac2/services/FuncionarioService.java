package com.example.ac2.services;

import java.util.*;
import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.dtos.DadosFuncionarioDTO;
import com.example.ac2.models.Funcionario;

public interface FuncionarioService {
    Funcionario salvar(FuncionarioDTO funcionarioDTO);
    DadosFuncionarioDTO obterFuncionarioPorId(Long id);
    void remover(Long id);
    void editar(Long id, FuncionarioDTO funcionarioDto);
    List<DadosFuncionarioDTO> obterTodos();
}

