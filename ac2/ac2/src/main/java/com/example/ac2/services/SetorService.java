package com.example.ac2.services;

import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.models.Setor;

public interface SetorService {
    Setor salvar(SetorDTO dto);
}