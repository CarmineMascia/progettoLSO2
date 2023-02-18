package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.progettolso.R;

public class Registrazione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        Button b = (Button) findViewById(R.id.butt_reg2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.nome);
                String res = nome.getText().toString();
                EditText cognome = (EditText) findViewById(R.id.cognome);
                String res1 = cognome.getText().toString();
                EditText eta = (EditText) findViewById(R.id.eta);
                String res2 = eta.getText().toString();

                Intent i = new Intent(view.getContext(), Registrazione2.class);
                i.putExtra("nome", res);
                i.putExtra("cognome", res1);
                i.putExtra("eta", res2);

                startActivity(i);
            }
        });


        // toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar2);
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