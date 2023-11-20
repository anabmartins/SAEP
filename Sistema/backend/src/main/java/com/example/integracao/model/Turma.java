package com.example.integracao.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Turma{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_turma;
 private String nome;

 @ManyToOne
 private Atividade atividade;
}
