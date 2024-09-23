package com.example.pharmacymedicalshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Admin_Dashboard extends AppCompatActivity {
CardView upload,allorder,feed,delete,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        upload=findViewById(R.id.uploadmed);
        allorder=findViewById(R.id.totalorder);
        feed =findViewById(R.id.myfeed);
        delete=findViewById(R.id.detoduct);
        logout=findViewById(R.id.adminlogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Admin_Dashboard.this, Login_Page.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Admin_Dashboard.this,Delete_Product.class);
        startActivity(intent);
    }
});
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Dashboard.this,All_Feedback.class);
                startActivity(intent);
            }
        });
allorder.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Admin_Dashboard.this,All_Order.class);
        startActivity(intent);
    }
});
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Dashboard.this,Upload.class);
                startActivity(intent);
            }
        });
    }
}