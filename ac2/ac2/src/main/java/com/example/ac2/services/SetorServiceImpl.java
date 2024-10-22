package com.example.ac2.services;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.models.Setor;
import com.example.ac2.repositories.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService {
    private final SetorRepository setorRepository;
    @Override
    public Setor salvar(SetorDTO dto) {
        Setor setr = new Setor();
        setr.setNome(dto.getNome());
        return setorRepository.save(setr);
    }
}