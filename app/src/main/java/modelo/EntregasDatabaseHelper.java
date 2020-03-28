package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EntregasDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="productos.db";
    private static final int DB_VERSION=1;

    public EntregasDatabaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTxt="CREATE TABLE ENCOMIENDAS(" +
                "ID_ENTREGA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DIRECCION TEXT, " +
                "RUT_DESTINATARIO TEXT, " +
                "NOM_REMITENTE TEXT, " +
                "F_INGRESO TEXT, " +
                "F_RECEPCION TEXT, " +
                "ESTADO INTEGER);";
        db.execSQL(sqlTxt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
