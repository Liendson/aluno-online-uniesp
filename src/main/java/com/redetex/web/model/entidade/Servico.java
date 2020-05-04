package com.redetex.web.model.entidade;

import java.util.Date;

public class Servico {

    int idServico;
    int situacaoServico;
    Orcamento orcamentoServico;
    Date dataInstalacaoServico;
    String observacaoServico;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public int getSituacaoServico() {
        return situacaoServico;
    }

    public void setSituacaoServico(int situacaoServico) {
        this.situacaoServico = situacaoServico;
    }

    public Orcamento getOrcamentoServico() {
        return orcamentoServico;
    }

    public void setOrcamentoServico(Orcamento orcamentoServico) {
        this.orcamentoServico = orcamentoServico;
    }

    public Date getDataInstalacaoServico() {
        return dataInstalacaoServico;
    }

    public void setDataInstalacaoServico(Date dataInstalacaoServico) {
        this.dataInstalacaoServico = dataInstalacaoServico;
    }

    public String getObservacaoServico() {
        return observacaoServico;
    }

    public void setObservacaoServico(String observacaoServico) {
        this.observacaoServico = observacaoServico;
    }
}
