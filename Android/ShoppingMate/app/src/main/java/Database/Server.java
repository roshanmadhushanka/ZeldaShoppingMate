package Database;

import android.app.Activity;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import java.util.List;


/**
 * Created by User on 3/31/2016.
 */
public class Server{
    public void sendToServer(String url, List<NameValuePair> details){
        new Send().execute(url, details);
    }

    public void receiveFromServer(String url, List<NameValuePair> details, AsyncTaskCompleteListener listener){
        new Receive(listener).execute(url, details);
    }

    private class Send extends AsyncTask<Object, Void, String>{

        @Override
        protected String doInBackground(Object... params) {
            //Header url
            String url = (String)params[0];

            //Parameters
            List<NameValuePair> details = (List<NameValuePair>)params[1];

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

        @Override
        protected void onPostExecute(String result) {
            if(result.equals("success")){
                System.out.println("Success");
            }
        }
    }

    private class Receive extends AsyncTask<Object, Void, JSONArray>{

        private AsyncTaskCompleteListener listener;
        public Receive(AsyncTaskCompleteListener listener){
            this.listener = listener;
        }
        @Override
        protected JSONArray doInBackground(Object... params) {
            //Header url
            String url = (String)params[0];

            //Parameters
            List<NameValuePair> details = (List<NameValuePair>)params[1];

            HttpEntity httpEntity= null;
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            try {
                httpPost.setEntity(new UrlEncodedFormEntity(details));
                HttpResponse httpResponse = httpClient.execute(httpPost);
                httpEntity=httpResponse.getEntity();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONArray jsonArray = null;

            if(httpEntity!=null){
                String entityResponse;
                try {
                    entityResponse = EntityUtils.toString(httpEntity);
                    jsonArray = new JSONArray(entityResponse);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return jsonArray;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            if(jsonArray != null){
                //Pass received json array to the AsyncTaskCompleteListener
                listener.onTaskComplete(jsonArray);
            }
        }
    }

    public interface AsyncTaskCompleteListener{
        //This method will be called by Data Access Objects
        public void onTaskComplete(JSONArray jsonArray);
    }
}




