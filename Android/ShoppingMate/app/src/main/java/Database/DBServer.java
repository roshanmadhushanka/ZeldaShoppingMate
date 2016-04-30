package Database;

import android.util.Log;
import android.widget.Toast;

import com.example.user.shoppingmate.ContextObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import DTO.UserDTO;

/**
 * Created by User on 3/29/2016.
 */
public class DBServer {
    InputStream inputStream;

    public String insertUser(UserDTO userDTO){
        String url = "http://ynot.esy.es/AddUser.php";
        String result = "fail";

        List<NameValuePair> userDetails = new ArrayList<NameValuePair>();
        userDetails.add(new BasicNameValuePair("userName", userDTO.getUserName()));
        userDetails.add(new BasicNameValuePair("password", userDTO.getPassword()));
        userDetails.add(new BasicNameValuePair("email", userDTO.getEmail()));
        userDetails.add(new BasicNameValuePair("mobileNumber", userDTO.getMobileNumber()));

        HttpEntity httpEntity= null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(userDetails));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            httpEntity=httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String sendToServer(String url, List<NameValuePair> details){
        String result = "fail";

        HttpEntity httpEntity= null;
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(details));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            httpEntity=httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
