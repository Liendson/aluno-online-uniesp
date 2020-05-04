package com.redetex.web.model.entidade;

public class Endereco {

    String nomeRua;
    String bairro;
    String cepRua;
    String nomeEdificio;
    int apartamentoEdificio;
    int numeroEdificio;

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCepRua() {
        return cepRua;
    }

    public void setCepRua(String cepRua) {
        this.cepRua = cepRua;
    }

    public String getNomeEdificio() {
        return nomeEdificio;
    }

    public void setNomeEdificio(String nomeEdificio) {
        this.nomeEdificio = nomeEdificio;
    }

    public int getApartamentoEdificio() {
        return apartamentoEdificio;
    }

    public void setApartamentoEdificio(int apartamentoEdificio) {
        this.apartamentoEdificio = apartamentoEdificio;
    }

    public int getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(int numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
    }
}
