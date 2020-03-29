package com.example.repartos2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
}
