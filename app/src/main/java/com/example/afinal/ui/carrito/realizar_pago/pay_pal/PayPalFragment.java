package com.example.afinal.ui.carrito.realizar_pago.pay_pal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.afinal.R;
import com.example.afinal.ui.home.HomeFragment;

public class PayPalFragment extends DialogFragment {

    public PayPalFragment() {
        // Required empty public constructor
    }

    public static PayPalFragment newInstance(String param1, String param2) {
        PayPalFragment fragment = new PayPalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pay_pal, container, false);

        // Obtiene una referencia al EditText en la vista
        final EditText paypalEmailEditText = view.findViewById(R.id.paypalEmailEditText);

        // Obtiene referencias a los botones Pagar y Cancelar
        Button buttonPagarPaypal = view.findViewById(R.id.buttonPagar);
        Button buttonCancelarPaypal = view.findViewById(R.id.buttonCancelar);

        // Configura la acción para el botón "Pagar con PayPal"
        buttonPagarPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el correo electrónico de PayPal ingresado por el usuario
                String paypalEmail = paypalEmailEditText.getText().toString();

                if (isValidEmail(paypalEmail)) {
                    // Realiza la lógica de procesamiento del pago con PayPal
                    // Puedes realizar una llamada a la API de PayPal o la acción necesaria
                    // para completar la transacción.

                    // Muestra un mensaje de éxito o realiza cualquier otra acción requerida.
                    showPurchaseSuccessMessagePaypal();
                } else {
                    // Muestra un Toast si el correo electrónico no es válido
                    Toast.makeText(requireContext(), "Por favor, ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configura la acción para el botón "Cancelar"
        buttonCancelarPaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Maneja la acción de cancelar según tus necesidades
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                // Pop de la pila de fragmentos para regresar al fragmento anterior
                fragmentManager.popBackStack();

                // Cerrar el fragmento actual
                dismiss();
            }
        });

        return view;
    }

    private boolean isValidEmail(String email) {
        // Utiliza una expresión regular para validar el formato del correo electrónico
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);

    }

    private void showPurchaseSuccessMessagePaypal() {
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
        View dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.success_message_dialog_paypal, null);
        builder.setView(dialogView);

        TextView textExito = dialogView.findViewById(R.id.textExito);
        TextView textDetalleProductos = dialogView.findViewById(R.id.textDetalleProductos);
        ImageButton btnAccept = dialogView.findViewById(R.id.btnAccept);

        // Puedes personalizar el mensaje de éxito según tus necesidades
        textExito.setText("¡Gracias por su compra con PayPal!");

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
                Toast.makeText(requireContext(), "Pago con PayPal realizado con éxito", Toast.LENGTH_SHORT).show();
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
}
