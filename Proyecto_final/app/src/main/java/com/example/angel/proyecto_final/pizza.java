package com.example.angel.proyecto_final;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pizza extends AppCompatActivity {

    private static Context m_context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        m_context = this;

          String url =  "https://dl.dropboxusercontent.com/s/w3nrycu27ztk4a1/API_restaurantes.json?dl=0";
       // String url =  "https://dl.dropboxusercontent.com/s/8edto65wp1suqoo/archivo.json?dl=0";
        final Context context = this;

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Logger.getAnonymousLogger().log(Level.INFO, response.toString());
                        try {
                            JSONArray loans = response.getJSONArray("pizzas");
                            ArrayList<JSONObject> dataSource = new ArrayList<JSONObject>();
                            for (int i = 0; i < loans.length(); i++)
                            {   dataSource.add(loans.getJSONObject(i)); }

                            CeldaComplejaAdapter adapter = new CeldaComplejaAdapter(context, 0, dataSource);
                            ((ListView) findViewById(R.id.listView)).setAdapter(adapter);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Logger.getAnonymousLogger().log(Level.SEVERE, "Fallo");
                    }
                }
        );
        VolleySingleton.getInstance().getM_requestQueue().add(jor);

    }

    public static Context getContext() {       return m_context;        }

}
