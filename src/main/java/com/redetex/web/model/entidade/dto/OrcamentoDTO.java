package com.redetex.web.model.entidade.dto;

import com.redetex.web.model.entidade.Cliente;
import com.redetex.web.model.entidade.Endereco;
import com.redetex.web.model.entidade.Medida;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrcamentoDTO {

    int idOrcamento;
    int tipoOrcamento;
    int situacaoServico;
    Cliente clienteOrcamento;
    Endereco enderecoOrcamento;
    Medida medidasOrcamento;
    Float valorOrcamento;
    String observacaoOrcamento;

}
