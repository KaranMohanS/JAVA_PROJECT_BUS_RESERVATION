package com.Route;

import java.util.ArrayList;
import java.util.List;

public class route {

    public static List<route> lr=new ArrayList<>();

    public  void addRoute(route r)
    {
        int id=lr.size()+1;
        r.setRouteID(id);
        lr.add(r);
    }

    public void viewRoute()
    {
        System.out.println(lr);
    }

    private int routeID;
    private String sp;
    private String ep;
    private double distance;
   

    public route(String sp, String ep, double distance, double cost) {
        //this.routeID = routeID;
        this.sp = sp;
        this.ep = ep;
        this.distance = distance;
       // this.cost=cost;
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public String toString()
    {
        String str="";
        str+="ROUTE ID: "+this.routeID+"\n";
        str+="STRATING POINT: "+this.sp+"\n";
        str+="ENDING POINT: "+this.ep+"\n";
        str+="DISTANCE: "+this.distance+"KM\n";
       // str+="COST: "+this.cost+"RS\n";

        return str;

    }
}
