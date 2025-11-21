package com.example.afinal.ui.carrito.realizar_pago.otro_metodo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.R;
import com.example.afinal.ui.home.HomeFragment;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OtroMetodoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtroMetodoFragment extends DialogFragment {


    private EditText bitcoinAddressEditText;
    private EditText bitcoinAmountEditText;
    private EditText bitcoinConfirmationsEditText;
    private String generatedToken;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OtroMetodoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OtroMetodoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OtroMetodoFragment newInstance(String param1, String param2) {
        OtroMetodoFragment fragment = new OtroMetodoFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_otro_metodo, container, false);
        bitcoinAddressEditText = rootView.findViewById(R.id.bitcoinAddressEditText);
        bitcoinAmountEditText = rootView.findViewById(R.id.bitcoinAmountEditText);
        bitcoinConfirmationsEditText = rootView.findViewById(R.id.bitcoinConfirmationsEditText);

        Button buttonPagar = rootView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = rootView.findViewById(R.id.buttonCancelar);

        // Configura la acción para el botón "Pagar"
        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processBitcoinPayment();
            }
        });

        // Configura la acción para el botón "Generar Token"
        ImageView buttonGenerarToken = rootView.findViewById(R.id.buttonGenerarToken);
        buttonGenerarToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateAndShowToken();
            }
        });

        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cancel action as needed
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
                dismiss();
            }
        });

        return rootView;
    }

    private void processBitcoinPayment() {
        String bitcoinAddress = bitcoinAddressEditText.getText().toString();
        String bitcoinAmount = bitcoinAmountEditText.getText().toString();
        String enteredToken = bitcoinConfirmationsEditText.getText().toString();

        if (bitcoinAddress.isEmpty() || bitcoinAmount.isEmpty() || enteredToken.isEmpty()) {
            Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            // Verifica si el monto de Bitcoin es igual a 0.38
            if (Double.parseDouble(bitcoinAmount) == 0.38) {
                // Verifica si la dirección de Bitcoin es válida
                if (isValidBitcoinAddress(bitcoinAddress)) {
                    // Verifica si el token ingresado coincide con el generado
                    if (enteredToken.equals(generatedToken)) {
                        // Add your logic for Bitcoin payment processing here
                        // You can use the entered values (bitcoinAddress, bitcoinAmount, bitcoinConfirmations)
                        // to initiate the Bitcoin payment process.
                        showBitcoinPaymentSuccessMessage();
                    } else {
                        // Muestra un mensaje de error si el token ingresado no coincide
                        Toast.makeText(requireContext(), "Token incorrecto", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Muestra un mensaje de error si la dirección de Bitcoin no es válida
                    Toast.makeText(requireContext(), "Dirección de Bitcoin no válida", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Muestra un mensaje de error si el monto no es igual a 0.38
                Toast.makeText(requireContext(), "Monto de Bitcoin no válido. Debe ser 0.38", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isValidBitcoinAddress(String address) {
        // Expresión regular para validar direcciones de Bitcoin
        String bitcoinAddressPattern = "^[13][a-km-zA-HJ-NP-Z1-9]{25,34}$";

        // Verifica si la dirección coincide con el patrón
        return address.matches(bitcoinAddressPattern);
    }

    private void showBitcoinPaymentSuccessMessage() {
            // Obtén la información almacenada en SharedPreferences
            SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);

            String productoId = "AllInOneProduct";
            String nombreProducto = sharedPreferences.getString(productoId + "_nombre", "");
            int cantidadAlmacenada = sharedPreferences.getInt(productoId + "_cantidad", 0);
            int cantidadTotalAlmacenada = sharedPreferences.getInt(productoId + "_cantidadTotal", 0);

            // Construye el mensaje con la información de los productos
            StringBuilder detalleProductos = new StringBuilder();
            detalleProductos.append("Nombre Producto: ").append(nombreProducto).append("\n");
            detalleProductos.append("Cantidad Producto: ").append(cantidadAlmacenada).append(" unidades\n");
            detalleProductos.append("Costo Total: /s ").append(cantidadTotalAlmacenada);

            // Crea el diálogo de éxito y muestra la información de los productos
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.success_message_dialog_card, null);
            builder.setView(dialogView);

            TextView textExito = dialogView.findViewById(R.id.textExito);
            TextView textDetalleProductos = dialogView.findViewById(R.id.textDetalleProductos);
            ImageButton btnAccept = dialogView.findViewById(R.id.btnAccept);

            // Puedes personalizar el mensaje de éxito según tus necesidades
            textExito.setText("¡Gracias por su compra con Bitcoin!");

            // Establece el mensaje en el TextView
            textDetalleProductos.setText(detalleProductos.toString());

            // Muestra el diálogo
            final AlertDialog dialog = builder.create();
            dialog.show();

            // Configura el clic del botón "Aceptar"
            btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Puedes realizar acciones adicionales o cerrar la actividad aquí
                    Toast.makeText(requireContext(), "Pago con Bitcoin realizado con éxito", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    retrocecoFragmet();
                }
            });
        }
        private void  retrocecoFragmet(){

            // Obtén el FragmentManager
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

            // Limpiar la pila de fragmentos
            // fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            // Elimina los últimos 4 fragmentos de la pila
            for (int i = 0; i < 3; i++) {
                fragmentManager.popBackStack();
            }
            // Reemplaza el contenido actual con el fragmento principal
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.nav_host_fragment_content_main, new HomeFragment()); // Reemplaza "HomeFragment" con el nombre de tu fragmento principal
            transaction.addToBackStack(null); // Añade este fragmento a la pila para que el botón de retroceso lo maneje correctamente
            transaction.commit();


            // Puedes realizar acciones adicionales o mostrar mensajes aquí
            Toast.makeText(requireContext(), "Compra realizada de forma exitosa", Toast.LENGTH_SHORT).show();
        }

        private void generateAndShowToken() {
        // Genera un token aleatorio de 4 dígitos
        generatedToken = generateRandomToken();

        // Muestra el token en un Toast
        Toast.makeText(requireContext(), "Token generado: " + generatedToken, Toast.LENGTH_SHORT).show();
    }

    private String generateRandomToken() {
        // Genera un token aleatorio de 4 dígitos
        Random random = new Random();
        int randomToken = random.nextInt(9000) + 1000; // Entre 1000 y 9999
        return String.valueOf(randomToken);
    }
}