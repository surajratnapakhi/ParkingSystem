import observer.DisplayBoard;
import observer.FullCapacityAlertObserver;
import observer.ParkingObserver;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import parkingspot.ParkingSpot;
import vehicle.Car;
import vehicle.MotorCycle;
import vehicle.Truck;
import vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingObserver displayBoard = new DisplayBoard("001");
        ParkingObserver parkingFullAlert = new FullCapacityAlertObserver();

        parkingLot.registerObserver(displayBoard);
        parkingLot.registerObserver(parkingFullAlert);

        Vehicle v1 = new Car("MH12 AA0001");
        Ticket t1 = parkingLot.assignSpot(v1);

        Vehicle v2 = new Car("MH12 AA0002");
        Ticket t2 = parkingLot.assignSpot(v2);

        Vehicle v3 = new Car("MH12 AA0003");
        Ticket t3 = parkingLot.assignSpot(v3);

        Vehicle v4 = new MotorCycle("MH12 BB001");
        Ticket t4 = parkingLot.assignSpot(v4);

        Vehicle v5 = new MotorCycle("MH12 BB002");
        Ticket t5 = parkingLot.assignSpot(v5);

        Vehicle v6 = new Truck("MH12 TT001");
        Ticket t6 = parkingLot.assignSpot(v6);

        parkingLot.releaseSpot(t1);
    }
}