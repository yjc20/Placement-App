package com.android.letsgetplaced;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginpageActivity extends AppCompatActivity {
TextView tvLogo,tvUsername,tvPassword;
Button btnLoginStudent,btnForgotPassword,btnNewAccount,btnAdminLogin;
EditText etUsername,etPassword;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        tvLogo = (TextView) findViewById(R.id.tvLogo);
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        btnLoginStudent = (Button) findViewById(R.id.btnLoginStudent);
        btnForgotPassword = (Button) findViewById(R.id.btnForgotPassword);
        btnNewAccount = (Button) findViewById(R.id.btnNewAccount);
        btnAdminLogin = (Button) findViewById(R.id.btnAdminLogin);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etUsername=(EditText)findViewById(R.id.etUsername);
        firebaseAuth = FirebaseAuth.getInstance();

        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i=new Intent(LoginpageActivity.this,LoginAdmin.class);
            startActivity(i);

            }
        });
        btnLoginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username=etUsername.getText().toString().trim();
                if(!Patterns.EMAIL_ADDRESS.matcher(username).matches() || username.length()==0)
                {
                    etUsername.setError("Enter registered email id");
                    etUsername.requestFocus();
                    return;
                }
                String password=etPassword.getText().toString().trim();
                if(password.length()==0)
                {
                    etPassword.setError("Invalid Password");
                    etPassword.requestFocus();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(LoginpageActivity.this, "Sign In successful", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(LoginpageActivity.this,MainActivity.class);
                            startActivity(i);


                            finish();

                        }
                        else
                        {
                            Toast.makeText(LoginpageActivity.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        btnNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginpageActivity.this,SignuppageActivity.class);
                startActivity(i);
            }
        });
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginpageActivity.this,Forgotpassword.class);
                startActivity(i);
            }
        });



    }
}
