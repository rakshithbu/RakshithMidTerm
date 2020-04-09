package com.example.rakshithmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_activity extends AppCompatActivity implements View.OnClickListener {

    EditText user, pass;
    Button login;
    int count = 0; //a class level variable to count the number of failed login trials

    //to move the an object or variable to another activity it must be static
    static EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPassword);
        name = findViewById(R.id.txtPerson);
        login = findViewById(R.id.btnLog);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("inside onclick listener");
        if(name.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter name", Toast.LENGTH_LONG).show();
        }else{

            if(user.getText().toString().equalsIgnoreCase("student1") && pass.getText().toString().equals("123456"))
            {
                //create an intent object using the name of the activity you want to move to
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                count++; //counting the failed login trials
            }


        }
    }
}
