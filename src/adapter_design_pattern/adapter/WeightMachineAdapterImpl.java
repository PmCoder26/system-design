package adapter_design_pattern.adapter;

import adapter_design_pattern.adaptee.WeightMachine;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeightMachineAdapterImpl implements WeightMachineAdapter {

    WeightMachine weightMachine;

    @Override
    public double getWeightInKg() {
        double weightInPound = weightMachine.getWeightInPound();
        // conversion pound -> kg
        return weightInPound * 0.45;
    }
}
