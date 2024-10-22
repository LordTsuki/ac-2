package com.example.ac2.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.dtos.DadosFuncionarioDTO;
import com.example.ac2.dtos.DadosProjetoDTO;
import com.example.ac2.dtos.ProjetoDTO;
import com.example.ac2.models.Projeto;
import com.example.ac2.services.FuncionarioService;
import com.example.ac2.services.ProjetoService;

@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {
    private ProjetoService projetoService;
    private FuncionarioService funcionarioService;
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto salvar(@RequestBody ProjetoDTO projetoDTO) {
        Projeto c = projetoService.salvar(projetoDTO);
        return c;
    }

    @GetMapping("{id}")
    public DadosProjetoDTO getProjetoPorId(@PathVariable Long id) {
        return projetoService.obterProjetoPorId(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjeto(@PathVariable Long id) {
        projetoService.remover(id);
    }

    @PutMapping("{id}")
    public void editProjeto(@PathVariable Long id, @RequestBody ProjetoDTO dto) {
        projetoService.editar(id, dto);
    }

    @GetMapping
    public List<DadosProjetoDTO> getProjetos() {
        return projetoService.obterTodos();
    }

    @PostMapping("/{idProjeto}/vincular-funcionario/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Long idProj, @PathVariable Long idFunc) {
        DadosProjetoDTO projeto = projetoService.obterProjetoPorId(idProj);
        DadosFuncionarioDTO funcionario = funcionarioService.obterFuncionarioPorId(idFunc);

        if (projeto == null || funcionario == null) {
            return ResponseEntity.notFound().build();
        }

        projetoService.vincularFuncionario(projeto, funcionario);
        return ResponseEntity.ok().build();
    }
}