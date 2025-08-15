package examples.splitwise.Expense.Split;

import examples.splitwise.User.User;

import java.util.List;

public interface ExpenseSplit {

    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
