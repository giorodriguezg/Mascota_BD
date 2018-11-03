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


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas= mascotas;
        this.activity= activity;
    }

    ArrayList<Mascota> mascotas;
    Activity activity;


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
     }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota= mascotas.get(position);
        holder.Foto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
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
        holder.ibLikes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(activity, "diste like a: "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
                DevicePolicyManager mDPM;

                mascota.setLikes(mascota.getLikes()+1);

            }
        });
    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class  MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView Foto;
        private TextView tvNombre;
        private TextView tvid;
        private TextView tvLikes;
        private ImageButton ibLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            Foto= (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvlikes);
            ibLikes = (ImageButton) itemView.findViewById(R.id.imgLike);
            //tvid = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            //btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
