package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.progettolso.Controller.Controller;
import com.example.progettolso.R;
import com.example.progettolso.model.User;

public class Acquisto extends AppCompatActivity {

    User user;
    String tot;
    Controller c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acquisto);
        Intent i=getIntent();
        user=(User) i.getParcelableExtra("userTag");
        tot=i.getStringExtra("totale");

        TextView textView=(TextView) findViewById(R.id.totale);
        textView.setText(tot);

        Button button=(Button)findViewById(R.id.buy_button);
        c=new Controller();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!c.EliminaDBCarrello(user))
                    Toast.makeText(view.getContext(),"ERRORE AGGIORNAMENTO CARRELLO", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });
        button=(Button)findViewById(R.id.cancel_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}