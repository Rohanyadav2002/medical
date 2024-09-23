package com.example.pharmacymedicalshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Admin_Login extends AppCompatActivity {
EditText email,password;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        email=findViewById(R.id.ademail);
        password=findViewById(R.id.adpassword);
        button=findViewById(R.id.adminlogin);

        String pemail = email.getText().toString();
        String ppassword = password.getText().toString();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Admin_Dashboard.class);
                intent.putExtra(pemail,"admin@gmail.com");
                intent.putExtra(ppassword,"12345678");
                startActivity(intent);
            }
        });
    }
}