package com.example.proyecto01fabio;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    Connection connection;
    String ip, port, database;
    @SuppressLint("NewApi")

    public Connection connectionclass(){
        ip = "localhost";
        database = "Proyecto01Fabio";
        port = "1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://192.168.1.18:"+port+";databasename="+database+";user=sa;password=admin;";
            System.out.println("Aqui " + ConnectionURL);
            connection = DriverManager.getConnection(ConnectionURL);
        }catch(Exception ex){
            Log.e("Error", ex.getMessage());
        }
        System.out.println("CONNECTIONNNNNN"+connection);
        return connection;
    }
}
