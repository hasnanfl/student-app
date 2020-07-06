package com.example.coba;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn,forgotTextLink;
    String su = "UserHelper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = findViewById(R.id.email_edt);
        mPassword = findViewById(R.id.pass_edt);
        mLoginBtn = findViewById(R.id.btn_login);
        mCreateBtn = findViewById(R.id.txtsignup);
        forgotTextLink = findViewById(R.id.forgot);

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             String email = mEmail.getText().toString();
                                             String pass = mPassword.getText().toString();

                                             if (TextUtils.isEmpty(email)) {
                                                 mEmail.setError("Email is Required.");
                                                 return;
                                             }

                                             if (TextUtils.isEmpty(pass)) {
                                                 mPassword.setError("Password is Required.");
                                                 return;
                                             }

                                             if (pass.length() < 6) {
                                                 mPassword.setError("Password Must be >= 6 Characters");
                                                 return;
                                             } else {
                                                 validateDetails(email, pass);
                                             }

                                         }
                                     }
        );
    }

    private void validateDetails(final String email, final String pass) {
        final DatabaseReference rootref;
        rootref = FirebaseDatabase.getInstance().getReference();
        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot signup : dataSnapshot.child("Signup").getChildren()) {
                    for (DataSnapshot signupItem : signup.getChildren()) {
                        if(email.equals(signupItem.getValue())) {
                            UserHelper userdata = signup.getValue(UserHelper.class);

                            if(userdata.getEmail().equals(email)){
                                if(userdata.getPass().equals(pass)){
                                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(getApplicationContext(), uta.class));
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }

                Toast.makeText(MainActivity.this, "Email doesn't exist", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Main", "onCancelled: " + databaseError.getMessage());
            }
        });
    }
}