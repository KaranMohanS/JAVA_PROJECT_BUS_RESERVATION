import java.util.Scanner;

import com.Bus.bus;
import com.Route.route;
import com.user.user;


public class App {


    public static void main(String[] args) {
        
       
        user u2=new user("karan", 9360728854l, "karan@gmail.com");
        user.addUser(u2);
        user u1=new user("mohan", 9360728854l, "mohan@gmail.com");
        user.addUser(u1);
        
        user.printUsers();
        route r1=new route(101, "sirumugai", "coimbatore", 31);
        bus b1=new bus(1001, "SRT", 60, 60, r1);

        System.out.println(b1);
       
    }
}