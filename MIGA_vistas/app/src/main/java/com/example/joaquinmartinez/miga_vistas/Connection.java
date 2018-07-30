package com.example.joaquinmartinez.miga_vistas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connection {

    private Context context;

    public Connection(Context context) {
        this.context = context;
    }

    public boolean getConnection() {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null)
            return true;
        return false;
    }
}
