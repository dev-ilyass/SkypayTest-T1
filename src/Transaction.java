import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private Date dateOfOperation;
    private int amountOfOperation;
    private int balanceAfterOperation;

    public Transaction(Date dateOfOperation, int amountOfOperation, int balanceAfterOperation) {
        this.dateOfOperation = dateOfOperation;
        this.amountOfOperation = amountOfOperation;
        this.balanceAfterOperation = balanceAfterOperation;
    }

    // no need to hace setters because we only use this data for showing and we don't write aything to it
    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public int getAmountOfOperation() {
        return amountOfOperation;
    }

    public int getBalanceAfterOperation() {
        return balanceAfterOperation;
    }

    // the formattage with overriding method
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dateOfOperation) + " || " + amountOfOperation +  "   || " + balanceAfterOperation;
    }
}
