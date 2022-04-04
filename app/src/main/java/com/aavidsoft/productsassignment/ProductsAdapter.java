package com.aavidsoft.productsassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private ArrayList<Product> productsList;

    public ProductsAdapter(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProduct;
        TextView txtProductTitle, txtProductPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtProductTitle = itemView.findViewById(R.id.txtProductTitle);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_view, null);

        ProductViewHolder productViewHolder = new ProductViewHolder(view);

        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = productsList.get(position);

        holder.imgProduct.setImageResource(product.getImageId());
        holder.txtProductTitle.setText(product.getTitle());
        holder.txtProductPrice.setText("INR " + product.getPrice());
    }

}
