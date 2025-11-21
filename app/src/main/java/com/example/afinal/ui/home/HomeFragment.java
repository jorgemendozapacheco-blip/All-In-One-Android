package com.example.afinal.ui.home;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.airbnb.lottie.LottieAnimationView;
import com.example.afinal.R;
import com.example.afinal.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private final Handler handler = new Handler();
    private Runnable runnable;
    private boolean isFirstRun = true; // Variable para asegurarse de que la animación solo se ejecute una vez


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        CardView PromoCalzado = root.findViewById(R.id.cardCalzado);
        PromoCalzado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
            }
        });
        TextView VerCalzado = root.findViewById(R.id.VerMasCalzado);
        VerCalzado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cargarCalzadoFragment();
                    }
                }, 300);
            }
        });
        CardView PromoElectrodomesticos= root.findViewById(R.id.cardElectrodomesticos);
        PromoElectrodomesticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                cargarElectrodomesticosFragment();
            }
        });

        CardView PromoVestimenta = root.findViewById(R.id.cardVestimenta);
        PromoVestimenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
            }
        });
        TextView VerVestir = root.findViewById(R.id.VerMasVestir);
        VerVestir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cargarVestimentaFragment();
                    }
                }, 300);
            }
        });
        CardView PromoJuguetes= root.findViewById(R.id.cardJuguetes);
        PromoJuguetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
            }
        });
        TextView VerJuguetes = root.findViewById(R.id.VerMasJuguetes);
        VerJuguetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cargarJuguetesFragment();
                    }
                }, 300);
            }
        });

        // Referencia al LottieAnimationView
        LottieAnimationView deslizarManoAnimationView = root.findViewById(R.id.deslizarMano);

// Añade este código para hacer la animación Lottie visible al inicio
        deslizarManoAnimationView.setVisibility(View.VISIBLE);
        deslizarManoAnimationView.playAnimation();

// Establece la duración de la animación Lottie
        int lottieAnimationDuration = 5000; // Duración en milisegundos

// Programa la tarea para hacer invisible el LottieAnimationView después de la duración
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Hacer invisible el LottieAnimationView
                deslizarManoAnimationView.setVisibility(View.INVISIBLE);
            }
        }, lottieAnimationDuration * 2); // Hace invisible después de dos ciclos completos

// Obtén la referencia de tu HorizontalScrollView
        HorizontalScrollView horizontalScrollView = root.findViewById(R.id.tu_horizontal_scroll_view_id);

// Establece la duración de la animación y la velocidad de desplazamiento
        int durationForward = 700; // Duración hacia adelante en milisegundos
        int durationBackward = 400; // Duración de regreso en milisegundos
        final int speed = 1; // Velocidad de desplazamiento

// Crea un nuevo Runnable para la animación de desplazamiento
        Runnable runnable = new Runnable() {
            private boolean isForward = true; // Variable para verificar la dirección del desplazamiento

            @Override
            public void run() {
                if (isForward) {
                    horizontalScrollView.smoothScrollBy(speed, 0);
                } else {
                    horizontalScrollView.smoothScrollBy(-speed, 0);
                }

                if (horizontalScrollView.getScrollX() >= (horizontalScrollView.getChildAt(0).getMeasuredWidth() - horizontalScrollView.getMeasuredWidth())) {
                    // Si llega al final, cambia la dirección a retroceso
                    isForward = false;
                } else if (horizontalScrollView.getScrollX() <= 0) {
                    // Si llega al principio, cambia la dirección a adelante y detén la animación después del primer ciclo
                    isForward = true;
                    if (!isFirstRun) {
                        handler.removeCallbacks(this);
                        return;
                    }
                    isFirstRun = false;
                }

                handler.postDelayed(this, speed);
            }
        };

// Inicia la animación de desplazamiento después de un retraso inicial
        handler.postDelayed(runnable, isFirstRun ? durationForward : durationBackward);



        return root;
    }

    @Override
    public void onDestroyView() {
        handler.removeCallbacks(runnable);

        super.onDestroyView();
        binding = null;
    }
    private void cargarCalzadoFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_navigation_categorias_to_calzadoFragment);
    }
    private void cargarElectrodomesticosFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_navigation_categorias_to_electrodomesticosFragment);
    }
    private void cargarVestimentaFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_navigation_categorias_to_vestimentaFragment);
    }
    private void cargarJuguetesFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_navigation_categorias_to_juguetesFragment);
    }
}