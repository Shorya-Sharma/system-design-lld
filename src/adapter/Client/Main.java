package adapter.Client;

import adapter.Adaptee.WeightMachineForBabies;
import adapter.Adapter.WeightMachineAdapter;
import adapter.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
