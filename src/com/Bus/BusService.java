package com.Bus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.App;
import com.Route.RouteService;
import com.Route.route;

public class BusService {

    public static String path = "bus.txt";

    public static void addBus() {
        System.out.println("Enter Bus Id");
        int busId = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Bus Name");
        String busName = App.scan.nextLine();

        System.out.println("Enter Bus Capacity");
        int busCapcity = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Bus Available Seats");
        int busAvailableSeats = App.scan.nextInt();
        App.scan.nextLine();

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
        if (r == null) {
            System.out.println("Invalid Route ID");
            return;
        }
        bus bus = new bus(busId, busName, busCapcity, busAvailableSeats, r);
        addBus(bus);
    }

    public static void addBus(bus b) {
        File file = new File(path);
        route r = b.getRe();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {

            bufferedWriter.write(b.getBusID() + "," + b.getBusName() + "," + b.getCapcity() + "," + b.getAvailableseat()
                    + "," + r.getRouteID() + "," + r.getSp() + "," +r.getStartTime()+","+ r.getEp() +r.getEndTime()+","+ "," + r.getDistance()
                    + System.lineSeparator());
            System.out.println("Bus added successfully.");
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("Error writing bus: " + e.getMessage());
        }
    }

    public static void viewBuses()
    {
        File file=new File(path);
        int line;
        try (FileReader fileReader=new FileReader(file)) {

            while ((line=fileReader.read())!=-1) {
                
                System.out.print((char)line);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
