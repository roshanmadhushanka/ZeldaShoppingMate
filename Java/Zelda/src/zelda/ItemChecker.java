/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zelda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URLConnection;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import zeldacon.ServerConnection;

/**
 *
 * @author User
 */
public class ItemChecker {
    public enum Flag{
        COMMUNICATION_ERROR, PAID, NOT_PAID
    }
    
    private ServerConnection serverConnection;
    private URLConnection con;
    PrintStream ps = null; 
    
    public ItemChecker(){
        serverConnection = new ServerConnection("http://ynot.esy.es/CheckItemStatus.php");
    }
    
    public Flag isPaid(String id){
        con = serverConnection.getConnection();
        if(con != null){
            con.setDoOutput(true);
            try {
                ps = new PrintStream(con.getOutputStream());
                ps.print("itemID=" + id);
                
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    if(line.length() > 0){
                        switch (line) {
                            case "U":
                                InputStream aud_in = new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\Zelda\\src\\resources\\Beep.wav");
                                AudioStream as = new AudioStream(aud_in);
                                AudioPlayer.player.start(as);
                                return Flag.NOT_PAID;
                            case "P":
                                return Flag.PAID;
                        }
                    }
                }        
            } catch (IOException ex) {
            } finally{
                ps.close();
            }
        }
        return Flag.COMMUNICATION_ERROR;
    }
}
