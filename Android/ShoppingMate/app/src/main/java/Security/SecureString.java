package Security;


import android.text.Editable;
import android.util.Base64;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * Created by User on 3/12/2016.
 */
public abstract class SecureString {

    public static String Encrypt(String s) {
        byte[] data = new byte[0];
        try {
            data = s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            String base64Encoded = Base64.encodeToString(data, Base64.DEFAULT);
            return base64Encoded;

        }
    }

    public static String Decrypt(String s) {
        byte[] dataDec = Base64.decode(s, Base64.DEFAULT);
        String decodedString = "";
        try {
            decodedString = new String(dataDec, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {

            return decodedString;
        }
    }
}

