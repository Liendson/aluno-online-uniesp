package com.redetex.web.model.entidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Orcamento {

    int idOrcamento;
    int tipoOrcamento;
    int situacaoServico;
    Cliente clienteOrcamento;
    Endereco enderecoOrcamento;
    Medida medidasOrcamento;
    Float valorOrcamento;
    String observacaoOrcamento;

    public Float calcularValorOrcamento(Medida medidasOrcamento, Float valorMetroQuadrado) {
        return (medidasOrcamento.getAltura() * medidasOrcamento.getLargura()) * valorMetroQuadrado;
    }

}
