package co.grgiral.mascota;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tabLayout ;
    private ViewPager viewPager;
    SwipeRefreshLayout sfiMiIndicadorRefresh;
    ListView lstMiLista;
    private Intent i;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);

        //toolbar.setLogo(R.drawable.icons8_cat_footprint_24);
        //toolbar.setTitle("Macotas");
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        toolbar= (Toolbar) findViewById(R.id.toolbar);

        if(toolbar!= null){
            setSupportActionBar(toolbar);
        }
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        //listaMascotas.setLayoutManager(llm);



        //inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                i = new Intent(this, Contacto.class);
                break;
            case R.id.mAcercaDe:
                i = new Intent(this, ActivityAcercaDe.class);
                break;
            case R.id.mRating:
                i= new Intent(this,MascotaRating.class);
                break;

        }

        startActivity(i);
        return super.onOptionsItemSelected(item);
    }




    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_cat_footprint_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_dog_bone_32);

    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new FragmentHome());
        fragments.add(new FragmentPerfil());
        return fragments;
    }



}
