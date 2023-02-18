package com.example.progettolso.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.progettolso.Controller.Controller;
import com.example.progettolso.R;
import com.example.progettolso.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Storico extends AppCompatActivity {

    Controller c;
    User user;
    ArrayList<String> sto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storico);
        c=new Controller();
        user=getIntent().getParcelableExtra("userTag");
        Toolbar toolbar=findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ListView listView=(ListView) findViewById(R.id.list_view);
        sto=new ArrayList<String>();
        if(c.takeDBstorico(sto,user)==true){
            ArrayAdapter<String> adapter=new ArrayAdapter<>(this, R.layout.mytextviewsize,sto);
            listView.setAdapter(adapter);
        }else{
            Toast.makeText(this,"RIPROVA",Toast.LENGTH_LONG).show();
        }



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
            case R.id.logout:
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                return true;
            case R.id.storico:
                return true;
            case R.id.home:
                onBackPressed();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}