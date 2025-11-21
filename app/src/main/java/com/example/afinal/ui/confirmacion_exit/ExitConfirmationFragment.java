package com.example.afinal.ui.confirmacion_exit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.afinal.StartActivity;
import com.example.afinal.R;

public class ExitConfirmationFragment extends DialogFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ExitConfirmationFragment() {
        // Required empty public constructor
    }

    public static ExitConfirmationFragment newInstance(String param1, String param2) {
        ExitConfirmationFragment fragment = new ExitConfirmationFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exit_confirmation, container, false);

        Button buttonYes = view.findViewById(R.id.buttonYes);
        Button buttonNo = view.findViewById(R.id.buttonNo);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el fragmento actual
                dismiss();

                // Crea un Intent para ir a la actividad de inicio de sesión
                Intent intent = new Intent(getActivity(), StartActivity.class);

                // Establece las banderas para limpiar la pila de actividades
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                // Inicia la actividad de inicio de sesión
                startActivity(intent);

                // Muestra un Toast como mensaje adicional
                Toast.makeText(getContext(), "Gracias por usar la aplicación All in One. ¡Hasta luego!", Toast.LENGTH_SHORT).show();
            }
        });


        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el FragmentManager
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                // Pop de la pila de fragmentos para regresar al fragmento anterior
                fragmentManager.popBackStack();

                // Cerrar el fragmento actual
                dismiss();
            }
        });

        return view;
    }
}
