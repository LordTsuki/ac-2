package com.example.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private Long id;
    private String nome;
    private Long setorId;
    private Long projetoId;
}
