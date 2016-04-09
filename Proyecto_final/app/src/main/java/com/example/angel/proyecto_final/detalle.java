package com.example.angel.proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class detalle extends AppCompatActivity {

    public void onClick2(View v)
    {
        Intent intent =new Intent(this,MainActivity.class);
        startActivityForResult(intent, 0);
        //finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* //insertar titulo
        String Titulo = this.getIntent().getStringExtra("Titulo");
        TextView tv= (TextView) findViewById(R.id.Titulo_detalle);
        tv.setText(Titulo);

        //insertar subtitulo
        String SubTitulo = this.getIntent().getStringExtra("SubTitulo");
        TextView tv2= (TextView) findViewById(R.id.SubTitulo_detalle);
        tv2.setText(SubTitulo);

        //insertar imagen
        String image = this.getIntent().getStringExtra("Imagen");
        NetworkImageView niv = (NetworkImageView) findViewById(R.id.imagen_detalle);
        niv.setImageUrl(image, VolleySingleton.getInstance().getM_imageLoader());

        //--------------------------------Datos de detalle------------------------------
        //insertar Status
        String status = this.getIntent().getStringExtra("Status");
        TextView tv3= (TextView) findViewById(R.id.status);
        tv3.setText(status);

        //insertar Pais
        String pais = this.getIntent().getStringExtra("Pais");
        TextView tv4= (TextView) findViewById(R.id.pais);
        tv4.setText(pais);

        //insertar Pueblo
        String pueblo = this.getIntent().getStringExtra("Pueblo");
        TextView tv5= (TextView) findViewById(R.id.pueblo);
        tv5.setText(pueblo);

        //insertar Actividad
        String actividad = this.getIntent().getStringExtra("Actividad");
        TextView tv6= (TextView) findViewById(R.id.actividad);
        tv6.setText(actividad);

        //insertar Sector
        String sector = this.getIntent().getStringExtra("Sector");
        TextView tv7= (TextView) findViewById(R.id.sector);
        tv7.setText(sector);*/

    }
}
