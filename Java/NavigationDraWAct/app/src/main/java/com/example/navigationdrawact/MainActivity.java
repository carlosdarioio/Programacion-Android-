package com.example.navigationdrawact;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //2020
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_Wfactura:
                Uri uriwf = Uri.parse("http://10.1.201.5/DxWebIT//WFactura.aspx"); // missing 'http://' will cause crashed
                Intent intentWfactura = new Intent(Intent.ACTION_VIEW, uriwf);
                startActivity(intentWfactura);
                return true;

            case R.id.action_OINVinGuide:
                Uri inGuide = Uri.parse("http://10.1.201.5/DxWebIT/OINVinGuide.aspx"); // missing 'http://' will cause crashed
                Intent intentinGuide = new Intent(Intent.ACTION_VIEW, inGuide);
                startActivity(intentinGuide);
                return true;
            case R.id.action_ZonasXDep:
                Uri ZonasXDep = Uri.parse("http://10.1.201.5/DxWebIT/Zonas/ZonaXDep.aspx"); // missing 'http://' will cause crashed
                Intent intentZonasXDep = new Intent(Intent.ACTION_VIEW, ZonasXDep);
                startActivity(intentZonasXDep);
                return true;
            case R.id.action_ZonasXZonas:
                Uri ZonasXZonas = Uri.parse("http://10.1.201.5/DxWebIT/Zonas/Zonas.aspx"); // missing 'http://' will cause crashed
                Intent intentZonasXZonas = new Intent(Intent.ACTION_VIEW, ZonasXZonas);
                startActivity(intentZonasXZonas);
                return true;
            case R.id.action_WCliente:
                Uri WCliente = Uri.parse("http://10.1.201.5/DxWebIT//Wcliente.aspx"); // missing 'http://' will cause crashed
                Intent intentWCliente = new Intent(Intent.ACTION_VIEW, WCliente);
                startActivity(intentWCliente);
                return true;
            case R.id.action_marcaje:
                Intent intentMarcarxCod = new Intent(this, MarcarPorCodigo.class);
                startActivity(intentMarcarxCod);
                return true;
            case R.id.action_marcajeFind:
                Intent intentFindMarc = new Intent(this, MarcajeBuscarCodigo.class);
                startActivity(intentFindMarc);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //2020

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
