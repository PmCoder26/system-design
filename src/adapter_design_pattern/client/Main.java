package adapter_design_pattern.client;

import adapter_design_pattern.adaptee.WeighMachineForBabies;
import adapter_design_pattern.adapter.WeightMachineAdapter;
import adapter_design_pattern.adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args) {

        WeightMachineAdapter adapter = new WeightMachineAdapterImpl(new WeighMachineForBabies());

        System.out.println("Weight in kg: " + adapter.getWeightInKg());

    }

}
