package null_object_pattern;

public class Car implements Vehicle {

    @Override
    public int getSeatingCapacity() { return 40; }

    @Override
    public int getTankCapacity() { return 18; }

}
