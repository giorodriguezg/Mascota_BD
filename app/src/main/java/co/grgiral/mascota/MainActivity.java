package co.grgiral.mascota;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    Adapter adapter;
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
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
        mascotas.add(new Mascota("Garfield", 1, 3 , R.drawable.garfield));
        mascotas.add(new Mascota("Pikachu", 1, 2 , R.drawable.pikachu));
        mascotas.add(new Mascota("Scobydu", 1, 5 , R.drawable.scobydu));
        mascotas.add(new Mascota("Huesos", 1, 11 , R.drawable.huesos));
        mascotas.add(new Mascota("Plutto", 1, 13 , R.drawable.plutto));
        mascotas.add(new Mascota("Lollipop", 1, 1 , R.drawable.lollipop));


    }

    public void irRating(View v){

        for (Mascota mascota: mascotas) {

        }
        Intent i = new Intent(this, MascotaRating.class);
        startActivity(i);

    }
    public void inicializarAdaptador(){

        adaptador= new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }




}
