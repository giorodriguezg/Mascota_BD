package co.grgiral.mascota.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import co.grgiral.mascota.MascotaAdaptador;
import co.grgiral.mascota.R;
import co.grgiral.mascota.pojo.Mascota;
import co.grgiral.mascota.presentador.IRecyclerViewFragmentPresenter;
import co.grgiral.mascota.presentador.RecyclerViewFragmentPresenter;

public class FragmentHome extends Fragment implements IRecyclerViewFragmentView{


    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;
    public MascotaAdaptador adaptador;
    private IRecyclerViewFragmentPresenter presenter;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_home,container,false);

        //android.support.v7.widget.Toolbar miActionBar;
        //miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
        /*LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;*/
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

   /* public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Tommi", 1, 21 , R.drawable.tommi));
        mascotas.add(new Mascota("Garfield", 1, 3 , R.drawable.garfield));
        mascotas.add(new Mascota("Pikachu", 1, 2 , R.drawable.pikachu));
        mascotas.add(new Mascota("Scobydu", 1, 5 , R.drawable.scobydu));
        mascotas.add(new Mascota("Huesos", 1, 11 , R.drawable.huesos));
        mascotas.add(new Mascota("Plutto", 1, 13 , R.drawable.plutto));
        mascotas.add(new Mascota("Lollipop", 1, 1 , R.drawable.lollipop));

    }

    public void inicializarAdaptador(){

        adaptador= new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }
*/


    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        rvMascotas.setLayoutManager(llm);
    }

    public void onClickLike(Mascota mascota){
        presenter = new RecyclerViewFragmentPresenter(this, getContext());


    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        return          new MascotaAdaptador(mascotas,getActivity());
    }

    @Override
    public void incializarAdaptadorRV(MascotaAdaptador mascotaAdaptador) {
        rvMascotas.setAdapter(mascotaAdaptador);

    }

}
