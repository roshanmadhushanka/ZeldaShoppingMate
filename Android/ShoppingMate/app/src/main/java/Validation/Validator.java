package Validation;

import android.widget.Toast;

import com.example.user.shoppingmate.ContextObject;

import org.w3c.dom.Text;

/**
 * Created by User on 3/25/2016.
 */
public abstract class Validator {
    
    public static boolean userName(String name){
        if(name.length() != 0){
            return true;
        }
        Toast.makeText(ContextObject.GetContext(), "User name cannot be null", Toast.LENGTH_SHORT).show();
        return false;
    }

    public static boolean password(String pass, String confirmPass){
        if(pass.equals(confirmPass) && pass.length() > 6){
            return true;
        }
        Toast.makeText(ContextObject.GetContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
        return false;
    }

    public static boolean mobileNumber(String number){
        if(number.length() == 10){
            return true;
        }
        Toast.makeText(ContextObject.GetContext(), "Invalid number", Toast.LENGTH_SHORT).show();
        return false;
    }
}
