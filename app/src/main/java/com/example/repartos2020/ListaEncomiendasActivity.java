package com.example.repartos2020;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.repartos2020.modelo.Encomienda;
import com.example.repartos2020.modelo.EntregasDatabaseHelper;

import java.util.List;

public class ListaEncomiendasActivity extends ListActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargarLista();
    }

    public void cargarLista()
    {
        lista=getListView();
        EntregasDatabaseHelper helper=new EntregasDatabaseHelper(this);
        List<Encomienda> entregaList=helper.listaEncomiendas();

        ArrayAdapter<Encomienda> listaAdapter=new ArrayAdapter<Encomienda>(this,
                android.R.layout.simple_expandable_list_item_1,entregaList);

        lista.setAdapter(listaAdapter);
    }
    @Override
    public void onListItemClick(ListView listView, View view, int posicion, long id)
    {
        Object o=lista.getItemAtPosition(posicion);
        String linea=o.toString();
        String[] separar=linea.split(":");

        Intent intent=new Intent(ListaEncomiendasActivity.this, DetallesActivity.class);
        //intent.putExtra("nomDes", separar[0]);
        intent.putExtra("1", "item1");
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1)
            if (resultCode==RESULT_OK)
                cargarLista();
    }

}
