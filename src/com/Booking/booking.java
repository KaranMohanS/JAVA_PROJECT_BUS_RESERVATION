package com.Booking;
import com.Bus.bus;
import com.user.user;

public abstract class booking {

    protected int bID;
    protected user u;
    protected bus b;
    protected int seatNO;
    protected String seatType;
    protected double cost;

    public booking(user u, bus b, int seatNO, String seatType, double cost) {
        // this.bID = bID;
        this.u = u;
        this.b = b;
        this.seatNO = seatNO;
        this.seatType = seatType;
        this.cost = cost;
    }

    // public abstract void addBooking(user u, bus b, int seatNO, double cost,
    // String date, String seatType);

    public booking(int bID, user u, bus b, int seatNO, String seatType, double cost) {
        this.bID = bID;
        this.u = u;
        this.b = b;
        this.seatNO = seatNO;
        this.seatType = seatType;
        this.cost = cost;
    }

    public abstract void confirmBooking();

    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }

    public user getU() {
        return u;
    }

    public void setU(user u) {
        this.u = u;
    }

    public bus getB() {
        return b;
    }

    public void setB(bus b) {
        this.b = b;
    }

    public int getSeatNO() {
        return seatNO;
    }

    public void setSeatNO(int seatNO) {
        this.seatNO = seatNO;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toString() {
        String str = "";
        str += "BOOKING ID: " + this.bID + "\n";
        str += "PASSANGER DETAILS: [" + this.u.toString() + "]\n";
        str += "BUS DETAILS: [" + this.b.toString() + "]\n";
        str += "NUMBER OF SEATS: " + this.seatNO + "\n";
        str += "SEAT TYPE: " + this.seatType + "\n";
        str += "COST: " + this.cost + "\n";

        return str;
    }

}
