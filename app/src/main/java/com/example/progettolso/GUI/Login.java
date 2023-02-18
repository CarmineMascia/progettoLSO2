package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progettolso.R;
import com.example.progettolso.Controller.Controller;
import com.example.progettolso.model.User;

public class Login extends AppCompatActivity {

    Controller c=new Controller();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.butt_log2);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText em=findViewById(R.id.email);
                String res=em.getText().toString();
                EditText pa=findViewById(R.id.pass);
                String res1=pa.getText().toString();
                if(c.CheckDBuser(res,res1)==true){//scriverla in controller e USARE I THREAD
                    Intent i = new Intent( view.getContext(), Home.class);
                    User obj= new User(res,res1);
                    i.putExtra("userTag",obj);
                    startActivity(i);
                }else{
                    Toast.makeText(view.getContext(),"NON ESISTE L'UTENTE",Toast.LENGTH_LONG).show();
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