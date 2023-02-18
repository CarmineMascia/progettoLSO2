package com.example.progettolso.model;

public class Bevanda {
    private String nome;
    private String prezzo;
    private String ImageUrl;
    private int num;

    public Bevanda(String nome, String prezzo, String imageUrl,int numero) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.ImageUrl = imageUrl;
        this.num=numero;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }
}
