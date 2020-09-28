package com.ovalle.actividadreciclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class registerActivity extends AppCompatActivity {

    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterForXml = ArrayAdapter.createFromResource(registerActivity.this, R.array.marcas_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterForXml);

    }
}