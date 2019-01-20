package com.stackroute.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    Login login;
    private Connection con;

    public void InsertData(String username, String password) {
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            //create connection here login is database name, aishwarya is username and aishwarya is password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "aishwarya", "aishwarya");
            //create statement object
            System.out.println("got connected");
            //PreparedStatement
            String query = " insert into login (username,password)" + " values (?,?)";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, username);
            preparedStmt.setString(2, password);
            // execute the preparedstatement
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
