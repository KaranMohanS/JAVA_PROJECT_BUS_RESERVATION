package com.Bus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.App;
import com.Route.route;

public class bus {

    public static List<bus> lb = new ArrayList<>();

    public void addBus(bus bus) {
        lb.add(bus);
    }

    public static void viewBus() {
        for (bus x : lb) {
            System.out.println(x);
        }
    }

    public static void getBus(int busID) throws Exception {
        boolean found = false;

        for (bus x : lb) {
            if (x.getBusID() == busID) {
                found = true;
                System.out.println(x);
                break;
            }
        }

        if (!found) {
            throw new Exception("Invalid bus ID" + busID);
        }
    }

    public static void updateBus() throws Exception {
        System.out.println("enter bus id");
        int id = App.scan.nextInt();
        App.scan.nextLine();
        boolean found = false;

        for (bus x : lb) {
            if (x.getBusID() == id) {
                found = true;

                System.out.println("enter update option| 1 busname | 2 capacity | 3 availableseat ");
                int option = App.scan.nextInt();
                App.scan.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("enter new bus name");
                        String name = App.scan.nextLine();
                        x.setBusName(name);
                        break;
                    case 2:
                        System.out.println("enter new bus capcity");
                        int capacity = App.scan.nextInt();
                        App.scan.nextLine();
                        x.setCapcity(capacity);
                        break;
                    case 3:
                        System.out.println("enter new available seat");
                        int seat = App.scan.nextInt();
                        App.scan.nextLine();
                        x.setAvailableseat(seat);
                        break;

                    default:
                        throw new Exception("Invalid option: " + option);
                }
                break;
            }
        }
        if (!found) {
            throw new Exception("Invalid bus ID" + id);
        }
    }

    public static void deletedBus(int id) throws Exception {
        boolean found = false;

        Iterator<bus> iterator = lb.iterator();

        while (iterator.hasNext()) {

            bus b = iterator.next();

            if (b.getBusID() == id) {
                found = true;
                iterator.remove();
                System.out.println("bus deleted");
                break;
            }
        }
        if (!found) {
            throw new Exception("Invalid Bus ID" + id);
        }
    }

    public static void checkAvailableSeats(int id) {
        boolean found = false;

        for (bus x : lb) {
            if (x.getBusID() == id) {
                System.out.println("Available Seats:" + x.getAvailableseat());
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid Bus ID: " + id);
        }
    }

    // -----------------------------------------
    private int busID;
    private String busName;
    private int capcity;
    private int availableseat;
    private route re;

    public bus(int busID, String busName, int capcity, int availableseat, route re) {
        this.busID = busID;
        this.busName = busName;
        this.capcity = capcity;
        this.availableseat = availableseat;
        this.re = re;
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

    public String toString() {
        String str = "";

        str += "BUS ID: " + this.busID + "\n";
        str += "BUS NAME: " + this.busName + "\n";
        // str += "CAPACITY: " + this.capcity + "\n";
        // str += "AVAILABLE SEAT: " + this.availableseat + "\n";
        str += "BUS ROUTE: " + re.toString() + "\n";
        return str;
    }

}