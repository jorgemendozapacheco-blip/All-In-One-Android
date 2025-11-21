package com.example.afinal.ui.carrito.realizar_pago;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.afinal.R;

public class PagarFragment extends DialogFragment {

    // Identificadores de los RadioButton
    private static final int RADIO_BUTTON_CREDIT_CARD = R.id.radioButtonCreditCard;
    private static final int RADIO_BUTTON_PAYPAL = R.id.radioButtonPayPal;
    private static final int RADIO_BUTTON_BITCOIN = R.id.radioButtonBitcoin;

    public PagarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pagar, container, false);

        // Obtener referencias a los elementos de la interfaz de usuario
        RadioGroup radioGroup = view.findViewById(R.id.paymentMethodGroup);
        Button pagarButton = view.findViewById(R.id.pagarButton);
        Button buttonNo = view.findViewById(R.id.buttonNo);

        // Configurar el listener del botón de pago
        pagarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el ID del RadioButton seleccionado
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == -1) {
                    // Ningún RadioButton seleccionado
                    Toast.makeText(getContext(), "Selecciona un método de pago1", Toast.LENGTH_SHORT).show();
                } else {
                    // Procesar el pago según el método seleccionado
                    procesarPago(selectedRadioButtonId);
                }
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


    private void procesarPago(int selectedRadioButtonId) {
        if (selectedRadioButtonId == R.id.radioButtonCreditCard) {
            // Lógica para tarjeta de crédito
            Toast.makeText(getContext(), "Pagaste con Tarjeta de Crédito", Toast.LENGTH_SHORT).show();
            cargarPagoCardFragment();
        } else if (selectedRadioButtonId == R.id.radioButtonPayPal) {
            // Lógica para PayPal
            Toast.makeText(getContext(), "Pagaste con PayPal", Toast.LENGTH_SHORT).show();
            cargarPagoPayPalFragment();
        } else if (selectedRadioButtonId == R.id.radioButtonBitcoin) {
            // Lógica para Bitcoin
            Toast.makeText(getContext(), "EEl costo Total es de \uD83D\uDCB2 0.38 Bitcoin", Toast.LENGTH_SHORT).show();
            cargarOtroMetodoFragment();
        } else {
            // Si no se selecciona ningún botón, muestra un Toast o realiza otra acción
            Toast.makeText(getContext(), "Selecciona un método de pago", Toast.LENGTH_SHORT).show();
        }
    }


    private void cargarPagoCardFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_PagarFragment_to_creditCardFragment);
    }

    private void cargarPagoPayPalFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_PagarFragment_to_payPalFragment);
    }

    private void cargarOtroMetodoFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);

        // Navega al destino del BebidasFragment
        navController.navigate(R.id.action_PagarFragment_to_otroMetodoFragment);
    }
}

