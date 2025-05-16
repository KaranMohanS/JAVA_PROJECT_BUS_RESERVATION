package com.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.App;

public class user {

    public static List<user> uList = new ArrayList<>();
    // public static Scanner scan = new Scanner(System.in);

    public void addUser(user u) {
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

    public static void deleteUser(int id) throws Exception {

        Iterator<user> iterator = uList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            user x = iterator.next();

            if (x.getUID() == id) {
                found = true;
                iterator.remove();
                System.out.println("user id deleted");
                break;
            }
        }
        if (!found) {
            throw new Exception("invalid user id");
        }
    }

    public static void updateUser(int id)throws Exception {
        boolean found = false;
        for (user x : uList) {
            if (x.getUID() == id) {
                found = true;
                System.out.println("enter : 1 name || 2 contect || 3 email");
                int option = App.scan.nextInt();
                App.scan.nextLine();
                switch (option) {
                    case 1:

                        System.out.println("Enter new name");
                        String name = App.scan.nextLine();
                        x.setName(name);
                        break;
                    case 2:

                        System.out.println("Enter new contect");
                        long ph = App.scan.nextLong();
                        App.scan.nextLine();
                        x.setContect(ph);
                        break;
                    case 3:

                        System.out.println("Enter new email");
                        String em = App.scan.nextLine();
                        x.setEmail(em);
                        break;

                    default:
                        System.out.println("Invalid Option");
                        break;
                }
                break;
            }
        }
        if(!found)
        {
            throw new Exception("invalid user id");
        }
    }

    // ---------------------------------------------------------

    private int UID;
    private String name;
    private long contect;
    private String email;

    public user(String name, long contect, String email) {
        this.name = name;
        this.contect = contect;
        this.email = email;
    }

    public user(int uID, String name, long contect, String email) {
        UID = uID;
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