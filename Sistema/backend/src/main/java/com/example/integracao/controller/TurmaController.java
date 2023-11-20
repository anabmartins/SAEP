package com.example.integracao.controller;

import com.example.integracao.model.Turma;
import com.example.integracao.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/turmas")
public class TurmaController {
    @Autowired
    private TurmaRepository turmaRepository;

    // GET
    @GetMapping
    public List<Turma> listarUsuarios() {
        return turmaRepository.findAll();
    }

    // POST
    @PostMapping
    public Turma criarUsuario(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    // DELETE
    @DeleteMapping("/{id_turma}")
    public ResponseEntity<String> deletarTurma(@PathVariable Long id_turma) {
        if (turmaRepository.existsById(id_turma)) {
            turmaRepository.deleteById(id_turma);
            return ResponseEntity.ok("turma deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT
    @PutMapping("/{id_usuario}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable Long id_turma,
            @RequestBody Turma turmaAtualizada) {
        if (turmaRepository.existsById(id_turma)) {
            Turma turma = turmaRepository.findById(id_turma).get();
            turma.setNome(turmaAtualizada.getNome());

            Turma turmaAtualizadaBD = turmaRepository.save(turma);
            return ResponseEntity.ok(turmaAtualizadaBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}