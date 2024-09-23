package com.example.pharmacymedicalshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

public class Delete_Product extends AppCompatActivity {
    RecyclerView productView;
    List<Productmodel> product_modelList;
    ProductAdapter product_adapter;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        productView=findViewById(R.id.productrec);
        productView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        product_modelList = new ArrayList<>();
        product_adapter = new ProductAdapter(getApplicationContext(),product_modelList);
        productView.setAdapter(product_adapter);

        database.collection("Product")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult() ){
                                Productmodel product_model = document.toObject(Productmodel.class);
                                product_modelList.add(product_model);
                                // product_adapter.notifyDataSetChanged();
                                product_adapter.notifyDataSetChanged();
                            }
                        }else {
                            Toast.makeText(getApplication(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }
}