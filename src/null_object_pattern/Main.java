package null_object_pattern;

public class Main {


    private static void printVehicleDetails(Vehicle v) {
        System.out.println("Seating Capacity: " + v.getSeatingCapacity());
        System.out.println("Fuel Tank Capacity: " + v.getTankCapacity());
    }

    public static void main(String[] args) {

        Vehicle vehicle = VehicleFactory.getVehicleObject("Car");
        printVehicleDetails(vehicle);

    }

}
