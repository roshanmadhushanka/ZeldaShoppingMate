package DAO;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import Database.Server;

/**
 * Created by User on 4/3/2016.
 */
public class ItemDAO {
    public void read(Server.AsyncTaskCompleteListener listener, int id){
        String url = "http://ynot.esy.es/GetItemForList.php";
        List<NameValuePair> itemDetails = new ArrayList<NameValuePair>();
        itemDetails.add(new BasicNameValuePair("itemID", String.valueOf(id)));
        new Server().receiveFromServer(url, itemDetails, listener);
    }
}
