package DAO;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import DTO.UserDTO;
import Database.DBHelper;
import Database.Server;

/**
 * Created by User on 3/14/2016.
 */
public class UserDAO{
    private DBHelper dbHelper;
    public UserDAO(){
        dbHelper = DBHelper.GetDBHelper();
    }

    public void insert(UserDTO userDTO){
        String url = "http://ynot.esy.es/AddUser.php";

        List<NameValuePair> userDetails = new ArrayList<NameValuePair>();
        userDetails.add(new BasicNameValuePair("userName", userDTO.getUserName()));
        userDetails.add(new BasicNameValuePair("password", userDTO.getPassword()));
        userDetails.add(new BasicNameValuePair("email", userDTO.getEmail()));
        userDetails.add(new BasicNameValuePair("mobileNumber", userDTO.getMobileNumber()));

        new Server().sendToServer(url, userDetails);
    }

    public void read(Server.AsyncTaskCompleteListener listener){
        String url = "http://ynot.esy.es/GetUsers.php";

        List<NameValuePair> userDetails = new ArrayList<NameValuePair>();
        userDetails.add(new BasicNameValuePair("None", "None"));

        new Server().receiveFromServer(url, userDetails, listener);
    }

    public void read(Server.AsyncTaskCompleteListener listener, String name, String password){
        String url = "http://ynot.esy.es/GetUser.php";

        List<NameValuePair> userDetails = new ArrayList<NameValuePair>();
        userDetails.add(new BasicNameValuePair("userName", name));
        userDetails.add(new BasicNameValuePair("password", password));

        new Server().receiveFromServer(url, userDetails, listener);
    }

    public void count(Server.AsyncTaskCompleteListener listener){
        String url = "http://ynot.esy.es/GetUserCount.php";

        List<NameValuePair> userDetails = new ArrayList<NameValuePair>();
        userDetails.add(new BasicNameValuePair("None", "None"));

        new Server().receiveFromServer(url, userDetails, listener);
    }
}
