package com.example.internetdata2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {
    List<Item> Items;

    public ItemsAdapter(List<Item> items) {
        Items = items;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout,parent,false);
        ItemsViewHolder itemsViewHolder = new ItemsViewHolder(view);
        return itemsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemsViewHolder holder, int position) {
        holder.itemName.setText(Items.get(position).getItemName());
        holder.itemPrice.setText(Items.get(position).getPrice()+"$");

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder{
        TextView itemName , itemPrice ;
        Button orderBtn ;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.name);
            itemPrice = itemView.findViewById(R.id.price);
            orderBtn = itemView.findViewById(R.id.orderBtn);
        }
    }
}
