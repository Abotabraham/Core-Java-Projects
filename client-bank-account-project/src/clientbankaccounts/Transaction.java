package clientbankaccounts;
 
import java.util.Date;

public class Transaction {

    private  char type; // Deposit or Withdrawal
    private double amountToWithdraw;
    private double balance;
    private Date date;
    private String description;

    public Transaction(char type, double amountToWithdraw, double balance, String description) {
        this.type = type;
        this.amountToWithdraw = amountToWithdraw;
        this.balance = balance;
        this.description = description;

        this.date = new Date();
    }
}