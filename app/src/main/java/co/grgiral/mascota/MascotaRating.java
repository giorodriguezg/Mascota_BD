package co.grgiral.mascota;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.grgiral.mascota.fragment.IRecyclerViewFragmentView;
import co.grgiral.mascota.pojo.Mascota;
import co.grgiral.mascota.presentador.IRecyclerViewFragmentPresenter;
import co.grgiral.mascota.presentador.RecyclerViewFragmentPresenter;

import static java.security.AccessController.getContext;

public class MascotaRating extends AppCompatActivity implements IRecyclerViewFragmentView {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador adaptador;
    private RecyclerView rvMascotasDB;


    private IRecyclerViewFragmentPresenter presenter;


    private RecyclerView listaMascotas;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_rating);
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        //toolbar.setLogo(R.drawable.icons8_cat_footprint_24);
        toolbar.setTitle("Macotas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasDB);
        presenter = new RecyclerViewFragmentPresenter(this, this);
       /* LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();*/

    }




    public void inicializarAdaptador() {

        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        return new MascotaAdaptador(mascotas, this);
    }

    @Override
    public void incializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        listaMascotas.setAdapter(mascotaAdaptador);

    }


}

