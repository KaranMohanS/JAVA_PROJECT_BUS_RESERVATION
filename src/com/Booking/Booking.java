package com.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Bus.bus;
import com.user.user;

public class Booking extends booking {

    private static final Map<String, List<booking>> m = new HashMap<>();

    public Booking(user u, bus b, int seatNO, String seatType, double cost) {
        super(u, b, seatNO, seatType, cost);
    }

    public Booking(int bID, user u, bus b, int seatNO, String seatType, double cost) {
        super(bID,u,b,seatNO,seatType,cost);
    }

    

    @Override

    public void confirmBooking() {
        System.out.println("Booking is Confirmed -->" + u.getName());
    }

    public static void addBooking(user u, bus b, int seatNO, double cost, String date, String seatType) {

        double gst = Booking.calculate(seatType);
        double totalcost = gst + cost;

        Booking b1 = new Booking(u, b, seatNO, seatType, totalcost);
        int bId = m.size() + 1;
        b1.setbID(bId);
        int numberOfSeats = b.getAvailableseat() - seatNO;
        b.setAvailableseat(numberOfSeats);
        if (m.get(date) == null) {
            m.put(date, new ArrayList<>());
        }

        List<booking> list = m.get(date);
        list.add(b1);
        m.put(date, list);

        b1.confirmBooking();

    }

    public static double calculate(String type) {
        switch (type) {
            case "normal":
                return 33;
            case "ac":
                return 50;
            default:
                break;
        }

        return 0;
    }

    public static void viewBokking() {
        for (Map.Entry<String, List<booking>> e : m.entrySet()) {
            System.out.println("Date: " + e.getKey());
            for (booking booking : e.getValue()) {
                System.out.println(booking);
            }
        }

    }
}
