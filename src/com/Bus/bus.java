package com.Bus;

import java.util.ArrayList;
import java.util.List;

import com.Route.route;

public class bus {

    public static List<bus> lb=new ArrayList();

    public void addBus(bus b)
    {
        lb.add(b);
    }



    private int busID;
    private String busName;
    private int capcity;
    private int availableseat;
    route re;

    public bus(int busID,String busName,int capcity,int availableseat,route re)
    {
       this.busID=busID;
       this.busName=busName;
       this.capcity=capcity;
       this.availableseat=availableseat;
       this.re=re;
    }

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getCapcity() {
        return capcity;
    }

    public void setCapcity(int capcity) {
        this.capcity = capcity;
    }

    public int getAvailableseat() {
        return availableseat;
    }

    public void setAvailableseat(int availableseat) {
        this.availableseat = availableseat;
    }

    public route getRe() {
        return re;
    }

    public void setRe(route re) {
        this.re = re;
    }


    public String toString()
    {
        String str="";

        str+="BUS ID: "+this.busID+"\n";
        str+="BUS NAME: "+this.busName+"\n";
        str+="CAPACITY: "+this.capcity+"\n";
        str+="AVAILABLE SEAT: "+this.availableseat+"\n";
        str+="BUS ROUTE: "+re.toString()+"\n";
        return str;
    }




}