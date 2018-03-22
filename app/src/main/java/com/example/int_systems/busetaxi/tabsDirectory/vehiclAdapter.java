package com.example.int_systems.busetaxi.tabsDirectory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.int_systems.busetaxi.R;

import java.util.List;

/**
 * Created by Int-Systems on 3/22/2018.
 */
public class vehiclAdapter extends RecyclerView.Adapter <vehiclAdapter.ProductViewHolder> {

    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<taxiVehicle> productList;

    //getting the context and product list with constructor
    public vehiclAdapter(Context mCtx, List<taxiVehicle> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.driverlist, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(vehiclAdapter.ProductViewHolder holder, int position) {
        //getting the product of the specified position
        taxiVehicle product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();

    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = (TextView)itemView.findViewById(R.id.textViewShortDesc);
            textViewRating =(TextView) itemView.findViewById(R.id.textViewRating);
            textViewPrice =(TextView) itemView.findViewById(R.id.textViewPrice);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }
}
