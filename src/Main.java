import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Instantiate the object account
        Account account = new Account();
        // for input insertion from the console the approach i found more real in case of banking app
        Scanner scanner = new Scanner(System.in);

        // we declare our array list to start adding the transaction object for the printstatement() purpose
        ArrayList<Transaction> transaction = new ArrayList<Transaction>();
        // i found problem to hold the value of transaction inside the clause of try catch or even if we put them isolated
        // in a area inside a brackets it stay a local variable so best way declare it here to stay global and we use it freely
        int depositValue;
        int withdrawValue;
        // the date in the first time running app is null
        Date userProvidedDate = null;
        // the formatter to have the date like you desired output
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // showing that the app is runing and starting executing
        System.out.println("Hello, In The Banking System");

        while(true){
            // the choice of functionality of the app
            System.out.println("Chose an operation");
            System.out.println("-------------\n");
            System.out.println("1- Deposit to Your Account");
            System.out.println("2- WithDraw From Your Account");
            System.out.println("3- Print Your Account Statement");
            System.out.println("4- Exit");

            // in value taped in console in reality is String
            String InputChoice = scanner.nextLine();
            // -1 default value in case of no choice
            int numberChosen = -1;
            // the beginning of try clause and we check if user tap a correct choice number
            try{
                // we need it to convert to int for knowing with case to execute
                numberChosen = Integer.parseInt(InputChoice);
            } catch(NumberFormatException e) {
                System.out.println("Your Input Must be Integer Number and Between 1 and 4");
                continue;
            }

            // beginning of the switch clause
            switch(numberChosen){
                case 1:
                    try{
                        //Add the amount of deposit
                        System.out.println("Enter the Amount of Deposit");
                        String depositAmountString = scanner.nextLine();
                        depositValue = Integer.parseInt(depositAmountString);
                        // Add the date because you didn't ask for current operation system date so i expect to hardcode the date value to be the same as your pdf
                        System.out.println("Enter the date of the operation (dd/MM/yyyy):");
                        String dateInput = scanner.nextLine();
                        userProvidedDate = formatter.parse(dateInput);
                        account.deposit(depositValue, userProvidedDate);
                    } catch(NumberFormatException e) {
                        // if you inserted the input in wrong format even with exception showing you the error
                        // you return to the begining to the chose again the number to repeat the operation
                        System.err.println("The amount must be greater than zero and Integer");
                    } catch (ParseException e) {
                        System.err.println("You date Format is invalid . Use this format ( dd/MM/yyyy. )");
                    }
                    break;

                case 2:
                    try{
                        System.out.println("Enter the Amount of Withdrawn");
                        String withdrawAmountString = scanner.nextLine();
                        withdrawValue = Integer.parseInt(withdrawAmountString);
                        // Add the date because you didn't ask for current operation system date so i expect to hardcode the date value to be the same as your pdf
                        System.out.println("Enter the date of the operation (dd/MM/yyyy):");
                        String dateInput = scanner.nextLine();
                        userProvidedDate = formatter.parse(dateInput);
                        account.withdraw(withdrawValue, userProvidedDate);
                    } catch(NumberFormatException e) {
                        System.err.println("Your Input Must be Integer and inferior of the current balance of account");
                    } catch (ParseException e) {
                        System.err.println("You date Format is invalid . Use this format ( dd/MM/yyyy. )");
                    }
                    break;

                case 3:
                    // the output statement of account
                    account.printStatement();
                    break;

                case 4:
                    // we choose to exit the program
                    System.out.println("Thank you for Visiting Us You are Welcome Any Time , GoodBye and Have a good Day");
                    scanner.close();
                    return;
                    // case of wrong choice
                default:
                    System.out.println("Your Input Must be Integer Number and Between 1 and 4");
                    break;
            }

        }
    }
}