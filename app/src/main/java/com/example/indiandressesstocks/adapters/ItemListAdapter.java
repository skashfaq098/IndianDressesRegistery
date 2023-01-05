package com.example.indiandressesstocks.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiandressesstocks.R;
import com.example.indiandressesstocks.model.ItemsObject;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    // variable for our array list and context.
    private ArrayList<ItemsObject> ItemList;
    private Context context;

    // creating a constructor.
    public ItemListAdapter(ArrayList<ItemsObject> ItemList, Context context) {
        this.ItemList = ItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.itemlist_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // getting data from our array list in our modal class.
        ItemsObject itemListModal = ItemList.get(position);

        // on the below line we are setting data to our text view.
        holder.itemName.setText(itemListModal.getItemName());
        holder.itemPrice.setText(itemListModal.getItemPrice());
        holder.itemQty.setText(itemListModal.getItemQty());

        // on below line we are loading our image from the URL
        // in our image view using Picasso.

    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return ItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private TextView itemName, itemPrice, itemQty;
        private ImageView userIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // initializing our variables.
            itemName = itemView.findViewById(R.id.idTVItemName);
            itemPrice = itemView.findViewById(R.id.idTVItemPrice);
            itemQty = itemView.findViewById(R.id.idTVQty);
//            userIV = itemView.findViewById(R.id.idIVUser);
        }
    }
}
