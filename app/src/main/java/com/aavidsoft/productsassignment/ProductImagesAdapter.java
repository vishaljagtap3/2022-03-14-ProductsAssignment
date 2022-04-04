package com.aavidsoft.productsassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductImagesAdapter extends RecyclerView.Adapter<ProductImagesAdapter.ProductImageViewHolder> {

    private int [] imageIds;

    public interface OnProductImageClickListener {
        public void onProductImageClick(int imageId, int position);
    }

    private OnProductImageClickListener onProductImageClickListener;
    public void setOnProductImageClickListener(OnProductImageClickListener onProductImageClickListener) {
        this.onProductImageClickListener = onProductImageClickListener;
    }


    public ProductImagesAdapter(int[] imageIds) {
        this.imageIds = imageIds;
    }

    class ProductImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;

        public ProductImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = (ImageView) itemView;

            imgProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onProductImageClickListener != null) {
                        onProductImageClickListener.onProductImageClick(
                                imageIds[getAdapterPosition()],
                                getAdapterPosition()
                        );
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }

    @NonNull
    @Override
    public ProductImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductImageViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_image, null)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductImageViewHolder holder, int position) {
        holder.imgProduct.setImageResource( imageIds[position] );
    }
}
