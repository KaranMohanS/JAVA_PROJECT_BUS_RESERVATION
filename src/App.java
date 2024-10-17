import java.util.ArrayList;
import java.util.List;

import com.Bus.bus;
import com.Seat.seat;
import com.user.user;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
       user u1=new user(1, "karan", 22, "karan@gmail.com", 9360728854l, "xx street");

       System.out.println(u1);

       List<seat> l=new ArrayList<>(50);
       for(int i=1;i<=50;i++)
       {
        l.add(new seat("s"+i));
       }

       bus b=new bus(101, "muthumari", 9566679972l, "sleeper", "sivakasi", l, "11,00pm");
       b.addbus(b.getBusId(), b.getName(), b.getBusPH(), b.getType(), b.getDestination(), b.getSeat(),"12-06-2024", b.getTime());
       bus b2=new bus(102, "city", 9360728854l, "sleeper", "chennai", l, "9.00 pm");
       b2.addbus(b2.getBusId(), b2.getName(), b2.getBusPH(), b2.getType(), b2.getDestination(), l, "12-06-2024", b2.getTime());
       
       b2.buslist();
       
    }
}
