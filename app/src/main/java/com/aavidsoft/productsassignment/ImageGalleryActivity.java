package com.aavidsoft.productsassignment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ImageGalleryActivity extends AppCompatActivity {

    private RecyclerView recyclerImages;
    private int[] imageIds = {
            R.drawable.default_product,
            R.drawable.product_1,
            R.drawable.product_2,
            R.drawable.product_3,
            R.drawable.product_4,
            R.drawable.default_product,
            R.drawable.product_1,
            R.drawable.product_2,
            R.drawable.product_3,
            R.drawable.product_4,
            R.drawable.default_product,
            R.drawable.product_1,
            R.drawable.product_2,
            R.drawable.product_3,
            R.drawable.product_4
    };

    private ProductImagesAdapter productImagesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_gallery_activity);

        init();
    }

    private void init() {
        recyclerImages = findViewById(R.id.recyclerImages);
        recyclerImages.setLayoutManager(
                new GridLayoutManager(this, 3)
        );

        productImagesAdapter = new ProductImagesAdapter(imageIds);

        productImagesAdapter.setOnProductImageClickListener(
                new MyOnProductImageClickListener()
        );

        recyclerImages.setAdapter(productImagesAdapter);
    }

    class MyOnProductImageClickListener implements ProductImagesAdapter.OnProductImageClickListener {
        @Override
        public void onProductImageClick(int imageId, int position) {
            Intent resIntent = new Intent();
            resIntent.putExtra("image_id", imageId);
            setResult(1, resIntent);

            finish();
        }
    }
}
