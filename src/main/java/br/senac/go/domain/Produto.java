package br.senac.go.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "produto")
public class Produto extends BaseModel{

    private String nome;
    private double preco;
}
