package com.example.afinal.ui.carrito.elctrodomesticos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElectrodomesticoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElectrodomesticoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ElectrodomesticoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ElectrodomesticoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElectrodomesticoFragment newInstance(String param1, String param2) {
        ElectrodomesticoFragment fragment = new ElectrodomesticoFragment();
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
        View root = inflater.inflate(R.layout.fragment_electrodomestico, container, false);

        /*for (int i = 1; i <= 8; i++) {
            int buttonId = getResources().getIdentifier("btn" + i, "id", requireContext().getPackageName());

            // Verificar si el identificador de recurso es válido
            if (buttonId != 0) {
                Button promoButton = root.findViewById(buttonId);

                // Verificar si el botón se encuentra en el diseño y no es nulo
                if (promoButton != null) {
                    setButtonClickHandler(promoButton, root);
                } else {
                    // El botón no se encuentra en el diseño
                    Log.e("ElectrodomesticoFragment", "Button not found for id: " + buttonId);
                }
            } else {
                // Identificador de recurso no válido
                Log.e("ElectrodomesticoFragment", "Invalid resource identifier for button: btn" + i);
            }
        }*/

        Button Promo1 = root.findViewById(R.id.btn1);
        Promo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen1();
                }, 100);
            }
        });
        Button Promo2 = root.findViewById(R.id.btn2);
        Promo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen2();
                }, 100);
            }
        });

        Button Promo3 = root.findViewById(R.id.btn3);
        Promo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen3();
                }, 100);
            }
        });

        Button Promo4 = root.findViewById(R.id.btn4);
        Promo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen4();
                }, 100);
            }
        });

        Button Promo5 = root.findViewById(R.id.btn5);
        Promo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen5();
                }, 100);
            }
        });

        Button Promo6 = root.findViewById(R.id.btn6);
        Promo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen6();
                }, 100);
            }
        });

        Button Promo7 = root.findViewById(R.id.btn7);
        Promo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen7();
                }, 100);
            }
        });

        Button Promo8 = root.findViewById(R.id.btn8);
        Promo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(200);
                view.startAnimation(animation);

                new Handler().postDelayed(() -> {
                    showImagen8();
                }, 100);
            }
        });

        return root;
    }
    private AlertDialog alertDialog;

    private void showImagen1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog1();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog1() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Microondas Samsung");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    }
    private void showImagen2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog2();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog2() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Refrigeradoras LG");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    } private void showImagen3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog3();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog3() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Cocina A Gas");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    } private void showImagen4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog4();
                dialog.dismiss();
            }
        });
    }


    private void showQuantityDialog4() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Licuadora");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    } private void showImagen5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog5();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog5() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Cafetera automática");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    } private void showImagen6() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog6();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog6() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Arrocera multiusos");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    } private void showImagen7() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog7();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog7() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Waflera Antiadherente");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
    } private void showImagen8() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(R.layout.imagen9);

        final AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAccept = dialog.findViewById(R.id.btnComprar);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showQuantityDialog8();
                dialog.dismiss();
            }
        });
    }

    private void showQuantityDialog8() {
        // Infla el diseño XML personalizado para el cuadro de diálogo
        View customView = getLayoutInflater().inflate(R.layout.quantity_dialog, null);

        // Encuentra elementos del diseño XML en la vista personalizada
        final EditText quantityEditText = customView.findViewById(R.id.quantityEditText);
        Button buttonPagar = customView.findViewById(R.id.buttonPagar);
        Button buttonCancelar = customView.findViewById(R.id.buttonCancelar);
        Button buttonAumentar = customView.findViewById(R.id.buttonAumentar);
        Button buttonDisminuir = customView.findViewById(R.id.buttonDisminuir);

        // Configura la cantidad inicial
        int cantidad = 0;
        quantityEditText.setText(String.valueOf(cantidad));

        // Configura el clic del botón "Aumentar"
        buttonAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                cantidadActual++;
                quantityEditText.setText(String.valueOf(cantidadActual));
            }
        });

        // Configura el clic del botón "Disminuir"
        buttonDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidadActual = Integer.parseInt(quantityEditText.getText().toString());
                if (cantidadActual > 0) {
                    cantidadActual--;
                    quantityEditText.setText(String.valueOf(cantidadActual));
                }
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setView(customView);

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén la cantidad ingresada por el usuario
                String quantity = quantityEditText.getText().toString();

                if (quantity.isEmpty()) {
                    // Muestra un mensaje si el campo de cantidad está vacío
                    Toast.makeText(requireContext(), "Por favor, ingrese la cantidad de productos", Toast.LENGTH_SHORT).show();
                } else {
                    int cantidadNumerica = Integer.parseInt(quantity);

                    if (cantidadNumerica <= 0) {
                        // Muestra un mensaje si la cantidad es igual o menor que cero
                        Toast.makeText(requireContext(), "La cantidad de productos debe ser mayor que cero", Toast.LENGTH_SHORT).show();
                    } else {
                        // Lógica para calcular la cantidad total del producto (asumiendo un precio de 200)
                        int precioPorProducto = 200;
                        int cantidadTotal = cantidadNumerica * precioPorProducto;

                        // Guarda la información en SharedPreferences
                        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        // Utiliza un identificador único para cada producto (puedes ajustar esto según tu necesidad)
                        String productoId = "AllInOneProduct";

                        // Guarda el nombre del producto y la cantidad total en SharedPreferences
                        editor.putString(productoId + "_nombre", "Hornos empotrables");
                        editor.putInt(productoId + "_cantidad", cantidadNumerica);
                        editor.putInt(productoId + "_cantidadTotal", cantidadTotal);

                        // Aplica los cambios
                        editor.apply();

                        // Muestra el diálogo de compra satisfactoria
                        showPurchaseSuccessMessageCard();

                        // Cierra el cuadro de diálogo de cantidad de productos
                        alertDialog.dismiss();
                    }
                }
            }
        });


        // Configura la acción para el botón "Cancelar"
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra el cuadro de diálogo de cantidad de productos sin realizar ninguna acción
                alertDialog.dismiss();
            }
        });

        // Crear y mostrar el cuadro de diálogo
        alertDialog = builder.create();
        alertDialog.show();
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
        textExito.setText("¡Ralizar Guardado!");

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
                Toast.makeText(requireContext(), "Guardado en el carrito exitosamente", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }



    private void setButtonClickHandler(Button button, View root) {
        button.setOnClickListener(v -> {
            Animation animation = new AlphaAnimation(1.0f, 0.5f);
            animation.setDuration(200);
            v.startAnimation(animation);

            new Handler().postDelayed(() -> showToast(root), 100);
        });
    }

    private void showToast(View root) {
        Toast.makeText(root.getContext(), "Añadido 1 Producto al Carrito", Toast.LENGTH_SHORT).show();
    }}
