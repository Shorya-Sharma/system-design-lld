package examples.splitwise.Expense;

import examples.splitwise.Expense.Split.EqualExpenseSplit;
import examples.splitwise.Expense.Split.ExpenseSplit;
import examples.splitwise.Expense.Split.PercentageExpenseSplit;
import examples.splitwise.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
