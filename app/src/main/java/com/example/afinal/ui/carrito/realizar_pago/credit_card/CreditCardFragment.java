package com.example.afinal.ui.carrito.realizar_pago.credit_card;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.afinal.R;
import com.example.afinal.ui.home.HomeFragment;

public class CreditCardFragment  extends DialogFragment {

    private EditText cardNumberEditText;
    private EditText nameEditText;
    private TextView TxtTitular;  // Declaración de TxtTitular

    public CreditCardFragment() {
        // Required empty public constructor
    }

    public static CreditCardFragment newInstance(String param1, String param2) {
        CreditCardFragment fragment = new CreditCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_credit_card, container, false);

        // Obtén referencias a los EditText para el nombre y el número de tarjeta
        cardNumberEditText = rootView.findViewById(R.id.quantityEditText);
        nameEditText = rootView.findViewById(R.id.nameEditText);

        // Establece el máximo de 16 dígitos en el EditText del número de tarjeta
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(16);
        cardNumberEditText.setFilters(filters);

        // Obtén referencias a los botones Pagar y Cancelar
        Button buttonPagar = rootView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = rootView.findViewById(R.id.buttonCancelar);

        // Configura la acción para el botón "Pagar"
        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Realiza la lógica de procesamiento del pago
                processPayment();
            }
        });

        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el fragmento
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();

                // Pop de la pila de fragmentos para regresar al fragmento anterior
                fragmentManager.popBackStack();

                // Cerrar el fragmento actual
                dismiss();}
        });

        return rootView;
    }

    private void processPayment() {
        // Obtiene el nombre y el número de tarjeta ingresados por el usuario
        String name = nameEditText.getText().toString();
        String cardNumber = cardNumberEditText.getText().toString();

        if (name.isEmpty() || cardNumber.isEmpty()) {
            // Muestra un Toast si alguno de los campos está vacío
            Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        } else if (!name.matches("^[a-zA-Z ]+$")) {
            // Muestra un Toast si el nombre contiene caracteres que no son letras o espacios
            Toast.makeText(requireContext(), "El nombre debe contener solo letras y espacios", Toast.LENGTH_SHORT).show();
        } else if (!cardNumber.matches("^[0-9]+$")) {
            // Muestra un Toast si el número de tarjeta contiene caracteres no numéricos
            Toast.makeText(requireContext(), "El número de tarjeta debe contener solo números", Toast.LENGTH_SHORT).show();
        } else if (cardNumber.length() != 16) {
            // Muestra un Toast si el número de tarjeta no tiene exactamente 16 dígitos
            Toast.makeText(requireContext(), "El número de tarjeta debe tener exactamente 16 dígitos", Toast.LENGTH_SHORT).show();
        } else {
            // Realiza la lógica de procesamiento del pago con el nombre y el número de tarjeta
            showPurchaseSuccessMessageCard();
        }
    }


    private void showPurchaseSuccessMessageCard() {
        // Obtén la información almacenada en SharedPreferences
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
        boolean perfilEditado = sharedPreferences.getBoolean("PerfilEditado", false);
        // Recupera el nombre desde las preferencias compartidas PerfilEditado
        String nombre = sharedPreferences.getString("nombreTitular", "");


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

        TextView TxtTitular = dialogView.findViewById(R.id.txtv3);
        TextView textExito = dialogView.findViewById(R.id.textExito);
        TextView textDetalleProductos = dialogView.findViewById(R.id.textDetalleProductos);
        ImageButton btnAccept = dialogView.findViewById(R.id.btnAccept);

        // Puedes personalizar el mensaje de éxito según tus necesidades

        textExito.setText("¡Gracias por su compra con Visa!");

        // Verifica si el perfil ha sido editado
        if (perfilEditado) {
            // Si el perfil ha sido editado, muestra el contenido editado
            TxtTitular.setText(nombre);  // Cambio aquí
        } else {
            // Si el perfil no ha sido editado, muestra los valores originales o vacíos
            TxtTitular.setText("Nombre original");  // Cambio aquí
        }
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
                Toast.makeText(requireContext(), "Pago con Tarjeta Visa realizado con éxito", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                retrocecoFragmet();
                limpiarPerfil(sharedPreferences);
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

    // Método para limpiar el perfil en SharedPreferences
    private void limpiarPerfil(SharedPreferences sharedPreferences) {
        // Utiliza un editor para realizar las modificaciones
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Limpia los valores relacionados con el perfil
        editor.remove("AllInOneProduct");
        // Agrega otras claves que deseas limpiar

        // Aplica los cambios
        boolean commitResult = editor.commit();

        Log.d("SharedPreferences", "Limpiar AllInOneProduct: " + (commitResult ? "Éxito" : "Falló"));
    }
}

