package com.youx.teste_nailton_boccanera.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente", indexes = @Index(name = "idx_unique_cnpj", columnList = "cnpj", unique = true))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 120, nullable = false)
    private String nome;

    @Column(name = "cnpj", unique = true, length = 30, nullable = false)
    private String cnpj;

    @Column(name = "email", length = 70, nullable = false)
    private String email;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @NotBlank
    @Column(name = "localizacao", length = 100, nullable = false)
    private String localizacao;

}