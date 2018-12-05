package co.grgiral.mascota.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import co.grgiral.mascota.pojo.Mascota;

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = " CREATE TABLE  " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +

                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL UNIQUE, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT," +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKES + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";


        db.execSQL( queryCrearTablaMascota);

//Fafdsdcd
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " +  ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas =  new ArrayList<>();
        String query =  "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(3));
            mascotas.add(mascotaActual);

        }
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }



    public int obtenerLikesMascota(Mascota mascota){
        int likes=0;

        String query = "SELECT "+ ConstantesBaseDatos.TABLE_MASCOTAS_LIKES+ " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                        " WHERE "+ ConstantesBaseDatos.TABLE_MASCOTAS_ID + " = "+
                        mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
    public int validarTablaVacia( ){
        int registrosTabla=0;

        String query = "SELECT COUNT(*) FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext()){
            registrosTabla = registros.getInt(0);
        }
        db.close();
        return registrosTabla;
    }

    public void sumarLike(Mascota mascota){
        String query = "UPDATE " + ConstantesBaseDatos.TABLE_MASCOTAS + " SET "+ ConstantesBaseDatos.TABLE_MASCOTAS_LIKES+
                " = "+ ConstantesBaseDatos.TABLE_MASCOTAS_LIKES  +"+ 1 WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID +
                " = " + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();


        db.execSQL(query);

    }
    public ArrayList<Mascota> obtenerRatingMascotas() {

        ArrayList<Mascota> mascotas =  new ArrayList<>();
        String query =  "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS + " ORDER BY LIKES DESC LIMIT 5";
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(3));
            mascotas.add(mascotaActual);

        }
        return mascotas;

    }
}
