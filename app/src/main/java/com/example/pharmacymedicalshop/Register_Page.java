package com.example.pharmacymedicalshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register_Page extends AppCompatActivity {
    EditText email,password,name,number,pincode,localatity,city,state,landmark,alternativephone;
    Button registerbtn;
    FirebaseDatabase database;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.useremail);
        password=findViewById(R.id.userpassword);
        name=findViewById(R.id.username);
        number=findViewById(R.id.usernumber);
        pincode=findViewById(R.id.userpincode);
        localatity=findViewById(R.id.userlocality);
        city=findViewById(R.id.userdistric);
        state=findViewById(R.id.userstate);
        landmark=findViewById(R.id.userlandmark);
        alternativephone=findViewById(R.id.useralternatvenumber);
        registerbtn=findViewById(R.id.userregisterbtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usercreate();


            }
        });


    }

    private void usercreate() {
        String useremail = email.getText().toString();
        String userpassword = password.getText().toString();
        String username = name.getText().toString();
        String usernumber = number.getText().toString();
        String userpincode = pincode.getText().toString();
        String userlocality = localatity.getText().toString();
        String usercity = city.getText().toString();
        String userstate = state.getText().toString();
        String userlandmark = landmark.getText().toString();
        String useralternativenumber = alternativephone.getText().toString();
        if (TextUtils.isEmpty(useremail)){
            Toast.makeText(getApplicationContext(), "Email is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(userpassword)){
            Toast.makeText(getApplicationContext(), "Password is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(username)){
            Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(usernumber)){
            Toast.makeText(getApplicationContext(), "Number is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(userpincode)){
            Toast.makeText(getApplicationContext(), "Pin Code is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(userlocality)){
            Toast.makeText(getApplicationContext(), "Locality is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(usercity)){
            Toast.makeText(getApplicationContext(), "City is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(userstate)){
            Toast.makeText(getApplicationContext(), "State is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(userlandmark)){
            Toast.makeText(getApplicationContext(), "LandMark is Empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(useralternativenumber)){
            Toast.makeText(getApplicationContext(), "Alternative Mobile Number is Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            auth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        UserData usermodel = new UserData(useremail,userpassword,username,usernumber,userpincode,userlocality,usercity,userstate,userlandmark,useralternativenumber);
                        String id = task.getResult().getUser().getUid();
                        database.getReference().child("User").child(id).setValue(usermodel);
                        Toast.makeText(getApplicationContext(), "Register is Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register_Page.this,Login_Page.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Register is Failed", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }



    }
}