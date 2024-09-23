package com.example.pharmacymedicalshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.WriteBatch;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    Context context;
    List<Productmodel> productmodelList;
    FirebaseFirestore firebaseFirestore;

    public ProductAdapter(Context context, List<Productmodel> productmodelList) {
        this.context = context;
        this.productmodelList = productmodelList;
        firebaseFirestore=FirebaseFirestore.getInstance();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_detail,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(productmodelList.get(position).getUri()).into(holder.imageView);
        holder.name.setText(productmodelList.get(position).getName());
        holder.description.setText(productmodelList.get(position).getDescription());
        holder.offer.setText(productmodelList.get(position).getOffer());
        holder.type.setText(productmodelList.get(position).getType());
        holder.rate.setText(String.valueOf(productmodelList.get(position).getRate()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseFirestore.collection("Product").whereEqualTo("delete","0")
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                WriteBatch batch = FirebaseFirestore.getInstance().batch();
                                List<DocumentSnapshot> doc = queryDocumentSnapshots.getDocuments();
                                for (DocumentSnapshot snapshot:doc){
                                    batch.delete(snapshot.getReference());
                                }
                                batch.commit()
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(context, "Delete ", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return productmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,description,offer,rate,type;
        ImageView imageView;
        ImageView delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            description=itemView.findViewById(R.id.description);
            offer=itemView.findViewById(R.id.offer);
            rate=itemView.findViewById(R.id.rate);
            type=itemView.findViewById(R.id.type);
            imageView=itemView.findViewById(R.id.imageview);
            delete=itemView.findViewById(R.id.deleteproduct);




        }
    }
}
