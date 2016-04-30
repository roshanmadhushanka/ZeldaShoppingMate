package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.user.shoppingmate.ContextObject;

/**
 * Created by User on 3/12/2016.
 */
public class DBHelper extends SQLiteOpenHelper{
    //User Account Table
    public final static String TABLE_USER = "user";
    public final static String USER_ID = "id";
    public final static String USER_NAME = "user_name";
    public final static String USER_PASSWORD = "password";
    public final static String USER_EMAIL = "email";
    public final static String USER_MOBILE_NUMBER = "mobile_number";

    private final static String DATABASE_NAME = "shopping_mate";
    private final static int DATABASE_VERSION = 2;

    //Create User Table Query
    private final static String CREATE_USER_TABLE = "create table if not exists user (id integer primary key autoincrement, user_name VARCHAR not null, password VARCHAR not null, email VARCHAR not null, mobile_number VARCHAR not null);";

    //Create purchase table
    private final static String CREATE_PURCHASE_TABLE = "";


    //Singleton Database Access
    private static DBHelper dbObject = null;

    private DBHelper() {
        super(ContextObject.GetContext(), DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION);
        Log.d("Database", "Created!");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        Log.d("DB", "Account table created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static DBHelper GetDBHelper(){
        if(dbObject == null){
            dbObject = new DBHelper();
        }
        return dbObject;
    }
}
