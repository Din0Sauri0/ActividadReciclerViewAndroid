package com.ovalle.actividadreciclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class productoAdapter extends RecyclerView.Adapter<productoAdapter.viewHolderDatos> {
    Context context;
    ArrayList<producto> productoList;

    public productoAdapter(Context context, ArrayList<producto> productoList) {
        this.context = context;
        this.productoList = productoList;
    }

    @NonNull
    @Override
    public viewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_simple_items,parent,false);
        return new viewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderDatos holder, int position) {
        holder.txtRecycler.setText(productoList.get(position).getNombre());
        holder.txtCantidadRecycler.setText(productoList.get(position).getDescripcion());
        holder.btnRecycler.setText(productoList.get(position).getCantidad());
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class viewHolderDatos extends RecyclerView.ViewHolder {
        TextView txtRecycler, txtCantidadRecycler;
        Button btnRecycler;
        public viewHolderDatos(@NonNull View itemView) {
            super(itemView);
            txtRecycler = itemView.findViewById(R.id.txtRecycler);
            txtCantidadRecycler = itemView.findViewById(R.id.txtCantidadRecycler);
            btnRecycler = itemView.findViewById(R.id.btnRecycler);
        }
    }
}
