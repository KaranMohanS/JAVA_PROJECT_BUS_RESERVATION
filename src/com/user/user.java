package com.user;


public class user{

    private int userId;
    private String userName;
    private int age;
    private String email;
    private Long phoneNumber;
    
    
    public user(int userId,String userName,int age,String email,Long phoneNumber)
    {
        this.userId=userId;
        this.userName=userName;
        this.age=age;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }


    public int getUserId() {
        return userId;
    }


    public String getUserName() {
        return userName;
    }

    
    public int getAge() {
        return age;
    }

    
    public String getEmail() {
        return email;
    }

    
    public Long getPhoneNumber() {
        return phoneNumber;
    }

    
    
    public String toString()
    {
        String str="";
        str+="USER ID: "+this.userId+"\n";
        str+="USER NAME: "+this.userName+"\n";
        str+="AGE: "+this.age+"\n";
        str+="EMAIL: "+this.email+"\n";
        str+="PHONE NUMBER: "+this.phoneNumber+"\n";
        return str;
    }

    
 
}