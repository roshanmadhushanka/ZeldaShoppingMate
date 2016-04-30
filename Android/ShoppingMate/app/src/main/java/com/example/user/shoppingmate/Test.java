package com.example.user.shoppingmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import Database.Server;

public class Test extends AppCompatActivity {

    Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        btnTest = (Button) findViewById(R.id.btnTestTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://ynot.esy.es/test.php";
                List<NameValuePair> itemDetails = new ArrayList<NameValuePair>();
                itemDetails.add(new BasicNameValuePair("testString", "Roshab"));
                new Server().sendToServer(url, itemDetails);
            }
        });
    }
}
