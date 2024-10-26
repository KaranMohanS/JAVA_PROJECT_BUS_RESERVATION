import java.util.ArrayList;
import java.util.List;

import com.Bus.bus;
import com.Seat.seat;
import com.user.user;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
       user u=new user(1, "karan", 23, "karan@gmail.com", 9360728854l);
       System.out.println(u);

       bus b=new bus(101, "karan travels", 50, "sivagasi");
       System.out.println(b);
       

                                                               
    }
}
