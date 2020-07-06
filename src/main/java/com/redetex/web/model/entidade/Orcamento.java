package com.redetex.web.model.entidade;

import com.redetex.web.model.enums.SituacaoEnum;
import com.redetex.web.model.enums.TipoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_ORCAMENTOS")
@NoArgsConstructor
public class Orcamento {

    @Column(name = "IDORCAMENTO")
    int idOrcamento;

    @Column(name = "TPORCAMENTO")
    TipoEnum tipoOrcamento;

    @Column(name = "STORCAMENTO")
    SituacaoEnum situacaoOrcamento;

    @Column(name = "CLIENTEORCAMENTO")
    Cliente clienteOrcamento;

    @Column(name = "ENDERECOORCAMENTO")
    Endereco enderecoOrcamento;

    @Column(name = "MEDIDASORCAMENTO")
    Medida medidasOrcamento;

    @Column(name = "VALORORCAMENTO")
    Float valorOrcamento;

    @Column(name = "OBSORCAMENTO")
    String observacaoOrcamento;

    public Float calcularValorOrcamento(Medida medidasOrcamento, Float valorMetroQuadrado) {
        return (medidasOrcamento.getAltura() * medidasOrcamento.getLargura()) * valorMetroQuadrado;
    }

}
