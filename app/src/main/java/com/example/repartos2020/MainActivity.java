package com.example.repartos2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.repartos2020.modelo.Encomienda;
import com.example.repartos2020.modelo.EntregasDatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EntregasDatabaseHelper helper=new EntregasDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView msg=(TextView)findViewById(R.id.textView);
        String user=getIntent().getExtras().getString("usuario");
        msg.setText("Bienvenido "+user);


    }
    public void formularioIngresar(View view)
    {
        Intent intent=new Intent(this,NuevaEncomiendaActivity.class);
        startActivity(intent);
    }
    public void verLista(View view)
    {
        try{
            ArrayList<Encomienda> encomiendas=(ArrayList<Encomienda>)helper.listaEncomiendas();
            //sin la linea superior se cae si la lista está vacía...D=

            Intent intent=new Intent(this, ListaEncomiendasActivity.class);
            startActivity(intent);
        }
        catch (Exception ex){
            Toast.makeText(this, "Lista vacía", Toast.LENGTH_SHORT).show();
        }
    }
    public void mapa(View view)
    {
        Intent intent=new Intent(this, MapaActivity.class);
        startActivity(intent);
    }
    public void eliminar(View view)
    {
        String msg=helper.eliminarEntregados();
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
