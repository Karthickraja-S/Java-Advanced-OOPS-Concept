import com.enums.VehicleType;
import com.internal.Gate;
import com.models.Ticket;
import com.models.Vehicle;

public class Main {
    static void main() {
        Vehicle v1 = new Vehicle("ABCD", VehicleType.BIKE);
        Vehicle v2 = new Vehicle("1234", VehicleType.BIKE);

        Vehicle v3 = new Vehicle("VANBYE", VehicleType.VAN);
        Vehicle v4 = new Vehicle("NOTPOSSIBLE", VehicleType.BIKE);

        Gate g1 = new Gate();
        System.out.println("Going to park vehicle : "+v1);
        Ticket t1 = g1.parkVehicle(v1);
        System.out.println("Going to park vehicle : "+v2);
        Ticket t2 = g1.parkVehicle(v2);
        System.out.println("Going to park vehicle : "+v3);
        Ticket t3 = g1.parkVehicle(v3);
        System.out.println("Going to park vehicle : "+v4);
        Ticket t4 = g1.parkVehicle(v4); // not possible

        System.out.println("going to unpark vehicle : "+v2);
        g1.unPark(t2);
        System.out.println("Going to park vehicle : "+v4);
        Ticket v5 = g1.parkVehicle(v4); // now possible

    }
}
