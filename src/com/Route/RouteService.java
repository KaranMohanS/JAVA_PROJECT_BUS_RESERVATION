package com.Route;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


import com.App;

public class RouteService {

    public static String path = "route.txt";

    public static void addRoute() {
        System.out.println("Enter Route ID");
        int routeID = App.scan.nextInt();
        App.scan.nextLine();

        System.out.println("Enter Starting Point");
        String StartingPoint = App.scan.nextLine();

        System.out.println("Enter Starting Time");
        String StartingTime = App.scan.nextLine();

        System.out.println("Enter Ending Point");
        String EndingPoint = App.scan.nextLine();

        System.out.println("Enter Endig Time");
        String EndingTime = App.scan.nextLine();

        System.out.println("Enter Distance");
        double Distance = App.scan.nextDouble();
        App.scan.nextLine();

        route r = new route(routeID, StartingPoint, StartingTime, EndingPoint, EndingTime, Distance);

        addRoute(r);

    }

    public static void addRoute(route r) {

        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(r.getRouteID() + "," + r.getSp() + "," + r.getStartTime() + "," + r.getEp() + ","
                    + r.getEndTime() + "," + r.getDistance() + "\n");
            System.out.println("Route Added");
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Route Not Added");
        }

    }

    /*
     * public static void viewRoute() {
     * File file = new File(path);
     * try {
     * FileReader fileReader = new FileReader(file);
     * int line;
     * 
     * while ((line = fileReader.read()) != -1) {
     * System.out.print((char) line);
     * }
     * fileReader.close();
     * } catch (Exception e) {
     * System.out.println("Can not get route");
     * }
     * 
     * }
     */

    public static void viewRoute() {
        File file = new File(path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] arr = line.split(",");
                if (arr.length == 6) {
                    System.out.println("Route ID: " + arr[0] + ", Start: " + arr[1] + ", Starting Time: " + arr[2] +
                            ", End: " + arr[3] + ", Ending Time: " + arr[4] + ", Distance: " + arr[5]);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void getRoute() {
        System.out.println("Enter Route ID");
        int routeID = App.scan.nextInt();
        App.scan.nextLine();

        File file = new File(path);
        boolean found = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] arr = line.split(",");

                if (Integer.parseInt(arr[0]) == routeID) {
                    System.out.println("Route ID: " + arr[0] + ", Start: " + arr[1] + ", Starting Time: " + arr[2] +
                            ", End: " + arr[3] + ", Ending Time: " + arr[4] + ", Distance: " + arr[5]);
                    found = true;
                    break;
                }
            }
            bufferedReader.close();
            if (!found) {
                System.out.println("Route ID not found: " + routeID);
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

    public static void deleteRoute() {
        System.out.println("Enter Route ID");
        int routeId = App.scan.nextInt();
        App.scan.nextLine();

        boolean found = false;

        File file = new File(path);
        File temp = new File("temp.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(temp))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] arr = line.split(",");

                if (Integer.parseInt(arr[0]) == routeId) {
                    found = true;
                    System.out.println("Route Deleted");
                    continue;
                }

                bufferedWriter.write(line + System.lineSeparator());
            }

            if (!file.delete()) {
                throw new Exception("Failed to delete the original file");

            }
            if (!temp.renameTo(file)) {
                throw new Exception("Failed to rename the temp file to original file name");
            }

            if (!found) {
                throw new Exception("Invalid Route ID" + routeId);
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void updateRoute() {
        System.out.println("Enter Route ID");
        int routeId = App.scan.nextInt();
        App.scan.nextLine();

        boolean found = false;

        File file = new File(path);
        File temp = new File("temp.txt");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(temp))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String arr[] = line.split(",");

                if (Integer.parseInt(arr[0]) == routeId) {
                    found = true;

                    System.out.println(
                            "Enter Available Changes: 1 RouteID | 2 Starting Point | 3 Ending Point | 4 Distance");
                    int option = App.scan.nextInt();
                    App.scan.nextLine();

                    switch (option) {
                        case 1:
                            System.out.println("Enter new Route ID");
                            int ID = App.scan.nextInt();
                            App.scan.nextLine();
                            arr[0] = String.valueOf(ID);
                            break;
                        case 2:
                            System.out.println("Enter new Starting Point");
                            arr[1] = App.scan.nextLine();
                            break;
                        case 3:
                            System.out.println("Enter new Ending Point");
                            arr[2] = App.scan.nextLine();
                            break;
                        case 4:
                            System.out.println("Enter new Distance");
                            arr[3] = String.valueOf(App.scan.nextInt());
                            App.scan.nextLine();
                            break;
                        default:
                            throw new Exception("Invalid Option: " + option);
                    }
                    line = String.join(",", arr);
                }

                bufferedWriter.write(line + System.lineSeparator());
            }

            if (!found) {
                System.out.println("Route ID not found.");
                temp.delete(); // Discard changes
            } else {
                // Replace the original file
                if (!file.delete() || !temp.renameTo(file)) {
                    System.out.println("Error updating the file.");
                } else {
                    System.out.println("Route updated successfully.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error during update: " + e.getMessage());
        }
    }
}
