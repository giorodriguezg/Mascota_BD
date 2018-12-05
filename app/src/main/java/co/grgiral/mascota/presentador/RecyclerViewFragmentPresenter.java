package co.grgiral.mascota.presentador;

import android.content.Context;

import java.security.AccessControlContext;
import java.util.ArrayList;

import co.grgiral.mascota.MascotaRating;
import co.grgiral.mascota.db.ConstructorMascotas;
import co.grgiral.mascota.fragment.IRecyclerViewFragmentView;
import co.grgiral.mascota.pojo.Mascota;


public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{


    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context= context;
        obtenerMascotasBaseDatos();
    }

    public RecyclerViewFragmentPresenter(MascotaRating iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context= context;
        obtenerRatingMascotas();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();


    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.incializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }

    @Override
    public void obtenerRatingMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas= constructorMascotas.obtenerMascotasRating();
        mostrarMascotasRV();

    }


}
