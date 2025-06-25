import java.util.ArrayList;
import java.util.Date;

public class Account implements AccountService{

    // the important variable to work that i extracted after reading the test question
    private int Balance;
    private int Amount;
    private Date date;

    // the best to hold the data in row for the printstatement function
    private ArrayList<Transaction> transactions = new ArrayList<>();


    // the @overirde is essential because we implement the interface and we need it's method
    @Override
    public void deposit(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than 0 You can add Nothing");
        } else {
            Balance += amount;
            System.out.println("You Have Deposited " + amount + " Successfully.");
        }

    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Account have 0 dollard");
        }
        if(this.Balance < amount){
            throw new IllegalArgumentException("Not enough balance");
        }
        this.Balance -= amount;
        System.out.println("You Have Withdrawn " + amount + " Successfully.");
    }

    @Override
    public void printStatement() {
        // le header of output it show the title of each column
        System.out.println("Date       ||Amount  || Balance");
        // we return empty if the array is empty
        if(transactions.isEmpty()){
            System.out.println("No Transaction is registered");
        }else {
            // i chose the sorting logic to be the printstatement just to no bulk up the main class and have more control
            // over the output format
            transactions.sort((t1, t2) -> t2.getDateOfOperation().compareTo(t1.getDateOfOperation()));
            // we loop in our added value inside the arraylist transactions
            for(Transaction t: transactions){
                System.out.println(t);
            }
        }
    }

    public void deposit(int amount, Date date) { // i used method overloading it still follow the rule of not changing the interface
        if (amount <= 0 && date == null) {
            System.out.println("Deposit amount must be positive. and you need to provide a date ");
            return;
        }
        this.Balance += amount;
        this.transactions.add(new Transaction(date, amount, this.Balance));
    }

    public void withdraw(int amount, Date date) { // i used method overloading it still follow the rule of not changing the interface
        if (amount > Balance && date == null) {
            System.out.println("Withdrawn amount must be smaller than balance . and you need to have money in account ");
            return;
        }
        this.Balance -= amount;
        // the minus in amount to differentiate between deposit amount and withdraw amount in the printstatement of account
        this.transactions.add(new Transaction(date, -amount, this.Balance));
    }

    public int getBalance() {
        return this.Balance;
    }

    public void setBalance(int balance) {
        if(balance < 0){
            System.out.println("Cannot Add negative Value to Current Balance");
        } else {
            this.Balance += balance;
        }
    }

    public int getAmount() {
        return this.Amount;
    }

    public void setAmount(int amount) {
        if(amount < 0){
            amount = 0;
            System.out.println("Cannot Add Nothing");
        } else {
            this.Amount = amount;
        }
    }
}
