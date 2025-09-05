package com.example.pratica01.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.pratica01.Model.Aluno;
import com.example.pratica01.Service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @PostMapping
    public Aluno adicionar(@RequestBody Aluno aluno) {
        return alunoService.adicionar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizar(id, alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        alunoService.remover(id);
    }
}
