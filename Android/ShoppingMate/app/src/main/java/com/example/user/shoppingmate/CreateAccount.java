package com.example.user.shoppingmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DAO.UserDAO;
import DTO.UserDTO;
import Security.SecureString;
import Validation.Validator;

public class CreateAccount extends AppCompatActivity {

    EditText txtUserName;
    EditText txtPassword;
    EditText txtConfirmPassword;
    EditText txtEmail;
    EditText txtMobileNumber;

    Button btnSignUp;

    public void signUp(){
        //Validator
        if(!Validator.userName(txtUserName.getText().toString())){
            return;
        }

        if(!Validator.password(txtPassword.getText().toString(), txtConfirmPassword.getText().toString())){
            return;
        }

        if(!Validator.mobileNumber(txtMobileNumber.getText().toString())){
            return;
        }

        //Create user data transfer object
        UserDTO userDTO = new UserDTO(txtUserName.getText().toString(), SecureString.Encrypt(txtPassword.getText().toString()), txtEmail.getText().toString()  , txtMobileNumber.getText().toString());

        //Add user to the database
        UserDAO userDAO = new UserDAO();
        userDAO.insert(userDTO);

        //Clear fields
        txtUserName.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtEmail.setText("");
        txtMobileNumber.setText("");

        //Display login form
        Intent intent = new Intent(ContextObject.GetContext() , Login.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //EditText
        txtUserName = (EditText) findViewById(R.id.txtCreateAccountUserName);
        txtPassword = (EditText) findViewById(R.id.txtCreateAccountPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.txtCreateAccountConfirmPassword);
        txtEmail = (EditText) findViewById(R.id.txtCreateAccountEmail);
        txtMobileNumber = (EditText) findViewById(R.id.txtCreateAccountAccountNumber);

        //Button
        btnSignUp = (Button) findViewById(R.id.btnCreateAccountSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

}
