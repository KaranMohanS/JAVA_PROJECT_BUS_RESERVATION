import java.util.Scanner;

import com.user.user;


public class App {


    public static void main(String[] args) {
        
       
        user u2=new user("karan", 9360728854l, "karan@gmail.com");
        user.addUser(u2);
        user u1=new user("mohan", 9360728854l, "mohan@gmail.com");
        user.addUser(u1);
        

        user.getUser(2);
       // user.deleteUser(2);
        user.printUsers();
        user.updateUser(1);
        user.printUsers();

    }
}