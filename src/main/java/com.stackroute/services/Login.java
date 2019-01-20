package com.stackroute.services;

public class Login {
    DatabaseConnection databaseConnection ;
    private String username;
    private String password;

    public Login(String username,String password){
        databaseConnection = new DatabaseConnection();
        this.username = username;
        this.password = password;
        databaseConnection.InsertData(this.username,this.password);
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
