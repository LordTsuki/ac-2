package com.example.ac2.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProjetoDTO {
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private FuncionarioDTO funcionario;
}
