package com.example.afinal.ui.ajustes.editar_perfil;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditPerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditPerfilFragment extends DialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView txtv3;
    private TextView txtv6;
    public EditPerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditPerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditPerfilFragment newInstance(String param1, String param2) {
        EditPerfilFragment fragment = new EditPerfilFragment();
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
        View view = inflater.inflate(R.layout.fragment_edit_perfil, container, false);
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
        boolean perfilEditado = sharedPreferences.getBoolean("PerfilEditado", false);

        Button saveButton = view.findViewById(R.id.btnGuardarCambios);
        EditText editNameEditText = view.findViewById(R.id.editTextNombre);
        EditText editEmailEditText = view.findViewById(R.id.editTextEmail);

        // Recupera el estado de edición del perfil desde las preferencias compartidas
        boolean PerfilEditado = sharedPreferences.getBoolean("PerfilEditado", false);

        // Añade un listener al botón "saveButton" para guardar los cambios
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados en los EditText
                String newName = editNameEditText.getText().toString();
                String newEmail = editEmailEditText.getText().toString();

                // Realizar aquí la lógica para guardar los cambios (por ejemplo, actualizar la base de datos)
                if (TextUtils.isEmpty(newName) && TextUtils.isEmpty(newEmail)) {
                    // Ambos campos están vacíos, muestra un Toast para completar los campos.
                    Toast.makeText(requireContext(), "Completa los campos", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    // Si el nombre no está vacío y es válido (solo contiene letras y espacios)
                    if (!TextUtils.isEmpty(newName) && newName.matches("^[a-zA-Z ]+$")) {
                        editor.putString("nombreTitular", newName);
                    } else if (!TextUtils.isEmpty(newName)) {
                        // Nombre no válido, muestra un Toast de error.
                        Toast.makeText(requireContext(), "Ingresa un nombre válido", Toast.LENGTH_SHORT).show();
                    }

                    // Si el email no está vacío y es un correo válido sin FireBase
                    if (!TextUtils.isEmpty(newEmail) && Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()) {
                        editor.putString("email", newEmail);
                    } else if (!TextUtils.isEmpty(newEmail)) {
                        // Correo no válido, muestra un Toast de error.
                        Toast.makeText(requireContext(), "Ingresa un correo válido", Toast.LENGTH_SHORT).show();
                    }

                    editor.putBoolean("PerfilEditado", true); // Marcar el perfil como editado
                    editor.apply(); // Guarda los cambios en las preferencias compartidas

                    if (!TextUtils.isEmpty(newName) && TextUtils.isEmpty(newEmail)) {
                        // Solo se actualizó el nombre
                        Toast.makeText(requireContext(), "Nombre guardado correctamente", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(newName) && !TextUtils.isEmpty(newEmail)) {
                        // Solo se actualizó el email
                        Toast.makeText(requireContext(), "Email guardado correctamente", Toast.LENGTH_SHORT).show();
                    } else if (!TextUtils.isEmpty(newName) && !TextUtils.isEmpty(newEmail)) {
                        // Ambos campos se actualizaron
                        Toast.makeText(requireContext(), "Nombre y Email guardados correctamente", Toast.LENGTH_SHORT).show();
                    }
                }

                // Limpiar los EditText
                editNameEditText.setText("");
                editEmailEditText.setText("");

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                // Pop de la pila de fragmentos para regresar al fragmento anterior
                fragmentManager.popBackStack();

                // Cerrar el fragmento actual
                dismiss();
            }
        });

        Button buttonNo = view.findViewById(R.id.buttonNo);
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