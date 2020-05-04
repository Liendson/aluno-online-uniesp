package com.redetex.web.model.entidade;

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

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getTipoOrcamento() {
        return tipoOrcamento;
    }

    public void setTipoOrcamento(int tipoOrcamento) {
        this.tipoOrcamento = tipoOrcamento;
    }

    public int getSituacaoServico() {
        return situacaoServico;
    }

    public void setSituacaoServico(int situacaoServico) {
        this.situacaoServico = situacaoServico;
    }

    public Cliente getClienteOrcamento() {
        return clienteOrcamento;
    }

    public void setClienteOrcamento(Cliente clienteOrcamento) {
        this.clienteOrcamento = clienteOrcamento;
    }

    public Endereco getEnderecoOrcamento() {
        return enderecoOrcamento;
    }

    public void setEnderecoOrcamento(Endereco enderecoOrcamento) {
        this.enderecoOrcamento = enderecoOrcamento;
    }

    public Medida getMedidasOrcamento() {
        return medidasOrcamento;
    }

    public void setMedidasOrcamento(Medida medidasOrcamento) {
        this.medidasOrcamento = medidasOrcamento;
    }

    public Float getValorOrcamento() {
        return valorOrcamento;
    }

    public void setValorOrcamento(Float valorOrcamento) {
        this.valorOrcamento = valorOrcamento;
    }

    public String getObservacaoOrcamento() {
        return observacaoOrcamento;
    }

    public void setObservacaoOrcamento(String observacaoOrcamento) {
        this.observacaoOrcamento = observacaoOrcamento;
    }
}
