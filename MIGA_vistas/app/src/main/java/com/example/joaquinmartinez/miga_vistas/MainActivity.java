package com.example.joaquinmartinez.miga_vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment_Pruebas fn = new Fragment_Pruebas();
        getSupportFragmentManager().beginTransaction().add(R.id.fm,fn).commit();

    }
}
