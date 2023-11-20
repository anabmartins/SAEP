package com.example.integracao.controller;

import com.example.integracao.model.Atividade;
import com.example.integracao.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/atividades")
public class AtividadeController {
    @Autowired
    private AtividadeRepository atividadeRepository;

    // GET
    @GetMapping
    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    // POST
    @PostMapping
    public Atividade criarAtividade(@RequestBody Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    // DELETE
    @DeleteMapping("/{id_turma}")
    public ResponseEntity<String> deletarAtividade(@PathVariable Long id_atividade) {
        if (atividadeRepository.existsById(id_atividade)) {
            atividadeRepository.deleteById(id_atividade);
            return ResponseEntity.ok("atv deletada com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}