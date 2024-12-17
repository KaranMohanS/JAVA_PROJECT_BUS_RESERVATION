package com.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class user {

    public static List<user> uList = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);

    public static void addUser(user u) {
        int id = uList.size() + 1;
        u.setUID(id);
        uList.add(u);
    }

    public static void printUsers() {
        for (user x : uList) {
            System.out.println(x);
        }
    }

    public static void getUser(int id) {
        for (user x : uList) {
            if (x.getUID() == id) {
                System.out.println(x);
            }
        }
    }

    public static void deleteUser(int id) {
        for (user x : uList) {
            if (x.getUID() == id) {
                uList.remove(id);
            }
        }
    }

    public static void updateUser(int id) {
        System.out.println("enter : 1 name || 2 contect || 3 email");
        int option = scan.nextInt();
        scan.nextLine();

        for (user x : uList) {
            if (x.getUID() == id) {
                switch (option) {
                    case 1:

                        System.out.println("Enter new name");
                        String name = scan.nextLine();
                        x.setName(name);
                        break;
                    case 2:

                        System.out.println("Enter new contect");
                        long ph = scan.nextLong();
                        scan.nextLine();
                        x.setContect(ph);
                        break;
                    case 3:

                        System.out.println("Enter new email");
                        String em = scan.nextLine();
                        x.setEmail(em);
                        break;

                    default:
                        System.out.println("Invalied Option");
                        break;
                }
            }
        }

    }

    // ---------------------------------------------------------

    int UID;
    String name;
    long contect;
    String email;

    public user(String name, long contect, String email) {
        this.name = name;
        this.contect = contect;
        this.email = email;
    }

    public int getUID() {
        return this.UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContect() {
        return contect;
    }

    public void setContect(long contect) {
        this.contect = contect;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        String str = "";

        str += "USER ID: " + this.UID + "\n";
        str += "NAME: " + this.name + "\n";
        str += "CONTECT NUMBER: " + this.contect + "\n";
        str += "EMAIL: " + this.email + "\n";
        return str;
    }
}