package co.grgiral.mascota.fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import co.grgiral.mascota.MascotaAdaptadorGV;
import co.grgiral.mascota.R;
import co.grgiral.mascota.pojo.Mascota;

public class FragmentPerfil  extends android.support.v4.app.Fragment {
    private RecyclerView rvlistamascotas;
    private ArrayList<Mascota> mascotasgv;
    public MascotaAdaptadorGV adaptadorgv;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_perfil,container,false);

        //android.support.v7.widget.Toolbar miActionBar;
        //miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);
        CircularImageView circularImageView = (CircularImageView) v.findViewById(R.id.circularImage);
// Set Border
        circularImageView.setBorderColor(getResources().getColor(R.color.colorPrimary));
        circularImageView.setBorderWidth(10);
// Add Shadow with default param
        circularImageView.addShadow();
// or with custom param
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);
        circularImageView.setBackgroundColor(Color.RED);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);

        /*listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

*/
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getActivity(),3);

        rvlistamascotas= (RecyclerView) v.findViewById(R.id.rvlistamascotas);
        rvlistamascotas.setLayoutManager(gridLayoutManager);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void inicializarListaMascotas(){

        mascotasgv = new ArrayList<Mascota>();
        mascotasgv.add(new Mascota("pikachu", 1, 21 , R.drawable.pikachu));
        mascotasgv.add(new Mascota("pikachueld", 1, 3 , R.drawable.pikachu2));
        mascotasgv.add(new Mascota("pikachuhu", 1, 2 , R.drawable.pikachu3));
        mascotasgv.add(new Mascota("pikachudu", 1, 5 , R.drawable.pikachu4));
        mascotasgv.add(new Mascota("pikachus", 1, 11 , R.drawable.pikachu5));
        mascotasgv.add(new Mascota("pikachuo", 1, 13 , R.drawable.pikachu6));
        mascotasgv.add(new Mascota("pikachupop", 1, 1 , R.drawable.pikachu7));
        mascotasgv.add(new Mascota("pikachu", 1, 21 , R.drawable.pikachu8));
        mascotasgv.add(new Mascota("pikachueld", 1, 3 , R.drawable.pikachu9));
        mascotasgv.add(new Mascota("pikachuhu", 1, 2 , R.drawable.pikachu10));
        mascotasgv.add(new Mascota("pikachudu", 1, 5 , R.drawable.pikachu11));
        mascotasgv.add(new Mascota("pikachus", 1, 11 , R.drawable.pikachu12));
        mascotasgv.add(new Mascota("pikachuo", 1, 13 , R.drawable.pikachu13));
        mascotasgv.add(new Mascota("pikachupop", 1, 1 , R.drawable.pikachu14));


    }

    public void inicializarAdaptador(){

        adaptadorgv= new MascotaAdaptadorGV(mascotasgv,getActivity());
        rvlistamascotas.setAdapter((RecyclerView.Adapter) adaptadorgv);
    }


   }
