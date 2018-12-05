package co.grgiral.mascota.fragment;

import java.util.ArrayList;

import co.grgiral.mascota.MascotaAdaptador;
import co.grgiral.mascota.pojo.Mascota;


public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void incializarAdaptadorRV(MascotaAdaptador contactoAdaptador);

}
