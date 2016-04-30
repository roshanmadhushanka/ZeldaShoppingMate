package DTO;

/**
 * Created by User on 3/14/2016.
 */
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String mobileNumber;

    //Default Constructor
    public UserDTO(){

    }

    //Save user constructor
    public UserDTO(String userName, String password, String email, String mobileNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    //Read user constructor
    public UserDTO(int id, String userName, String password, String email, String mobileNumber) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
