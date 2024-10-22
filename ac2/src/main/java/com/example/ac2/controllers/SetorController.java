package com.example.ac2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.models.Setor;
import com.example.ac2.services.SetorService;

@RestController
@RequestMapping("/api/setor")
public class SetorController {
    private SetorService setorService;
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setor salvar(@RequestBody SetorDTO dto) {
        return setorService.salvar(dto);
    }
}