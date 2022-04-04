package com.aavidsoft.productsassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity  {

    private ImageView imgProduct;
    private EditText edtProductId, edtProductTitle, edtProductPrice, edtProductDescription;
    private Button btnAddProduct;

    private int productImageId = R.drawable.default_product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product_activity);

        init();
        setUpListeners();

    }

    private void setUpListeners() {
        btnAddProduct.setOnClickListener(new BtnAddProductClickListener());
        imgProduct.setOnClickListener(new ImgProductClickListener());
    }

    private class ImgProductClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AddProductActivity.this, ImageGalleryActivity.class);
            startActivityForResult(intent, 1);
        }
    }

    private class BtnAddProductClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Product newProduct = new Product(
                    Integer.parseInt(edtProductId.getText().toString()),
                    edtProductTitle.getText().toString(),
                    Integer.parseInt(edtProductPrice.getText().toString()),
                    edtProductDescription.getText().toString(),
                    productImageId
            );

            Intent resultIntent = new Intent();
            resultIntent.putExtra("product", newProduct);

            setResult(1, resultIntent);
            finish();
        }
    }

    private void init() {
        imgProduct = findViewById(R.id.imgProduct);

        edtProductId = findViewById(R.id.edtProductId);
        edtProductTitle = findViewById(R.id.edtProductTitle);
        edtProductPrice = findViewById(R.id.edtProductPrice);
        edtProductDescription = findViewById(R.id.edtProductDescription);

        btnAddProduct = findViewById(R.id.btnAddProduct);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            productImageId = data.getIntExtra("image_id", -1);
            imgProduct.setImageResource(productImageId);
        }
    }
}
