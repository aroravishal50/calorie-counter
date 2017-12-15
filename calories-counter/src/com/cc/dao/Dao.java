/**
 * File - Dao.java
 * Date - 4 Dec 2017
 * Version - 0.3
 * Prof. - Douglas King
 * Project - Calorie Counter
 * **/

package com.cc.dao;

import java.sql.Connection;  
import java.sql.DriverManager;

/**Data Access Object-> This creates a single connection used by multiple classes**/
public class Dao {
    public static Connection getConnection() {    
    	Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "client";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);
           
        } catch (Exception e) {
            System.out.println(e);
        } 
        
        return conn;
    }
}