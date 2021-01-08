package com.example.zpo_lista11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Derivative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivative);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.tvMessage1);

        Polynomial polynomial = new Polynomial(message,null);
        String url = "https://newton.now.sh/api/v2/derive/"+polynomial.wyrazenieAPI();

        RequestQueue queue = Volley.newRequestQueue(this);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response ->
        {
            Polynomial test = gson.fromJson(response, Polynomial.class);
            textView.setText("Derivative of polynomial: " +test.toString());
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work");
            }
        });
        queue.add(stringRequest);

    }
}