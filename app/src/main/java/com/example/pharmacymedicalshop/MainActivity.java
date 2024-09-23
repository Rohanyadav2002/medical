package com.example.pharmacymedicalshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    RecyclerView productView;
    List<Product_Model> product_modelList;
    Product_Adapter product_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database=FirebaseFirestore.getInstance();
        productView=findViewById(R.id.productrec);
        //productView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false));
        product_modelList = new ArrayList<>();
        Product_Adapter adapter=new Product_Adapter(getApplicationContext(), product_modelList);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);

        // at last set adapter to recycler view.
        productView.setLayoutManager(layoutManager);
        productView.setAdapter(adapter);
        //  product_adapter = new Product_Adapter(getApplicationContext(),product_modelList);
        // productView.setAdapter(product_adapter);


        database.collection("Product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult() ){
                                Product_Model product_model = document.toObject(Product_Model.class);
                                product_modelList.add(product_model);
                                // product_adapter.notifyDataSetChanged();
                                adapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }
}