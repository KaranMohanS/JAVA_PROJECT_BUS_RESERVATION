package com.user;

public class user {
    
    int id;
    String name;
    int age;
    String email;
    long ph;
    String address;


    public user(int id,String name,int age,String email,long ph,String address)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.email=email;
        this.ph=ph;
        this.address=address;
    }

    public String toString()
    {
        String str="";

        str+="USER ID: "+this.id+"\n";
        str+="USER NAME: "+this.name+"\n";
        str+="USER AGE: "+this.age+"\n";
        str+="EMAIL: "+this.email+"\n";
        str+="PHONE NUMBER: "+this.ph+"\n";
        str+="ADDRESS: "+this.address+"\n";
        return str;
    }
}
