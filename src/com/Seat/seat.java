package com.Seat;

public class seat {
    
    String seatId;
    Boolean isavailable;

    public seat(String seatId)
    {
        this.seatId=seatId;
        this.isavailable=true;
    }

    public String toString()
    {
        String str="";
        str+="SEAT ID: "+this.seatId+"\n";
        str+="AVAILABLE: "+this.isavailable;
        return str;
    }


}
