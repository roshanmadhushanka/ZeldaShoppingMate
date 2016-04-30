package com.example.user.shoppingmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;

import DAO.UserDAO;
import Database.Server;

public class MainActivity extends AppCompatActivity {

    Button btnStart;

    public void start(){
        new UserDAO().count(new Server.AsyncTaskCompleteListener() {
            @Override
            public void onTaskComplete(JSONArray jsonArray) {
                int count = 0;
                try {
                    count = jsonArray.getJSONObject(0).getInt("count");
                    if(count == 0){
                        //No users available -> Create a new user
                        Intent intent = new Intent(ContextObject.GetContext() , CreateAccount.class);
                        startActivity(intent);
                    }else{
                        //LoginTrack to existing account
                        Intent intent = new Intent(ContextObject.GetContext() , Login.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Context
        ContextObject.SetContext(this.getBaseContext());

        //Button
        btnStart = (Button) findViewById(R.id.btnMainStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
    }
}

