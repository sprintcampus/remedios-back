package com.example.ApiRemedios.Remedio.Entities;

import com.example.ApiRemedios.Remedio.DTO.DadosAtualizarRemedio;
import com.example.ApiRemedios.Remedio.DTO.DadosCadastroRemedio;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Remedio")
@Table(name = "Remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private boolean ativo;

    public Remedio(DadosCadastroRemedio dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.via =  dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInfomacao(@Valid DadosAtualizarRemedio dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.Laboratorio() != null){
            this.laboratorio = dados.Laboratorio();
        }
        if(dados.via() != null){
            this.via =  dados.via();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}
