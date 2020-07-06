package com.example.coba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class signup extends AppCompatActivity {
    EditText mFullName, mEmail, mPassword, mPhone, mTmpt_L, mTgl_L, mNPM, mPassC;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mNPM = findViewById(R.id.npm_edt);
        mTmpt_L = findViewById(R.id.tmpt_lhr_edt);
        mTgl_L = findViewById(R.id.tgl_lhr_edt);
        mFullName = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.email_edt);
        mPassword = findViewById(R.id.pass_edt);
        mPassC = findViewById(R.id.passc_edt);
        mPhone = findViewById(R.id.no_hp_edt);
        mRegisterBtn = findViewById(R.id.btn_daftar);
        mLoginBtn = findViewById(R.id.txtlogin);

        //login
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
            });

        //save data in firebase button click
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference("Signup");

                //get all the values

                String npm = mNPM.getText().toString();
                String tpmt_lhr = mTmpt_L.getText().toString();
                String tgl_lhr = mTgl_L.getText().toString();
                String f_nm = mFullName.getText().toString();
                String email = mEmail.getText().toString();
                String pass = mPassword.getText().toString();
                String passC = mPassC.getText().toString();
                String no_hp = mPhone.getText().toString();

                UserHelper helperClass = new UserHelper(npm, tpmt_lhr, tgl_lhr, f_nm, pass, passC, email, no_hp);
                reference.child(no_hp).setValue(helperClass);

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required");
                    return;
                }

                else if (TextUtils.isEmpty(pass)) {
                    mPassword.setError("Password is Required");
                    return;
                }

                else if(!pass.equals(passC)){
                    mPassC.setError("Password doesn't match!");
                    return;
                }
                else if (TextUtils.isEmpty(npm)) {
                    mNPM.setError("Must be filled");
                    return;
                }

                else if (pass.length() < 6) {
                    mPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                else{
                    validdateDetails(npm, tpmt_lhr, tgl_lhr, f_nm, email, pass, passC, no_hp);
                }

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });
    }

    private void validdateDetails(final String npm, final String tpmt_lhr, final String tgl_lhr,  final String f_nm, final String email, final String pass, final String passC, final String no_hp) {

        final DatabaseReference rootref;
        rootref = FirebaseDatabase.getInstance().getReference();
        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Signup").child(npm).exists())){
                    HashMap <String,Object> userdatamap = new HashMap<>();
                    userdatamap.put("NPM", npm);
                    userdatamap.put("Tempat Lahir", tpmt_lhr);
                    userdatamap.put("Tangal Lahir", tgl_lhr);
                    userdatamap.put("Nama Lengkap", f_nm);
                    userdatamap.put("Email", email);
                    userdatamap.put("No. Hp", no_hp);
                    userdatamap.put("Password", pass);
                    userdatamap.put("Konfirmasi Password", passC);

                    rootref.child("Signup").child(npm).updateChildren(userdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(signup.this, "Sign Up has been successfull", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}