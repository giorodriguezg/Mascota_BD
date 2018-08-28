package co.grgiral.mascota;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotaRating extends AppCompatActivity{
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador adaptador;

    private RecyclerView listaMascotas;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_rating);
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasDummy);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }


    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Tommi", 1, 21 , R.drawable.tommi));
        mascotas.add(new Mascota("Huesos", 1, 13 , R.drawable.huesos));
        mascotas.add(new Mascota("Plutto", 1, 11 , R.drawable.plutto));
        mascotas.add(new Mascota("Lollipop", 1, 9 , R.drawable.lollipop));
        mascotas.add(new Mascota("Scobydu", 1, 5 , R.drawable.scobydu));



    }

    public void inicializarAdaptador(){

        adaptador= new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }
}
