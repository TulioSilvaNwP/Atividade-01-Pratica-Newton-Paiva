package com.example.pratica01.Service;

import org.springframework.stereotype.Service;

import com.example.pratica01.Model.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> aluno = alunos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
        return aluno.orElse(null);
    }

    public Aluno adicionar(Aluno aluno) {
        alunos.add(aluno);
        return aluno;
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId().equals(id)) {
                alunos.set(i, alunoAtualizado);
                return alunoAtualizado;
            }
        }
        return null;
    }

    public boolean remover(Long id) {
        return alunos.removeIf(a -> a.getId().equals(id));
    }
}
