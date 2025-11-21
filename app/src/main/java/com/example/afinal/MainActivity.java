package com.example.afinal;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.afinal.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView fabImageView = binding.getRoot().findViewById(R.id.fab);

        fabImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        // Abre el Drawer al hacer clic en el ImageView
                        binding.drawerLayout.openDrawer(GravityCompat.START);

                    }
                }, 300);

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Configuración del NavController y AppBarConfiguration
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_pedidos2, R.id.nav_slideshow, R.id.nav_carrito, R.id.nav_ajuste, R.id.nav_exit)
                .setOpenableLayout(drawer)
                .build();

        // Configuración de la navegación con el NavController
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Salir de la aplicación");
        builder.setMessage("¿Estás seguro de que deseas salir de TodoEnUnoAPP?");
        builder.setPositiveButton("Sí", (dialog, which) -> {
            dialog.dismiss();
            exitApp();
        });
        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void exitApp() {
        Toast.makeText(this, "Gracias por quedarse con nosotros, Lo Esperamos", Toast.LENGTH_SHORT).show();
        finishAffinity(); // Cierra la aplicación por completo
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_exit) {
            showExitDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
