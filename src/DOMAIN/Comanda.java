/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOMAIN;

import java.sql.Date;

/**
 *
 * @author vidal
 */
public class Comanda {
    private int idcomanda;
    private int mesa;
    private boolean status;
    private float valortotal;
    private Date dtabertura;
    private Date dtfechamento;
    private int idfuncionario;

    public int getIdcomanda() {
        return idcomanda;
    }

    public void setIdcomanda(int idcomanda) {
        this.idcomanda = idcomanda;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public Date getDtabertura() {
        return dtabertura;
    }

    public void setDtabertura(Date dtabertura) {
        this.dtabertura = dtabertura;
    }

    public Date getDtfechamento() {
        return dtfechamento;
    }

    public void setDtfechamento(Date dtfechamento) {
        this.dtfechamento = dtfechamento;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }
}
