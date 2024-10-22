package com.Bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Seat.seat;

public class bus {
    

    public   Map<String,List<bus>> m=new HashMap<>();

    
    int busId;
    String name;
    long busPH;
    String type;
    String destination;
    List<seat> seat;
    String time;
    String date;

    
    public bus(int busId, String name, long busPH, String type, String destination, List<seat> seat,String time) {
        this.busId = busId;
        this.name = name;
        this.busPH = busPH;
        this.type = type;
        this.destination = destination;
        this.seat = seat;
        this.time=time;
    }

    
    public Map<String, List<bus>> getM() {
        return m;
    }


    public void setM(Map<String, List<bus>> m) {
        this.m = m;
    }


    public int getBusId() {
        return busId;
    }


    public void setBusId(int busId) {
        this.busId = busId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public long getBusPH() {
        return busPH;
    }


    public void setBusPH(long busPH) {
        this.busPH = busPH;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getDestination() {
        return destination;
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }


    public List<seat> getSeat() {
        return seat;
    }


    public void setSeat(List<seat> seat) {
        this.seat = seat;
    }


    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString()
    {
         String str="";
         str+="BUS ID: "+this.busId+"\n";
         str+="BUS NAME: "+this.name+"\n";
         str+="BUS PHONE NUMBER: "+this.busPH+"\n";
         str+="TYPE: "+this.type+"\n";
         str+="DESTINATION: "+this.destination+"\n";
         str+="SEAT: "+this.seat.toString()+"\n";
         str+="BUS TIME: "+this.time;
         return str;
    }
    


    
    public void addbus(int busID,String name,Long busPH,String type,String destination,List<seat>seat,String date,String time)
    {

        bus b1=new bus(busID, name, busID, type, destination,seat,time);

        if(this.m.get(date)==null)
        {
            m.put(date,new ArrayList<bus>());
        }

        List<bus> b=this.m.get(date);
        b.add(b1);
        this.m.put(date, b);
    }

    public  void buslist()
    {
        for(Map.Entry<String,List<bus>> entry:m.entrySet())
        {
            System.out.println(entry);
            System.out.println("---------------------------------------------");

        }
    }





}
