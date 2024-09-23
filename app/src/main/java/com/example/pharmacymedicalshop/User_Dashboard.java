package com.example.pharmacymedicalshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class User_Dashboard extends AppCompatActivity {
CardView medicien,mycart,myorder,feedback,logout,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        medicien=findViewById(R.id.medicien);
        mycart=findViewById(R.id.mycart);
        myorder=findViewById(R.id.myorder);
        feedback=findViewById(R.id.ufeedback);
        logout=findViewById(R.id.userlogout);
        profile=findViewById(R.id.profile);

profile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(User_Dashboard.this,Profile.class);
        startActivity(intent);
    }
});
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(User_Dashboard.this, Login_Page.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,User_Feedback.class);
                startActivity(intent);
            }
        });

myorder.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(User_Dashboard.this,My_Order.class);
        startActivity(intent);
    }
});
mycart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(User_Dashboard.this,My_Cart.class);
        startActivity(intent);
    }
});
        medicien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_Dashboard.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}