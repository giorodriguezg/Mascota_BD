package co.grgiral.mascota.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import co.grgiral.mascota.R;
import co.grgiral.mascota.pojo.Mascota;


public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){
        //ArrayList<Contacto> contactos =new ArrayList<>();
        ArrayList<Mascota> contactos = new ArrayList<Mascota>();
      /*  contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Giovanni Rodriguez", "3006602553", "giorodriguezg@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Laura María Villa", "3105074273", "lalis310@gmail.com", 4));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Melissa", "3006602553", "artpiece8@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Juan", "3006602553", "fdafasdf@gmail.com", 11));
        */

      BaseDatos db =  new BaseDatos(context);
      if (db.validarTablaVacia()==0){
          insertarTodasLasMascotas(db);
      }
      return db.obtenerTodasLasMascotas();

    }

    public void sumarLike(Mascota mascota){
        BaseDatos db =  new BaseDatos(context);

        db.sumarLike(mascota);
    }

    public void insertarTodasLasMascotas(BaseDatos db){
        //(telefono,foto,nombre,email

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "tommi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.tommi);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pikachu");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pikachu);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Scooby");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.scobydu);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Garfield");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.garfield);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Huesos");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.huesos);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Plutto");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.plutto);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pikachu");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.pikachu2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perry");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKES, "0");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perry);
        db.insertarMascota(contentValues);

    }


    public ArrayList<Mascota> obtenerMascotasRating(){
        ArrayList<Mascota> contactos = new ArrayList<Mascota>();

        BaseDatos db =  new BaseDatos(context);
        return db.obtenerRatingMascotas();

    }


    public void darLikeContacto(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, mascota.getId());
        db.sumarLike(mascota);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);

    }
}
