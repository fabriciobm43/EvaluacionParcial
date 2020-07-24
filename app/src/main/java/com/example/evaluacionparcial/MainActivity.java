package com.example.evaluacionparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.evaluacionparcial.Adaptadores.Adaptador;
import com.example.evaluacionparcial.Adaptadores.Banderas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String url = "https://restcountries.eu/rest/v2/all";
    RecyclerView recyclerView;
    Adaptador adaptor;
    ArrayList<Banderas> banderas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_banderas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaptor = new Adaptador();
        recyclerView.setAdapter(adaptor);
        banderas = new ArrayList<>();
        getData();

        /*recyclerView = (RecyclerView) findViewById(R.id.recycler_banderas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://restcountries.eu/rest/v2/all",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");*/


    }
    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando accesorios...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Banderas bandera = new Banderas();
                        bandera.setName(jsonObject.getString("name"));
                        bandera.setFlag(jsonObject.getString("flag"));
                        banderas.add(bandera);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adaptor.setData(banderas);
                adaptor.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    /*@Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Banderas> lstBanderas = new ArrayList<Banderas> ();

        try {

            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaBanderas=  JSONlista.getJSONArray("");

            lstBanderas = Banderas.JsonObjectsBuild(JSONlistaBanderas);

            Adapter adapatorBanderas = new Adapter(this, lstBanderas);

            recyclerView.setAdapter(adapatorBanderas);



        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }


    }*/
}