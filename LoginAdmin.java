package com.android.letsgetplaced;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAdmin extends AppCompatActivity {
ImageView ivLoginAdmin;
TextView tvLogoAdmin,tvUsernameAdmin,tvPasswordAdmin;
EditText etUsernameAdmin,etPasswordAdmin;
Button btnLoginAdmin;
    private FirebaseAuth firebaseAuth;
    Context context;
    ProgressBar Pg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        context=getApplicationContext();
        FirebaseApp.initializeApp(context);
        ivLoginAdmin=(ImageView)findViewById(R.id.ivLoginAdmin);
        tvLogoAdmin=(TextView)findViewById(R.id.tvLogoAdmin);
        tvUsernameAdmin=(TextView)findViewById(R.id.tvUsernameAdmin);
        tvPasswordAdmin=(TextView)findViewById(R.id.tvPasswordAdmin);
        etUsernameAdmin=(EditText)findViewById(R.id.etUsernameAdmin);
        etPasswordAdmin=(EditText)findViewById(R.id.etPasswordAdmin);
        btnLoginAdmin=(Button)findViewById(R.id.btnLoginAdmin);
        Pg=(ProgressBar)findViewById(R.id.pg);
        firebaseAuth=FirebaseAuth.getInstance();
        Pg.setVisibility(View.GONE);
       btnLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent i=new Intent(LoginAdmin.this,AdminActivity.class);
                startActivity(i);
                Pg.setVisibility(View.VISIBLE);
                String e=etUsernameAdmin.getText().toString().trim();
                if(!Patterns.EMAIL_ADDRESS.matcher(e).matches() || e.length()==0)
                {
                    etUsernameAdmin.setError("Invalid Username");
                    etUsernameAdmin.requestFocus();
                    return;
                }
                String p=etPasswordAdmin.getText().toString().trim();
                if(p.length()==0)
                {
                    etPasswordAdmin.setError("Invalid Password");
                    etPasswordAdmin.requestFocus();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginAdmin.this, "Sign In successful", Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(LoginAdmin.this,MainActivity.class);
                            startActivity(i);
                            Pg.setVisibility(View.GONE);
                            finish();

                        }
                        else
                        {
                            Toast.makeText(LoginAdmin.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
                            Pg.setVisibility(View.GONE);
                       }
                    }
                });
            }
        });}}








