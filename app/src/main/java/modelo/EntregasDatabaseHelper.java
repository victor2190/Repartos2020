package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EntregasDatabaseHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME = "productos.db";
    private static final int DB_VERSION = 1;

    public EntregasDatabaseHelper(@Nullable Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sqlTxt = "CREATE TABLE ENCOMIENDAS(" +
                "ID_ENCOMIENDA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DIRECCION TEXT, " +
                "RUT_DESTINATARIO TEXT, " +
                "NOM_DESTINATARIO," +
                "NOM_REMITENTE TEXT, " +
                "F_INGRESO TEXT, " +
                "F_RECEPCION TEXT, " +
                "ESTADO INTEGER);";
        db.execSQL(sqlTxt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void ingresarEncomienda(Encomienda encomienda)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("DIRECCION", encomienda.getDireccion());
        valores.put("RUT_DESTINATARIO", encomienda.getRutDestinatario());
        valores.put("NOM_DESTINATARIO", encomienda.getNombreDestinatario());
        valores.put("NOM_REMITENTE", encomienda.getNombreRemitente());
        valores.put("F_INGRESO", encomienda.getFechaIngreso());
        valores.put("F_RECEPCION", encomienda.getFechaRecepcion());
        valores.put("ESTADO", encomienda.getEstado());
        /*los valores permitidos para "ESTADO" en la bd son 1, 2 y 3 los cuales son :
        [1=en bodega||2=en reparto||3=entregado]
        configurar este atributo según corresponda más adelante*/
    }

    //mostrar encomiendas
    public List<Encomienda> listaEncomiendas()
    {
        List<Encomienda> encomiendas = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("ENCOMIENDAS", new String[]{
                        "ID_ENCOMIENDA", "DIRECCION", "RUT_DESTINATARIO", "NOM_DESTINATARIO",
                        "NOM_REMITENTE", "F_INGRESO", "F_RECEPCION", "ESTADO"},
                null, null, null, null, null);
        cursor.moveToFirst();

        do {
            encomiendas.add(new Encomienda(
                    cursor.getInt(0),//id entrega
                    cursor.getString(1),//direccion
                    cursor.getString(2),//rut destinatario
                    cursor.getString(3),//nombre destinatario
                    cursor.getString(4),//nombre remitente
                    cursor.getString(5),//fecha ingreso
                    cursor.getString(6),//fecha recepcion
                    cursor.getInt(7)//estado
            ));
        }
        while (cursor.moveToNext());
        cursor.close();
        db.close();

        return encomiendas;
    }
}

