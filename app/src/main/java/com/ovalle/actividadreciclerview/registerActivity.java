package com.ovalle.actividadreciclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class registerActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText txtNombreP, txtDescripcionP, txtCantidad;
    private CheckBox cbxConfirmar;
    private Button btnRegistrar;
    private RatingBar ratingBar;
    static ArrayList<producto> productList = new ArrayList<>();


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
        //ratingBar
        ratingBar = findViewById(R.id.ratingBar);
        //Adaptador Spinner
        ArrayAdapter<CharSequence> adapterForXml = ArrayAdapter.createFromResource(registerActivity.this, R.array.marcas_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterForXml);
        //desabilitar widget
        txtDescripcionP.setEnabled(false);
        txtCantidad.setEnabled(false);
        spinner.setEnabled(false);
        cbxConfirmar.setEnabled(false);
        ratingBar.setEnabled(false);
        btnRegistrar.setEnabled(false);

        //Escuchadores
        txtNombreP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(txtNombreP.getText().toString().length() >=3){
                    txtDescripcionP.setEnabled(true);

                }else if(txtNombreP.getText().toString().length() <3){
                    txtDescripcionP.setEnabled(false);
                    txtNombreP.setError("3 caracteres como minimo");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtDescripcionP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtDescripcionP.getText().toString().length() >= 3){
                    txtCantidad.setEnabled(true);
                }else if(txtDescripcionP.getText().toString().length() < 3){
                    txtCantidad.setEnabled(false);
                    txtDescripcionP.setError("3 caracteres como minimo");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtCantidad.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(txtCantidad.getText().toString().length() >= 1){
                    int cant = Integer.parseInt(txtCantidad.getText().toString());
                    if(cant < 1){
                        txtCantidad.setError("Valor invalido");
                    }else{
                        spinner.setEnabled(true);
                        ratingBar.setEnabled(true);
                    }
                }else if(txtCantidad.getText().toString().length() < 1){
                    spinner.setEnabled(false);
                    ratingBar.setEnabled(false);
                    ratingBar.setRating(0);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(ratingBar.getRating() > 0){
                    cbxConfirmar.setEnabled(true);

                }else{
                    cbxConfirmar.setEnabled(false);

                }
            }
        });

        cbxConfirmar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbxConfirmar.isChecked() == true){
                    btnRegistrar.setEnabled(true);
                }else{
                    btnRegistrar.setEnabled(false);
                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(registerActivity.this,"Se ha registrado el producto", Toast.LENGTH_LONG).show();
                String nombre = txtNombreP.getText().toString();
                String descripcion = txtDescripcionP.getText().toString();
                String cantidad = txtCantidad.getText().toString();
                String marca = spinner.getSelectedItem().toString();
                String valoracion = Float.toString(ratingBar.getRating());

                producto Producto = new producto(nombre,descripcion,cantidad,marca,valoracion);
                productList.add(Producto);
            }
        });


    }
}