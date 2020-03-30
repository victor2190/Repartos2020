package com.example.repartos2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.repartos2020.modelo.EntregasDatabaseHelper;

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
