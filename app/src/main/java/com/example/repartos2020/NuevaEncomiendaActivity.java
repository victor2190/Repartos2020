package com.example.repartos2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.repartos2020.modelo.Encomienda;
import com.example.repartos2020.modelo.EntregasDatabaseHelper;

public class NuevaEncomiendaActivity extends AppCompatActivity {

    private EntregasDatabaseHelper helper=new EntregasDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_encomienda);
        EditText etFecha=(EditText)findViewById(R.id.etFecIn);
        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.etFecIn:
                        mostrarCalendario();
                }
            }
        });
    }
    private void mostrarCalendario()
    {
        DatePickerFragment nuevoFragment=DatePickerFragment.instancia(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day)
                    {
                        final String fecha=day + " / " + (month+1) + " / " + year;
                        EditText etFecha=(EditText) findViewById(R.id.etFecIn);
                        etFecha.setText(fecha);
                    }
                }
        );
        nuevoFragment.show(getSupportFragmentManager(),"datepicker");
    }
    public void ingresarEncomienda(View view)
    {
        //datos del destinatario===>
        String nomDes=((TextView) findViewById(R.id.etDestNom)).getText().toString();
        String rutDes=((TextView) findViewById(R.id.etDestRut)).getText().toString();
        String direccion=((TextView) findViewById(R.id.etDestDir)).getText().toString();
        //datos del remitente===>
        String nomRem=((TextView) findViewById(R.id.etRemNom)).getText().toString();
        String fecha=((TextView) findViewById(R.id.etFecIn)).getText().toString();

        Encomienda encomienda=new Encomienda
                (direccion, rutDes, nomDes, nomRem, fecha, null, 1);
        helper.ingresarEncomienda(encomienda);
        finish();
    }
}
