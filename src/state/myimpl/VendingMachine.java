package state.myimpl;

import state.myimpl.state.VendingMachineState;

import java.util.List;

public class VendingMachine {
    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    private VendingMachineState vendingMachineState;
    private List<ItemShelf> itemShelfList;


    public VendingMachine(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void setItemShelfList(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }


}
