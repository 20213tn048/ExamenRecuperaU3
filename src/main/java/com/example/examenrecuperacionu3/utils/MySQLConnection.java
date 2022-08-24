package com.example.examenrecuperacionu3.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamenRecupera","root","root");
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main (String []args){
        try{
            Connection con = MySQLConnection.getConnection();
            if (con != null){
                System.out.println("Conectado");
                con.close();
            }else{
                System.out.println("No conectado");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
