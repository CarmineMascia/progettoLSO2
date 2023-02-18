package com.example.progettolso.GUI;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.progettolso.Controller.Controller;
import com.example.progettolso.R;
import com.example.progettolso.model.User;

public class Account extends AppCompatActivity {

    Controller c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        c=new Controller();
        User user= getIntent().getParcelableExtra("userTag");
        c.getDBinfo(user);
        ((TextView)findViewById(R.id.nome)).setText(user.getNome());
        ((TextView)findViewById(R.id.cognome)).setText(user.getCognome());
        ((TextView)findViewById(R.id.eta)).setText(user.getEta());
        ((TextView)findViewById(R.id.email)).setText(user.getUserMail());

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