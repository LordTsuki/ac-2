package com.example.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.dtos.FuncionarioDTO;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.Funcionario;
import com.example.ac2.models.Projeto;
import com.example.ac2.repositories.FuncionarioRepository;
import com.example.ac2.repositories.ProjetoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService {
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;
    
    @Override
    @Transactional
    public Projeto salvar(ProjetoDTO projetoDTO) {
        Funcionario func = funcionarioRepository
            .findById(projetoDTO.getFuncionarioId())
            .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
        
        Projeto projeto = new Projeto();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());
        projeto.setFuncionario(func);
        return projetoRepository.save(projeto);
    }

    @Override
    public DadosProjetoDTO obterProjetoPorId(Long id) {
        return projetoRepository.findById(id).map((Projeto c) -> {
            return DadosProjetoDTO.builder()
            .id(c.getId())
            .descricao(c.getDescricao())
            .dataInicio(c.getDataInicio())
            .dataFim(c.getDataFim())
            .funcionario(FuncionarioDTO.builder()
                .id(c.getFuncionario().getId())
                .nome(c.getFuncionario().getNome())
                .build())
            .build();
        }).orElseThrow(() -> new RegraNegocioException("Projeto não encontrado."));
    }

    @Override
    @Transactional
    public void remover(Long id) {
        projetoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void editar(Long id, ProjetoDTO projetoDto) {
        Projeto projeto = projetoRepository.findById(id)
            .orElseThrow(() -> new RegraNegocioException("Projeto não encontrado"));
        
        Funcionario funcionario = funcionarioRepository.findById(
            projetoDto.getFuncionarioId())
            .orElseThrow(() -> new RegraNegocioException("Funcionario não encontrada"));
        
        projeto.setDescricao(projetoDto.getDescricao());
        projeto.setDataInicio(projetoDto.getDataInicio());
        projeto.setDataFim(projetoDto.getDataFim());
        projeto.setFuncionario(funcionario);

        projetoRepository.save(projeto);
    }

    @Override
    public List<DadosProjetoDTO> obterTodos() {
        return projetoRepository.findAll().stream().map((Projeto c) -> {
            return DadosProjetoDTO.builder()
                .id(c.getId())
                .descricao(c.getDescricao())
                .dataInicio(c.getDataInicio())
                .dataFim(c.getDataFim())
                .funcionario(FuncionarioDTO.builder()
                    .id(c.getFuncionario().getId())
                    .nome(c.getFuncionario().getNome())
                    .build())
                .build();
        }).collect(Collectors.toList());
    }
}