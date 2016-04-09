package com.example.angel.proyecto_final;
/**
 * Created by Angel on 2016/03/12.
 */
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class CeldaComplejaAdapter extends ArrayAdapter<JSONObject> {

    public CeldaComplejaAdapter(Context context, int resource, List<JSONObject> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View celda = convertView;
        if (celda == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            celda = layoutInflater.inflate(R.layout.celdacompleja, null);
        }

        final TextView titulo = (TextView) celda.findViewById(R.id.Titulo);
        final TextView subTitulo = (TextView) celda.findViewById(R.id.SubTitulo);
        NetworkImageView niv = (NetworkImageView) celda.findViewById(R.id.imagen);


        final JSONObject elemento = this.getItem(position);

        try {
            titulo.setText(elemento.getString("nombre"));
            subTitulo.setText(elemento.getString("telefono"));

         /*   //--------Datos de detalle---------------------
            final String status = elemento.getString("status");
            final String pais = (String) elemento.getJSONObject("location").get("country");
            final String pueblo = (String) elemento.getJSONObject("location").get("town");
            final String actividad = elemento.getString("activity");
            final String sector = elemento.getString("sector");
            //-----------------------------------------------*/


            //int img = elemento.getJSONObject("image").getInt("id");
           // final String image = "https://www.kiva.org/img/500/" + img + ".jpg";
            final String image = "http://previews.123rf.com/images/memoangeles/memoangeles1410/memoangeles141000032/33113594-Salami-rebanada-de-pizza-clip-de-arte-de-la-ilustraci-n-con-gradientes-simples-Todo-en-una-sola-capa-Foto-de-archivo.jpg";

           niv.setImageUrl(image, VolleySingleton.getInstance().getM_imageLoader());

            niv.setOnClickListener(new OnClickListener() {

                 @Override
                 public void onClick(View v) {


                     Intent intent =new Intent(getContext(), MainActivity.class);
                    // intent.putExtra("Titulo",titulo.getText());
                   //  intent.putExtra("SubTitulo",subTitulo.getText());
                    // intent.putExtra("Imagen",image);

                     //--------Datos de detalle---------------------
                     //intent.putExtra("Status",status);
                    // intent.putExtra("Pais",pais);
                    // intent.putExtra("Pueblo",pueblo);
                    // intent.putExtra("Actividad",actividad);
                    // intent.putExtra("Sector",sector);

                     //-----------------------------------------------

                     getContext().startActivity(intent);
                 }
             });

        } catch (JSONException e) {         e.printStackTrace();        }

        return celda;

    }

}
