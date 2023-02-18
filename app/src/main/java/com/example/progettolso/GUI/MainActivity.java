package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progettolso.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //login
        Button login = (Button) findViewById(R.id.butt_log);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent( view.getContext(), Login.class);
                startActivity(i);
            }
        });

        //registrazione
        Button registrazione = (Button) findViewById(R.id.butt_reg);
        registrazione.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent( view.getContext(), Registrazione.class);
                startActivity(i);
            }
        });

    }


}