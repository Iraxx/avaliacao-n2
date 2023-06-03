package br.senac.go.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cliente")
public class Cliente  extends BaseModel  {
    private String nome;
    private String endereco;
}
