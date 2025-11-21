package com.example.afinal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.afinal.R;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder> {

    private List<Producto> listaProductos;

    public ProductoAdapter(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);

        // Actualiza la interfaz de usuario con la información del producto
        holder.nombreTextView.setText(producto.getNombre());
        holder.cantidadTextView.setText("Cantidad: " + String.valueOf(producto.getCantidad()));
        holder.cantidadTotalTextView.setText("Cantidad Total: " + String.valueOf(producto.getCantidadTotal()));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreTextView;
        public TextView cantidadTextView;
        public TextView cantidadTotalTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.textNombre);
            cantidadTextView = itemView.findViewById(R.id.textCantidad);
            cantidadTotalTextView = itemView.findViewById(R.id.textCantidadTotal);
        }
    }
}
