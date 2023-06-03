package br.senac.go.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "pagamento")
public class Pagamento  extends BaseModel {
    private double valor;
    private LocalDateTime date;


}
