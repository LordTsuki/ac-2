package com.example.ac2.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.ac2.dtos.SetorDTO;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.exceptions.RegraNegocioException;
import com.example.ac2.models.Setor;
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
        return projetoRepository.save(projeto);
    }
    @Override
    public DadosCursoDTO obterCursoPorId(Long id) {
    return cursoRepository.findById(id).map((Curso c) -> {
    return DadosCursoDTO.builder()
    .id(c.getId())
    .nome(c.getNome())
    .cargaHoraria(c.getCargaHoraria())
    .categoria(CategoriaCursoDTO.builder()
    .id(c.getCategoriaCurso().getId())
    .nome(c.getCategoriaCurso().getNome())
    .build())
    .build();
    }).orElseThrow(() -> new RegraNegocioException("Curso não encontrado."));
    }
    @Override
    @Transactional
    public void remover(Long id) {
    cursoRepository.deleteById(id);
    }
    @Override
    @Transactional
    public void editar(Long id, CursoDTO cursoDto) {
    Curso curso = cursoRepository.findById(id)
    .orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
    CategoriaCurso categoria = categoriaCursoRepository.findById(
    cursoDto.getCategoriaCursoId())
    .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada"));
    curso.setNome(cursoDto.getNome());
    curso.setCargaHoraria(cursoDto.getCargaHoraria());
    curso.setCategoriaCurso(categoria);
    cursoRepository.save(curso);
    }
    @Override
    public List<DadosCursoDTO> obterTodos() {
    return cursoRepository.findAll().stream().map((Curso c) -> {
    return DadosCursoDTO.builder()
    .id(c.getId())
    .nome(c.getNome())
    .cargaHoraria(c.getCargaHoraria())
    .categoria(CategoriaCursoDTO.builder()
    .id(c.getCategoriaCurso().getId())
    .nome(c.getCategoriaCurso().getNome())
    .build())
    .build();
    }).collect(Collectors.toList());
    }
}