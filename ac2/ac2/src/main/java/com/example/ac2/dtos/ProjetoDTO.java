package com.example.ac2.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long funcionarioId;
}
