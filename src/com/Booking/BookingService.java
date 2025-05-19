package com.Booking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.App;
import com.Bus.BusService;
import com.Bus.bus;
import com.Route.RouteService;
import com.Route.route;
import com.user.user;
import com.user.userService;

public class BookingService {

    public static String path = "booking.txt";

    public static void addBooking() {

        System.out.println("Enter Booking Id");
        int bookID = App.scan.nextInt();
        App.scan.nextLine();

        // ------------------------------------------------- user
        File userFile = new File(userService.path);
        user u=null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile))) {

            System.out.println("Enter User ID");
            int uID = App.scan.nextInt();
            App.scan.nextLine();

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");

                if (Integer.parseInt(arr[0]) == uID) {
                    u = new user(Integer.parseInt(arr[0]), arr[1], Long.parseLong(arr[2]), arr[3]);
                    break;
                }
            }
            bufferedReader.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        //------------------------------------------------------ route
        File file = new File(RouteService.path);
        route r = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            System.out.println("Enter Route Id");
            int routeID = App.scan.nextInt();
            App.scan.nextLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");

                if (Integer.parseInt(arr[0]) == routeID) {
                    r = new route(Integer.parseInt(arr[0]), arr[1], arr[2],arr[3],arr[4], Double.parseDouble(arr[5]));
                    break;
                }
            }
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println("Error writing bus: " + e.getMessage());

        }
        // -------------------------------------------------- bus

        File busFile=new File(BusService.path);
        bus b=null;

        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(busFile))) {
            String line;

            System.out.println("Enter Bus ID");
            int bID=App.scan.nextInt();
            App.scan.nextLine();

            while ((line=bufferedReader.readLine())!=null) {
                String[] brr=line.split(",");

                if(Integer.parseInt(brr[0])==bID)
                {
                    b=new bus(Integer.parseInt(brr[0]),brr[1],Integer.parseInt(brr[2]),Integer.parseInt(brr[3]), r);
                    break;
                }
            }
            bufferedReader.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("Enter Your Seat Number");
        int sNO=App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Your Seat Type");
        String sType=App.scan.nextLine();

        System.out.println("Enter Cost");
        double cost=App.scan.nextDouble();
        App.scan.nextLine();

        Booking booking=new Booking(bookID, u, b, sNO, sType, cost);
        addBooking(booking);

    }

    public static void addBooking(Booking booking) {

        File file = new File(path);

        user u=booking.getU();
        bus b=booking.getB();
        route r=b.getRe();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            bufferedWriter.write(booking.getbID() + "," + u.getUID() + "," + u.getName() + "," + u.getContect() + ","
                    + u.getEmail() + "," + b.getBusID() + "," + b.getBusName() + "," + b.getCapcity() + ","
                    + b.getAvailableseat()
                    + "," + r.getRouteID() + "," + r.getSp() + "," + r.getStartTime() + "," + r.getEp() + ","
                    + r.getEndTime() + "," + r.getDistance()
                    + "," + booking.getSeatNO() + "," + booking.getSeatType() + "," + booking.getCost() + "\n");

            System.out.println("Booking added successfully.");
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing booking: " + e.getMessage());
        }
    }
}
