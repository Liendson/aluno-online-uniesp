package com.redetex.web.model.entidade;

import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_ORCAMENTOS")
@NoArgsConstructor
public class Orcamento {

    @Id
    @Column(name = "IDORCAMENTO")
    int idOrcamento;

    @Column(name = "TPORCAMENTO")
    TipoEnum tipoOrcamento;

    @Column(name = "STORCAMENTO")
    SituacaoEnum situacaoOrcamento;

    @OneToOne
    @JoinColumn(name = "CLIENTEORCAMENTO", nullable = false)
    Cliente clienteOrcamento;

    @OneToOne
    @JoinColumn(name = "ENDERECOORCAMENTO", nullable = false)
    Endereco enderecoOrcamento;

    @OneToOne
    @JoinColumn(name = "MEDIDASORCAMENTO", nullable = false)
    Medida medidasOrcamento;

    @Column(name = "VALORORCAMENTO")
    Float valorOrcamento;

    @Column(name = "OBSORCAMENTO")
    String observacaoOrcamento;

}
