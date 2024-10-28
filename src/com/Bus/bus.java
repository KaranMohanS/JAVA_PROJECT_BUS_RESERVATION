package com.Bus;


public class bus{

    private int busId;
    private String busName;
    private int capacity;
    private String route;
    private boolean isSeatAvailable;


    public bus(int busId,String busName,int capacity,String route)
    {

        this.busId=busId;
        this.busName=busName;
        this.capacity=capacity;
        this.route=route;
        this.isSeatAvailable=true;
    }


    public int getBusId() {
        return busId;
    }


    public String getBusName() {
        return busName;
    }


    public int getCapacity() {
        return capacity;
    }


    public String getRoute() {
        return route;
    }


    public boolean isSeatAvailable() {
        return isSeatAvailable;
    }
    

    public String toString()
    {
        String str="";
        str+="BUS ID: "+this.busId+"\n";
        str+="BUS NAME: "+this.busName+"\n";
        str+="CAPACITY: "+this.capacity+"\n";
        str+="ROUTE: "+this.route+"\n";
        str+="ISAVAILABLE: "+this.isSeatAvailable+"\n";
        System.out.println("--------------------------------");
        return str;
    }

    
}