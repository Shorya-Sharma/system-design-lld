package state.myimpl.state;

import state.cacimpl.VendingMachine;

public interface VendingMachineState {
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception;

    public void initiateCancel(VendingMachine vendingMachine) throws Exception;

    public void insertCoins(VendingMachine vendingMachine) throws Exception;

    public void clickOnSelectProductButton(VendingMachine vendingMachine) throws Exception;

    public void selectProduct(VendingMachine vendingMachine) throws Exception;

    public void dispenseProduct(VendingMachine vendingMachine) throws Exception;
}
