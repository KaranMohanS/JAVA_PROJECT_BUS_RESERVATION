package com.Route;

public class route {

    

    private int routeID;
    private String sp;
    private String ep;
    private double distance;

    public route(int routeID, String sp, String ep, double cost) {
        this.routeID = routeID;
        this.sp = sp;
        this.ep = ep;
        this.distance = cost;
    }

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public double getCost() {
        return distance;
    }

    public void setCost(double cost) {
        this.distance = cost;
    }

    public String toString()
    {
        String str="";
        str+="ROUTE ID: "+this.routeID+"\n";
        str+="STRATING POINT: "+this.sp+"\n";
        str+="ENDING POINT: "+this.ep+"\n";
        str+="DISTANCE: "+this.distance+"KM\n";

        return str;

    }
}
