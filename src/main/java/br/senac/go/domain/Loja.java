package br.senac.go.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "loja")
public class Loja extends BaseModel {

    private String nome;
    private String endereco;

}
