package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;
import com.example.progettolso.Controller.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progettolso.Controller.Controller;
import com.example.progettolso.R;

public class Registrazione2 extends AppCompatActivity {

    Controller c=new Controller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione2);
        Button button=(Button) findViewById(R.id.butt_reg3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=getIntent();
                String nome=i.getStringExtra("nome");
                String cognome=i.getStringExtra("cognome");
                String eta=i.getStringExtra("eta");
                EditText email=findViewById(R.id.mail);
                String res=email.getText().toString();
                EditText pass=findViewById(R.id.pass);
                String res1=pass.getText().toString();
                if(c.CreateDBuser(res,res1,nome,cognome,eta)==true){
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }else{
                    Toast.makeText(view.getContext(), "REGISTRAIONE FALLITA",Toast.LENGTH_LONG).show();
                }

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