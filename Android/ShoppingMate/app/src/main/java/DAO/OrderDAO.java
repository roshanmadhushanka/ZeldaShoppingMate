package DAO;

import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import DTO.OrderDTO;
import Database.Server;

/**
 * Created by User on 4/17/2016.
 */
public class OrderDAO {


    public void insert(OrderDTO orderDTO){
        List<NameValuePair> orderDetails = new ArrayList<>();
        orderDetails.add(new BasicNameValuePair("userId", String.valueOf(orderDTO.getUserId())));
        orderDetails.add(new BasicNameValuePair("itemList", orderDTO.getItemListToJsonArray().toString()));
        orderDetails.add(new BasicNameValuePair("totalAmount", String.valueOf(orderDTO.getTotalAmt())));
        System.out.println(orderDetails.toString());
        return;
    }

    public void read(Server.AsyncTaskCompleteListener listner){

    }
}
