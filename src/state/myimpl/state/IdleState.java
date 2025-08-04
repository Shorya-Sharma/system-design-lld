package state.myimpl.state;


import state.myimpl.VendingMachine;

public class IdleState implements VendingMachineState {
    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(new MoneyHoldingState());
    }

    @Override
    public void initiateCancel(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void insertCoins(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {

    }
}
