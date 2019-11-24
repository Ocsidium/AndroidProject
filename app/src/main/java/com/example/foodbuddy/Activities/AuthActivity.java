package com.example.foodbuddy.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodbuddy.Data.DatabaseHandler;
import com.example.foodbuddy.Model.Grocery;
import com.example.foodbuddy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AuthActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "AuthActivity";
    private DatabaseHandler db;
    private List<Grocery> groceryList;

    private EditText email;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);


        db = new DatabaseHandler(this);
        email = (EditText) findViewById(R.id.emailEd);
        password = (EditText) findViewById(R.id.passwordEd);
        login = (Button) findViewById(R.id.loginBtn);

        mAuth = FirebaseAuth.getInstance();
        db = new DatabaseHandler(this);
        groceryList = new ArrayList<>();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user != null){
                    //signed in
                    Log.d(TAG, "User Signed in");
                } else {
                    //signed out
                    Log.d(TAG, "User Signed out");
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();

                if  (!emailString.equals("") && !passwordString.equals("")) {
                    mAuth.signInWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(AuthActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (!task.isSuccessful()){
                                Toast.makeText(AuthActivity.this, "Sync Unsuccessful", Toast.LENGTH_LONG).show();
                            } else{
                                Toast.makeText(AuthActivity.this, "Sync Successful", Toast.LENGTH_LONG).show();

                                groceryList = db.getAllGroceries();

                                if (groceryList.size() > 0){

                                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Grocery");
                                    for(Grocery c : groceryList){
                                        databaseReference.push().setValue(c);
                                    }

                                }
                            }
                            finish();
                        }
                    });
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
