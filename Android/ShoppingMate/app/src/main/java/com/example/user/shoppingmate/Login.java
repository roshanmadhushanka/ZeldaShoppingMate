package com.example.user.shoppingmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import DAO.UserDAO;
import DTO.UserDTO;
import Database.Server;
import Security.LoginTrack;
import Security.SecureString;
import Security.LoginTrack;

public class Login extends AppCompatActivity {

    EditText txtUserName, txtPassword;
    Button btnLogin, btnCreateAccount;

    public void Login(){
        if (txtUserName.length() != 0 && txtPassword.length() != 0) {
            String encryptPassword = SecureString.Encrypt(txtPassword.getText().toString());

            new UserDAO().read(new Server.AsyncTaskCompleteListener() {
                @Override
                public void onTaskComplete(JSONArray jsonArray) {
                    UserDTO userDTO = new UserDTO();
                    try {
                        //Add active user details
                        userDTO.setId(jsonArray.getJSONObject(0).getInt("id"));
                        userDTO.setUserName(jsonArray.getJSONObject(0).getString("name"));
                        userDTO.setPassword(jsonArray.getJSONObject(0).getString("password"));
                        userDTO.setEmail(jsonArray.getJSONObject(0).getString("email"));
                        userDTO.setMobileNumber(jsonArray.getJSONObject(0).getString("mobile_number"));

                        //Set Current Session
                        LoginTrack.startSession(userDTO);
                        Toast.makeText(ContextObject.GetContext(), "LoginTrack Success", Toast.LENGTH_LONG).show();

                        //Clear text fields
                        txtUserName.setText("");
                        txtPassword.setText("");

                        //Navigate to main menu
                        if (LoginTrack.isValid()) {
                            Intent intent = new Intent(ContextObject.GetContext(), MainMenu.class);
                            startActivity(intent);
                        }

                    } catch (JSONException e) {
                        //Display error for un authentic access
                        Toast.makeText(ContextObject.GetContext(), "LoginTrack Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }, txtUserName.getText().toString(), encryptPassword);
        } else {
            //Display error for invalid type of login details
            Toast.makeText(ContextObject.GetContext(), "LoginTrack incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //EditText
        txtUserName = (EditText) findViewById(R.id.txtLoginUserName);
        txtPassword = (EditText) findViewById(R.id.txtLoginPassword);

        //Button
        btnLogin = (Button) findViewById(R.id.btnLoginLogin);
        btnCreateAccount = (Button) findViewById(R.id.btnLoginCreateAccount);

        btnCreateAccount.requestFocus();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContextObject.GetContext() , CreateAccount.class);
                startActivity(intent);
            }
        });
    }
}
