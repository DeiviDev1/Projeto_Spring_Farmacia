package com.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table( name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "o atributo  nome é obrigatórioe e nao poder ser vazio!")
    @Size(min = 3, max = 50, message =  "O atributo nome deve conter no mínimo 3 e no máximo 50 caracteres")
    private String nome;


    @NotNull(message = "o atributo descrição pode ser vazio!")
    @Size(min = 8, max = 100, message =  "O atributo descrição deve conter no mínimo 8 e no máximo 100 caracteres")
    private String descricao;

    @NotNull( message = " Atributo preço é obrigatorio")
    private BigDecimal preco;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;



    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }



}