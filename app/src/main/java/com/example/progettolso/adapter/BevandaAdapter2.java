package com.example.progettolso.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.progettolso.GUI.Registrazione2;
import com.example.progettolso.R;
import com.example.progettolso.model.Bevanda;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class BevandaAdapter2 extends BaseAdapter {
    ArrayList<Bevanda> bevande;
    Context context;

    public BevandaAdapter2(Context context,ArrayList<Bevanda> bevande) {
        this.bevande = bevande;
        this.context = context;
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    @Override
    public int getCount() {
        return bevande.size();
    }

    @Override
    public Object getItem(int i) {
        return bevande.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter2, null);
        }
        Bevanda ai = (Bevanda) getItem(position);
        new DownloadImageTask((ImageView) convertView.findViewById(R.id.fotoDrink)).execute(ai.getImageUrl());
        TextView txt = convertView.findViewById(R.id.nomeDrink);
        txt.setText(ai.getNome());
        txt = convertView.findViewById(R.id.prezzoDrink);
        txt.setText("prezzo: " + ai.getPrezzo()+"EUR");
        txt = convertView.findViewById(R.id.numBevande);
        txt.setText("qnt: " + Integer.toString(ai.getNum()));

        ImageButton button=(ImageButton) convertView.findViewById(R.id.minus);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bevanda b=bevande.get(position);
                int num=ai.getNum();
                num--;
                if(num<=0){
                    bevande.remove(position);
                }else{
                    ai.setNum(num);
                }
                notifyDataSetChanged();
            }
        });

        ImageButton button1=(ImageButton) convertView.findViewById(R.id.plus);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bevanda b=bevande.get(position);
                int num=ai.getNum();
                num++;
                ai.setNum(num);
                notifyDataSetChanged();
            }
        });

        return convertView;


    }

}
