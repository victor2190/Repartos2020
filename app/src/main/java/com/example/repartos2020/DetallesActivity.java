package com.example.repartos2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.repartos2020.modelo.Encomienda;
import com.example.repartos2020.modelo.EntregasDatabaseHelper;

import org.w3c.dom.Text;

public class DetallesActivity extends AppCompatActivity {

    private Encomienda encomienda;
    private Intent intent;
    private EntregasDatabaseHelper helper=new EntregasDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        intent=getIntent();

        String nombreDestinatario=(String) intent.getExtras().get("nomDes");
        encomienda=helper.getEncomienda(nombreDestinatario);

        TextView nomDes=(TextView)findViewById(R.id.nomDes);
        nomDes.setText("entregar a: "+encomienda.getNombreDestinatario());

        TextView rutDes=(TextView)findViewById(R.id.rutDes);
        rutDes.setText("rut: "+encomienda.getRutDestinatario());

        TextView dir=(TextView)findViewById(R.id.dir);
        dir.setText("en: "+encomienda.getDireccion());

        TextView nomRem=(TextView)findViewById(R.id.nomRem);
        nomRem.setText("Sr(a): "+encomienda.getNombreRemitente());

        TextView estado=(TextView)findViewById(R.id.estado);
        estado.setText("estado: "+encomienda.getEstado());

        Button bUpdate=(Button) findViewById(R.id.cambiaEstado);
        if (encomienda.getEstado()==1)
            bUpdate.setText("Enviar a reparto");
        else if (encomienda.getEstado()==2)
            bUpdate.setText("Entregar encomienda");
        else
            bUpdate.setText("Cerrar detalle");

        //Agregar condiciones para un detalle mas certero...=D
    }
    public void cambiaEstado(View view)
    {
        int nuevoEstado;
        nuevoEstado=encomienda.getEstado();

        if (nuevoEstado<3)
        {
            nuevoEstado++;
            encomienda.setEstado(nuevoEstado);
            String mensaje=helper.actualizar(encomienda);
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, intent);
        }

        finish();
    }

}
