package com.stackroute.services;

import java.sql.*;

public class DatabaseConnection {
    Login login;
    private Connection con;
    private String result;

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
    public String getUserName(String username,String password) {
        try {
            //Resister Driver with driver manager service
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");//create connection
            //here db1 is database name, root is username and root123 is password
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login", "aishwarya", "aishwarya");
            //create statement object
            System.out.println("got connected");
            Statement stmt = con.createStatement();
            //execute query
            ResultSet rs = stmt.executeQuery("select username from login where password='"+password+"' and username='"+username+"'");
            //process result
            while (rs.next()) {
                System.out.println(rs.getString(1));
                result = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
