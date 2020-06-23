package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_CLIENTES")
@NoArgsConstructor
public class Cliente {

    @Column(name = "IDCLIENTE")
    int idCliente;

    @Column(name = "NOMECLIENTE")
    String nomeCliente;

    @Column(name = "TELCLIENTE")
    String telefoneCliente;

}
