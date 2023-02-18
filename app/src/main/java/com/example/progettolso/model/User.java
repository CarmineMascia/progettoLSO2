package com.example.progettolso.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String UserMail;
    private String  Password;
    private String Nome;
    private String Cognome;
    private String Eta;

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String userMail) {
        UserMail = userMail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getEta() {
        return Eta;
    }

    public void setEta(String eta) {
        Eta = eta;
    }

    public User(String mail, String pass){
        UserMail=mail;
        Password=pass;
    }


    //parcel part
    public User(Parcel in){
        String[] data= new String[2];

        in.readStringArray(data);
        this.UserMail= data[0];
        this.Password= data[1];
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeStringArray(new String[]{this.UserMail,this.Password});
    }

    public static final Parcelable.Creator<User> CREATOR= new Parcelable.Creator<User>() {

        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

}
