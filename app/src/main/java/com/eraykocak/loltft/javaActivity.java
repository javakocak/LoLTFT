package com.eraykocak.loltft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public class javaActivity extends AppCompatActivity {

    private static final String BASEPATH = "http://www.example.com";

    private interface API {
        @GET("/thing")
        void getMyThing(@QueryMap Map<String, String> params,  Callback<String> callback);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);


    }
}