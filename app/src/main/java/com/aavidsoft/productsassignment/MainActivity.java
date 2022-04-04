package com.aavidsoft.productsassignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerProducts;
    private ArrayList<Product> productsList;
    private ProductsAdapter productsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuAddProduct) {
            //start add product activity
            startAddProductActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void startAddProductActivity() {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivityForResult(intent, 1);
    }

    private void init() {
        recyclerProducts = findViewById(R.id.recyclerProducts);
        recyclerProducts.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );

        productsList = new ArrayList<Product>();

        productsAdapter = new ProductsAdapter(productsList);
        recyclerProducts.setAdapter(productsAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data != null) {
            Product newProduct = (Product) data.getSerializableExtra("product");
            productsList.add(newProduct);
            productsAdapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}