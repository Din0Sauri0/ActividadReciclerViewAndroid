package com.ovalle.actividadreciclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class registerActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText txtNombreP, txtDescripcionP, txtCantidad;
    private CheckBox cbxConfirmar;
    private Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //spinner
        spinner = findViewById(R.id.spinner);
        //EditText
        txtNombreP = findViewById(R.id.txtNombreP);
        txtDescripcionP = findViewById(R.id.txtDescripcionP);
        txtCantidad = findViewById(R.id.txtCantidad);
        //ComboBox
        cbxConfirmar = findViewById(R.id.cbxConfimar);
        //Button
        btnRegistrar = findViewById(R.id.btnRegistrar);

        //Adaptador Spinner
        ArrayAdapter<CharSequence> adapterForXml = ArrayAdapter.createFromResource(registerActivity.this, R.array.marcas_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterForXml);

        //ArrayList
        ArrayList<ArrayList<String>> producto = new ArrayList<ArrayList<String>>();

    }
}