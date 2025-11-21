package com.example.afinal.ui.ajustes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.afinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AjustesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AjustesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView txtv3;
    private TextView txtv6;
    public AjustesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AjustesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AjustesFragment newInstance(String param1, String param2) {
        AjustesFragment fragment = new AjustesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ajustes, container, false);


        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
        boolean perfilEditado = sharedPreferences.getBoolean("PerfilEditado", false);
        // Recupera el nombre y el correo desde las preferencias compartidas
        String nombre = sharedPreferences.getString("nombreTitular", "");
        String email = sharedPreferences.getString("email", "");

        txtv3 = view.findViewById(R.id.txtv3);
        txtv6 = view.findViewById(R.id.txtv6);

        // Verifica si el perfil ha sido editado
        if (perfilEditado) {
            // Si el perfil ha sido editado, muestra el contenido editado
            txtv3.setText(nombre);
            txtv6.setText(email);
        } else {
            // Si el perfil no ha sido editado, muestra los valores originales o vacíos
            txtv3.setText("Nombre original");
            txtv6.setText("Correo original");
        }

        ConstraintLayout EditPerfil = view.findViewById(R.id.constra1);
        EditPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cargarEditPerfilFragment();
                    }
                }, 400);
            }
        });
        ConstraintLayout EditPassword = view.findViewById(R.id.constra2);
        EditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        cargarEditPassFragment();
                    }
                }, 400);
            }
        });

return view;
    }

    private void cargarEditPerfilFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        navController.navigate(R.id.action_nav_ajuste_to_editPerfilFragment);
    }
    private void cargarEditPassFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        navController.navigate(R.id.action_nav_ajuste_to_editPassFragment);
    }
}