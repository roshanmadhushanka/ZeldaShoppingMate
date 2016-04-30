package com.example.user.shoppingmate;

import android.content.Context;

/**
 * Created by User on 3/8/2016.
 */
public class ContextObject {
    static Context ctx;

    public static void SetContext(Context ctx){
        ContextObject.ctx = ctx;
    }

    public static Context GetContext(){
        return ctx;
    }
}
