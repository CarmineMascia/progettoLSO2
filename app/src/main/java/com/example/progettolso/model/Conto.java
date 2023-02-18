package com.example.progettolso.model;

import java.util.Date;

public class Conto {
    public String id_conto;
    public String prezzo;
    public Date data;

    public String getId_conto() {
        return id_conto;
    }

    public void setId_conto(String id_conto) {
        this.id_conto = id_conto;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
