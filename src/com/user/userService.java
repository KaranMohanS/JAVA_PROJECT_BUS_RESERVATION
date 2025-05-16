package com.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.App;

public class userService{

    public static String path="user.txt";

    public static void addUser()
    {
        int userID=App.scan.nextInt();
        App.scan.nextLine();
        String name=App.scan.nextLine();
        long contect=App.scan.nextLong();
        App.scan.nextLine();
        String email=App.scan.nextLine();

        user u=new user(userID,name, contect, email);
        try {
            addUser(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addUser(user u) throws IOException
    {
        File file=new File(path);
        FileWriter fileWriter=new FileWriter(file,true);

        fileWriter.write(u.getUID()+","+u.getName()+","+u.getContect()+","+u.getEmail()+"\n");
        fileWriter.close();

    }


    public static void viewUser() throws IOException
    {
        File file=new File(path);

        FileReader fileReader=new FileReader(file);

        int line;

        while ((line=fileReader.read())!=-1) {
             
            System.out.print((char)line);
        }

        fileReader.close();
    }

    public static void getUser() throws IOException
    {
        int id=App.scan.nextInt();
        App.scan.nextLine();

        File file=new File(path);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));

        String line;
        user u;
        while ((line=bufferedReader.readLine())!=null) {
            String[] arr=line.split(",");

            if(Integer.parseInt(arr[0])==id)
            {
                u=new user(Integer.parseInt(arr[0]), arr[1], Long.parseLong(arr[2]), arr[3]);
                System.out.println(u);
            }
        }
        bufferedReader.close();
    }

    public static void deleteUser()
    {
        int id=App.scan.nextInt();
        App.scan.nextLine();

        File file=new File(path);
        File temp=new File("temp.txt");

        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file));BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(temp))) {
            
            String line;

            while ((line=bufferedReader.readLine())!=null) {
                String[] arr=line.split(",");

                if(Integer.parseInt(arr[0])==id)
                {
                    break;
                }

                bufferedWriter.write(line+System.lineSeparator());
            }
            if (!file.delete()) {
                throw new IOException("Failed to delete the original file");
            }
            if (!temp.renameTo(file)) {
                throw new IOException("Failed to rename the temp file to original file name");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}