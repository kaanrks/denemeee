package com.example.btrm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.btrm.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private FirebaseAuth auth;


///seniseviyorum
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
    }

    public void signInClicked(View view){
        String email = binding.emailText.getText().toString();
        String password = binding.passwordText.getText().toString();

            if (email.equals("") || password.equals("")) {
        Toast.makeText(this, "Enter a valid email and password", Toast.LENGTH_SHORT).show();
    } else {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent intent= new Intent(MainActivity.this, FF.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }}

    public void signUpClicked(View view){

            String email = binding.emailText.getText().toString();
            String password = binding.passwordText.getText().toString();

            if (email.equals("") || password.equals("")) {
                Toast.makeText(this, "Enter a valid email and password", Toast.LENGTH_SHORT).show();
            } else {
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent intent= new Intent(MainActivity.this, FF.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });

// hellllooooooooo
        }

    }
}
