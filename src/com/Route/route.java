package com.Route;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import com.App;

public class route {

    public static List<route> lr = new ArrayList<>();

    public void addRoute(route r) {
        int id = lr.size() + 100;
        r.setRouteID(id);
        lr.add(r);
    }

    public static void viewRoute() {
        for (route x : lr) {
            System.out.println(x);
        }
    }

    public static void getRoute(int n) {
        boolean find = false;
        for (route x : lr) {
            if (x.getRouteID() == n) {
                System.out.println(x);
                find = true;
                break;
            }
        }
        if (!find) {
            System.out.println("Route ID Not Available: " + n);
        }
    }

    public static void updateRoute(int n) throws Exception {
        boolean find = false;

        for (route x : lr) {
            if (x.getRouteID() == n) {
                find = true;

                System.out.println("Enter your option| 1 start point | 2 ending point | 3 distance ");
                int option = App.scan.nextInt();
                App.scan.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("enter your new starting point");
                        String startPoint = App.scan.nextLine();
                        x.setSp(startPoint);
                        break;

                    case 2:

                        System.out.println("enter your new ending point");
                        String endPoint = App.scan.nextLine();
                        x.setEp(endPoint);
                        break;

                    case 3:

                        System.out.println("enter your new distance");
                        double distance = App.scan.nextDouble();
                        App.scan.nextLine();
                        x.setDistance(distance);
                        break;

                    default:
                        throw new Exception("invalid option" + option);
                }
                break;
            }
        }
        if (!find) {
            throw new Exception("invalid route id" + n);
        }
    }

    public static void deleteRoute(int n) {

        Iterator<route> iterator = lr.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            route x = iterator.next();
            if (x.getRouteID() == n) {
                iterator.remove(); // Safe removal
                found = true;
                System.out.println("Route deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Route not found.");
        }
    }
    // -------------------------------------------------

    private int routeID;
    private String sp;
    private String startTime;
    private String ep;
    private String endTime;
    private double distance;
    private String date;

    public route(String sp, String ep, double distance) {
        // this.routeID = routeID;
        this.sp = sp;
        this.ep = ep;
        this.distance = distance;
        // this.cost=cost;
    }
    
    public route(int routeID, String sp, String startTime, String ep, String endTime, double distance) {
        this.routeID = routeID;
        this.sp = sp;
        this.startTime = startTime;
        this.ep = ep;
        this.endTime = endTime;
        this.distance = distance;
    }

    public route(int routeID, String sp, String startTime, String ep, String endTime, double distance, String date) {
        this.routeID = routeID;
        this.sp = sp;
        this.startTime = startTime;
        this.ep = ep;
        this.endTime = endTime;
        this.distance = distance;
        this.date=date;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String toString() {
        String str = "";
        str += "ROUTE ID: " + this.routeID + "\n";
        str += "STRATING POINT: " + this.sp + "\n";
        str += "ENDING POINT: " + this.ep + "\n";
        str += "DISTANCE: " + this.distance + "KM\n";
        // str+="COST: "+this.cost+"RS\n";

        return str;

    }
}
