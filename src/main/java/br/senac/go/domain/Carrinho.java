package br.senac.go.domain;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@Table(name = "carrinho")
public class Carrinho extends BaseModel {
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produto = new ArrayList<>();
}
