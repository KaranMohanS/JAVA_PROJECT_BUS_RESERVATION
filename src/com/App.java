package com;
import java.io.IOException;
import java.util.Scanner;


import com.Bus.bus;
import com.Route.route;
import com.user.user;
import com.user.userService;
import com.Booking.Booking;
import com.Booking.booking;


public class App {

   public static Scanner scan=new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        
       /*  user u2=new user("karan", 9360728854l, "karan@gmail.com");
        user.addUser(u2);
        user u1=new user("mohan", 9360728854l, "mohan@gmail.com");
        user.addUser(u1);
        
        user.printUsers();
        route r1=new route(101, "sirumugai", "coimbatore", 31);
        bus b1=new bus(1001, "SRT", 60, 60, r1);
        b1.bookSeat();
        System.out.println(b1);
        
        // booking book1=new booking(001,u1,b1,33,500);
        booking.addBooking(001, u1, b1, 33, 330, "17/06/2002","ac");
        b1.bookSeat();
        booking.addBooking(002, u2, b1, 44, 20, "18/06/2002", "normal");
        booking.viewBokking();*/

       //userService.addUser();
       //userService.viewUser();
       //userService.getUser();
       //userService.deleteUser();
       
       user u=new user("karan", 9360728854l, "karan@gmail.com");
       u.addUser(u);
       route r=new route("sirumugai", "chennai", 200,369.0);
       r.addRoute(r);
       //r.viewRoute();
       bus b=new bus(1, "karan", 50, 20,r );
       b.addBus(b);
       //b.printBus();

      Booking.addBooking(u, b, 13, 234, "17-06-2002","ac" );
      Booking.viewBokking();
       
    }
}