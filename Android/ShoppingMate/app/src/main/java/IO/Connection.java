package IO;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;

import com.example.user.shoppingmate.ContextObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by User on 3/8/2016.
 */
public class Connection {

    private String serverIP = "192.168.173.1";
    private final int port = 4444;
    private OnMessageReceived mMessageListener = null;
    private boolean mRun = false;
    String message = null;
    PrintWriter out;
    BufferedReader in;

    public Connection(OnMessageReceived listner){
        //Set listener to receive
        mMessageListener = listner;

    }

    public String GetServerIP(){
        return serverIP;
    }

    public int GetServerPort(){
        return port;
    }

    public void SendMessage(String message){
        if(out!=null && !out.checkError()){
            out.println(message);
            out.flush();
        }
    }

    public void StopClient(){
        mRun = false;
    }

    public void Run(){
        mRun = true;
        try{
            InetAddress serverAddress = InetAddress.getByName(serverIP);
            Log.e("TCP Client", "Client: Connecting....");
            Socket socket = new Socket(serverAddress, port);
            try{
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Log.e("TCP Client", "Client: Sent.");
                Log.e("TCP Client", "Client: Done.");

                while(mRun){
                    message = in.readLine();
                    if(message != null && mMessageListener != null){
                        mMessageListener.messageReceived(message);
                    }
                    message = null;
                }
                Log.e("RESPONSE FROM SERVER", "Server: Received message: '"+message+"'");
            }catch (Exception ex){
                Log.e("TCP", "Client: Error",ex);
            }finally {
                socket.close();
            }
        }catch (Exception ex){
            Log.e("TCP", "Client: Error",ex);
        }
    }

    public interface OnMessageReceived{
        public void messageReceived(String message);
    }

}
