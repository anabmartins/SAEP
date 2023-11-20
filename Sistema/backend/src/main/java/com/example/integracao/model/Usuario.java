package com.example.integracao.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Usuario{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_professor;
 private String nome;
 private String senha;
 private String email;

 @ManyToOne
 private Turma turma;
}
