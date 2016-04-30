package com.example.user.shoppingmate;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DAO.UserDAO;
import DTO.UserDTO;
import Database.DBServer;
import Database.Server;
import Security.LoginTrack;

public class MainMenu extends AppCompatActivity{

    Button btnBuyMore, btnPurchaseHistory, btnMyAccount, btnExit;
    UserDTO userDTO;
    Animation animTranslate;

    public void showBuyMoreForm(View v){
        v.startAnimation(animTranslate);

        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , PurchaseForm.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    public void showPurchaseHistoryForm(View v){
        v.startAnimation(animTranslate);
        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , PurchaseHistoryPlot.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    public void showMyAccountForm(View v){
        v.startAnimation(animTranslate);
        if(LoginTrack.isValid()){
            Intent intent = new Intent(ContextObject.GetContext() , MyAccount.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(ContextObject.GetContext() , Login.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Buttons
        btnBuyMore = (Button) findViewById(R.id.btnMainMenuBuyMore);
        btnPurchaseHistory = (Button) findViewById(R.id.btnMainMenuPurchaseHistory);
        btnMyAccount = (Button) findViewById(R.id.btnMainMenuMyAccount);
        btnExit = (Button) findViewById(R.id.btnMainMenuExit);

        //Button animation
        animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);

        btnBuyMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBuyMoreForm(v);
            }
        });

        btnPurchaseHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPurchaseHistoryForm(v);
            }
        });

        btnMyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyAccountForm(v);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animTranslate);
            }
        });
    }


}
