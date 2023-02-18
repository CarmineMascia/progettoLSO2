package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.progettolso.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progettolso.R;

public class Home extends AppCompatActivity {

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user= getIntent().getParcelableExtra("userTag");
        Toolbar toolbar=findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Button button=(Button) findViewById(R.id.button_drink);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Listino.class);
                intent.putExtra("userTag",user);
                intent.putExtra("flag",0);
                startActivity(intent);
            }
        });
        button=(Button) findViewById(R.id.button_frullati);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Listino.class);
                intent.putExtra("userTag",user);
                intent.putExtra("flag",1);
                startActivity(intent);
            }
        });
        button=(Button) findViewById(R.id.button_consigliati);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),Listino.class);
                intent.putExtra("userTag",user);
                intent.putExtra("flag",2);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            case R.id.carrello:
                Intent intent3=new Intent(this, Carrello.class);
                intent3.putExtra("userTag",user);
                startActivity(intent3);
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

            default:
                return true;
        }
    }
}