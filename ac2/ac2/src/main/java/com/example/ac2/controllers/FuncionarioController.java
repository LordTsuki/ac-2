package com.example.ac2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.models.Funcionario;
import com.example.ac2.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvar(@RequestBody FuncionarioDTO dto) {
        return funcionarioService.salvar(dto);
    }
}