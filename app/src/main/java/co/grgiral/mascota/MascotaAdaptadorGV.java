package co.grgiral.mascota;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MascotaAdaptadorGV extends RecyclerView.Adapter<MascotaAdaptadorGV.MascotaViewHolder>{

    public MascotaAdaptadorGV(ArrayList<Mascota> mascotasgv,Activity activity){
        this.mascotasgv= mascotasgv;
        this.activity= activity;
    }

    ArrayList<Mascota> mascotasgv;
    Activity activity;


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota= mascotasgv.get(position);
        holder.Foto.setImageResource(mascota.getFoto());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()));
        /*holder.Foto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);
            }
        });*/

    }


    @Override
    public int getItemCount() {
        return mascotasgv.size();
    }

    public static class  MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView Foto;
        private TextView tvNombre;
        private TextView tvid;
        private TextView tvLikes;
        private ImageButton ibLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            Foto= (ImageView) itemView.findViewById(R.id.imgMascotaPerfil);
            tvLikes = (TextView) itemView.findViewById(R.id.tvlikesperfil);
            //tvid = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            //btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
