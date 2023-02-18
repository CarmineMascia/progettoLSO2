package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.progettolso.Controller.Controller;
import com.example.progettolso.R;
import com.example.progettolso.adapter.BevandaAdapter;
import com.example.progettolso.adapter.BevandaAdapter2;
import com.example.progettolso.model.Bevanda;
import com.example.progettolso.model.User;

import java.util.ArrayList;

public class Listino extends AppCompatActivity {
    ArrayList<Bevanda> bevande;
    User user;
    int flag;
    ListView listView;
    BevandaAdapter adapter;
    Controller c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listino);
        user = getIntent().getParcelableExtra("userTag");
        c = new Controller();
        bevande = new ArrayList<Bevanda>();
        flag=getIntent().getIntExtra("flag",0);
        if(flag==0) {
            if (c.TakeDBdrink(bevande)) {
                adapter = new BevandaAdapter(this, bevande);
                listView = findViewById(R.id.list_view);
                listView.setPadding(30, 10, 30, 10);
                listView.setAdapter(adapter);
            } else {
                Toast.makeText(this, "RIPROVA", Toast.LENGTH_LONG).show();
            }
        }else if(flag==1){
            if (c.TakeDBfrullati(bevande)) {
                adapter = new BevandaAdapter(this, bevande);
                listView = findViewById(R.id.list_view);
                listView.setPadding(30, 10, 30, 10);
                listView.setAdapter(adapter);
            } else {
                Toast.makeText(this, "RIPROVA", Toast.LENGTH_LONG).show();
            }
        }else{
            if (c.TakeDBconsigliati(bevande)) {
                adapter = new BevandaAdapter(this, bevande);
                listView = findViewById(R.id.list_view);
                listView.setPadding(30, 10, 30, 10);
                listView.setAdapter(adapter);
            } else {
                Toast.makeText(this, "RIPROVA", Toast.LENGTH_LONG).show();
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Button button=(Button) findViewById(R.id.buy_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Bevanda> carrello=new ArrayList<>();
                for(int i=0;i<adapter.getCount();i++){
                    Bevanda bevanda = (Bevanda) adapter.getItem(i);
                    if(bevanda.getNum()>0){
                        carrello.add(bevanda);
                    }
                }
                if((carrello.size()>0) && (c.AggiungiAlCarrello(user,carrello))){
                    Toast.makeText(view.getContext(), "AGGIUNTO AL CARRELLO", Toast.LENGTH_LONG).show();
                }else if(carrello.size()==0){
                    Toast.makeText(view.getContext(), "PREMI + SULLA BEVANDA\nCHE VUOI AGGIUNGERE", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(view.getContext(), "RIPROVA", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.account:
                Intent i=new Intent(this,Account.class);
                i.putExtra("userTag",user);
                startActivity(i);
                return true;
            case R.id.logout:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.storico:
                Intent intent1=new Intent(this,Storico.class);
                intent1.putExtra("userTag",user);
                startActivity(intent1);
                return true;
            case R.id.home:
                onBackPressed();
                return true;
            default:
                return true;
        }
    }
}