package null_object_pattern;

public class VehicleFactory {

    public static Vehicle getVehicleObject(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car();
        } else {
            return new NullVehicle();
        }
    }

}
