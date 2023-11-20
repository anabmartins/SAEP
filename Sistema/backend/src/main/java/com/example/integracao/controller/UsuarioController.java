package com.example.integracao.controller;

import com.example.integracao.model.Usuario;
import com.example.integracao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // GET
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // POST
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // DELETE
    @DeleteMapping("/{id_usuario}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id_usuario) {
        if (usuarioRepository.existsById(id_usuario)) {
            usuarioRepository.deleteById(id_usuario);
            return ResponseEntity.ok("Usuario deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT
    @PutMapping("/{id_usuario}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id_usuario,
            @RequestBody Usuario usuarioAtualizado) {
        if (usuarioRepository.existsById(id_usuario)) {
            Usuario usuario = usuarioRepository.findById(id_usuario).get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            usuario.setTurma(usuarioAtualizado.getTurma());

            Usuario usuarioAtualizadoBD = usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuarioAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}