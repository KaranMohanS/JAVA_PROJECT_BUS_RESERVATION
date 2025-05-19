package com;

import java.util.Scanner;

import com.Bus.BusService;
import com.Bus.bus;
import com.Route.RouteService;
import com.Route.route;
import com.user.user;
import com.user.userService;
import com.Booking.Booking;
import com.Booking.BookingService;
import com.Booking.booking;

public class App {

   public static Scanner scan = new Scanner(System.in);

   public static void main(String[] args) throws Exception {

      /*
       * user u2=new user("karan", 9360728854l, "karan@gmail.com");
       * user.addUser(u2);
       * user u1=new user("mohan", 9360728854l, "mohan@gmail.com");
       * user.addUser(u1);
       * 
       * user.printUsers();
       * route r1=new route(101, "sirumugai", "coimbatore", 31);
       * bus b1=new bus(1001, "SRT", 60, 60, r1);
       * b1.bookSeat();
       * System.out.println(b1);
       * 
       * // booking book1=new booking(001,u1,b1,33,500);
       * booking.addBooking(001, u1, b1, 33, 330, "17/06/2002","ac");
       * b1.bookSeat();
       * booking.addBooking(002, u2, b1, 44, 20, "18/06/2002", "normal");
       * booking.viewBokking();
       * 
       * //userService.addUser();
       * //userService.viewUser();
       * //userService.getUser();
       * //userService.deleteUser();
       * 
       * user u=new user("karan", 9360728854l, "karan@gmail.com");
       * u.addUser(u);
       * /*route r=new route("sirumugai", "chennai", 200);
       * r.addRoute(r);
       * route r1=new route("cbe", "bangalore", 365);
       * route r2=new route("madurai", "dheli", 1234);
       * r1.addRoute(r1);
       * r2.addRoute(r2);
       * route.viewRoute();
       * 
       * route.getRoute(4);
       * route r1=new route("cbe", "bangalore", 365);
       * r1.addRoute(r1);
       * route.viewRoute();
       * bus b=new bus(1, "karan", 50, 20, r1);
       * b.addBus(b);
       * //bus.viewBus();
       * //bus.getBus(3);
       * 
       * Booking.addBooking(u, b, 13, 234, "17-06-2002","ac" );
       * 
       * // Booking.viewBokking();
       */

      // RouteService.addRoute();
      // RouteService.viewRoute();
      // RouteService.getRoute();
      // RouteService.deleteRoute();
      // RouteService.updateRoute();
      //Booking booking=new Booking(1, userService.addUser(), BusService.addBus(), 13, "ac", 200);
      //BookingService.addBooking(booking);
      BookingService.addBooking();
        
   }
}