package Security;

import android.os.AsyncTask;

import com.android.volley.toolbox.HttpClientStack;

import java.net.URL;

import DTO.UserDTO;

/**
 * Created by User on 3/29/2016.
 */
public abstract class LoginTrack {
    private static UserDTO currentUser;

    public static void startSession(UserDTO userDTO){
        currentUser = userDTO;
    }

    public static void destroySession(){
        currentUser = null;
    }

    public static boolean isValid(){
        if(currentUser != null){
            return true;
        }else{
            return false;
        }
    }

    public static UserDTO getCurrentUser(){
        return currentUser;
    }


}
