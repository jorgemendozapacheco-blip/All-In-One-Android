package com.example.afinal.ui.carrito;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.Producto;
import com.example.afinal.ProductoAdapter;
import com.example.afinal.R;
import java.util.ArrayList;
import java.util.List;

public class CarritoFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductoAdapter productoAdapter;
    private List<Producto> listaProductos;
private Button irPagar;
    // ... Otros métodos y variables

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrito, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        listaProductos = new ArrayList<>();
        productoAdapter = new ProductoAdapter(listaProductos);

        // Configura el RecyclerView y el adaptador
        recyclerView.setAdapter(productoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        irPagar = view.findViewById(R.id.btnMetodoPago);
        irPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = new AlphaAnimation(1.0f, 0.5f);
                animation.setDuration(300);
                view.startAnimation(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cargarMetodoPagoFragment();
                    }
                }, 300);
            }
        });

        // Recupera la información de SharedPreferences y actualiza el RecyclerView
        cargarProductosDesdeSharedPreferences();

        return view;
    }

    private void cargarMetodoPagoFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigate(R.id.action_nav_carrito_to_PagarFragment);
        cargarProductosDesdeSharedPreferences();
    }

    // Método para cargar productos desde SharedPreferences
    private void cargarProductosDesdeSharedPreferences() {
        // Limpia la lista de productos
        listaProductos.clear();
        // Recupera la información almacenada en SharedPreferences
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("productos", Context.MODE_PRIVATE);
        String productoId = "AllInOneProduct";

        String nombre = sharedPreferences.getString(productoId + "_nombre", "");
        int cantidad = sharedPreferences.getInt(productoId + "_cantidad", 0);
        int cantidadTotal = sharedPreferences.getInt(productoId + "_cantidadTotal", 0);

        // Crea una instancia de Producto y agrégala a la lista
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCantidad(cantidad);
        producto.setCantidadTotal(cantidadTotal);

        listaProductos.add(producto);

        // Notifica al adaptador que los datos han cambiado
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Código para actualizar el RecyclerView aquí
                productoAdapter.notifyDataSetChanged();
            }
        });

    }
}
