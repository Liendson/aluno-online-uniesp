package com.redetex.web.model.entidade;

import com.redetex.web.model.enums.SituacaoClienteEnum;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_CLIENTES")
@NoArgsConstructor
public class Cliente {

    @Id
    @Column(name = "IDCLIENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCliente;

    @Column(name = "NOMECLIENTE")
    String nomeCliente;

    @Column(name = "TELCLIENTE")
    String telefoneCliente;

    @Column(name = "SITCLIENTE")
    SituacaoClienteEnum situacaoCliente;

    @Builder
    public Cliente(
            Long idCliente,
            String nomeCliente,
            String telefoneCliente,
            SituacaoClienteEnum situacaoCliente
    ) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.situacaoCliente = situacaoCliente;
    }

}
