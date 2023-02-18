package com.example.progettolso.Controller;


import com.example.progettolso.GUI.Storico;
import com.example.progettolso.model.Bevanda;
import com.example.progettolso.model.User;

import java.util.ArrayList;

public class Controller {

    //deve ritornare true se è vero, controlla se l'utente esiste
    public boolean CheckDBuser(String mail,String pass){
        //fai con i thread
        return true;

    }
    //deve ritornare true se fa tutto con successo,inserisce l'utente nel DB
    public boolean CreateDBuser(String email,String password,String nome, String cognome, String eta){
        //fare con i thread
        return true;
    }

    //ritorna true se fa tutto con successo, deve prendere i dati dell'utente dal DB
    public boolean getDBinfo(User user) {
        //fare con i thread
        user.setNome("Carmine");
        user.setCognome("Mascia");
        user.setEta("20");
        return true;
    }

    //ritorna true se fa tutto con successo, deve prendere gli storici dell'utente dal DB
    //così facendo ci crei un ArrayList<Conto> successivamente converti tutto ciò in un ArrayList<String>
    //che sarebbe sto(l'argomento in input), con la seguente formattazione (te la faccio considerando Conto)
    // Conto.id_conto + "\t" + Conto.prezzo + "EUR" + "\t" + Conto.data
    //+ è il segno di concatenazione tra stringhe
    //consiglietto implementa toString
    public boolean takeDBstorico(ArrayList<String> sto,User user) {
        sto.add("000000    50EUR   15/02/2023");
        sto.add("000001    40EUR   12/02/2023");
        sto.add("000003    30EUR   10/02/2023");
        sto.add("000004    20EUR   10/02/2023");
        sto.add("000005    10EUR   10/02/2023");
        sto.add("000006    70EUR   10/02/2023");
        sto.add("000007    80EUR   10/02/2023");
        sto.add("000008    98EUR   10/02/2023");
        return true;
    }

    //prende dal DB il carrello dell'user
    // ritorno true se tutt'appost.
    // Metti i dati in bevande
    public boolean TakeDBCarrello(User user, ArrayList<Bevanda> bevande) {
        //fai con i thread
        Bevanda a=new Bevanda("Pina Colada","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",2);
        Bevanda b=new Bevanda("Negroni","8","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",2);
        Bevanda c=new Bevanda("Spritz","5","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",1);
        Bevanda d=new Bevanda("Old fashioned","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",5);
        Bevanda e=new Bevanda("White Russian","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",2);
        Bevanda f=new Bevanda("Black Russian","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",1);
        Bevanda g=new Bevanda("Margarita","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",1);
        bevande.add(a);
        bevande.add(b);
        bevande.add(c);
        bevande.add(d);
        bevande.add(e);
        bevande.add(f);
        bevande.add(g);
        return true;
    }
    //devi eliminare dal carrello
    //ritorna true se tutto appost
    public boolean EliminaDBCarrello(User user) {
        //fai con i thread
        return true;
    }
    //prendi i frullati dal DB, SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO ,
    // torna true se tutt appost
    public boolean TakeDBfrullati(ArrayList<Bevanda> bevande) {
        //fai con i thread
        Bevanda a=new Bevanda("Fragola","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        //SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO
        Bevanda b=new Bevanda("Limone","8","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda c=new Bevanda("Ananas","5","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        //SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO
        Bevanda d=new Bevanda("Maradona","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda e=new Bevanda("Diego","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda f=new Bevanda("Pesca","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda g=new Bevanda("Cocco","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        bevande.add(a);
        //SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO
        bevande.add(b);
        bevande.add(c);
        bevande.add(d);
        bevande.add(e);
        bevande.add(f);
        bevande.add(g);
        return true;
    }

    //prendi i drink dal DB, SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO ,
    // torna true se tutt appost
    public boolean TakeDBdrink(ArrayList<Bevanda> bevande) {
        Bevanda a=new Bevanda("Pina Colada","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        //SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO
        Bevanda b=new Bevanda("Negroni","8","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda c=new Bevanda("Spritz","5","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda d=new Bevanda("Old fashioned","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda e=new Bevanda("White Russian","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        //SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO
        Bevanda f=new Bevanda("Black Russian","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda g=new Bevanda("Margarita","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        bevande.add(a);
        bevande.add(b);
        bevande.add(c);
        bevande.add(d);
        bevande.add(e);
        bevande.add(f);
        bevande.add(g);
        return true;
    }

    //prendi i drink dal DB, SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO ,
    // torna true se tutt appost
    public boolean TakeDBconsigliati(ArrayList<Bevanda> bevande) {
        Bevanda a=new Bevanda("Gelato","10","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        Bevanda b=new Bevanda("Palla","8","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        //SETTA 0 A NUMERO BEVANDE PERCHè SERVE PER TENERE IL CONTEGGIO
        Bevanda c=new Bevanda("Puzza","5","https://media.geeksforgeeks.org/wp-content/cdn-uploads/gfg_200x200-min.png",0);
        bevande.add(a);
        bevande.add(b);
        bevande.add(c);
        return true;
    }

    //AGGIUNGI BEVANDE AL CARRELLO DI USER RETURN true SE TUTTO APPOST
    public boolean AggiungiAlCarrello(User user, ArrayList<Bevanda> bevande) {
        return true;
    }
}
