/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeldacon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ServerConnection {
    URL url;
    URLConnection con;
    private String address;
    public ServerConnection(String address){
        this.address = address;
    }
    
    public URLConnection getConnection(){
        try {
            url = new URL(address);
            con = url.openConnection();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    

}
