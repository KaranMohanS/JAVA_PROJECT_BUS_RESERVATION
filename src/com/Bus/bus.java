package com.Bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bus {
    

    public static  Map<String,List<bus>> m=new HashMap<>();

    
    int busId;
    String name;
    long busPH;
    String type;
    String location;

    public bus(int busId,String name,long busPH,String type)
    {
        this.busId=busId;
        this.name=name;
        this.busPH=busPH;
        this.type=type;
    }  



    @Override

    public String toString()
    {
         String str="";
         str+="BUS ID: "+this.busId+"\n";
         str+="BUS NAME: "+this.name+"\n";
         str+="BUS PHONE NUMBER: "+this.busPH+"\n";
         str+="TYPE: "+this.type+"\n";
         str+="LOCATION: "+this.location+"\n";
         return str;
    }

    public static  bus addbus(int busId,String name,long busPH,String type,String location)
    {
        bus b=new bus(busId, name, busPH, type);

        if(m.get(location) != null)
        {
            m.put(location, new ArrayList<bus>());
        }

        List<bus> bb=m.get(location);
        bb.add(b);
        m.put(location, bb);
        return b;
    }


}
