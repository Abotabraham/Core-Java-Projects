package clientbankaccounts;
 
import java.util.ArrayList;
import java.util.Date;

public class Account {
        private int id;
        private double balance;
        private double annualInterestRate;
        private final Date dateCreated;
        private Client client;
    private ArrayList<Transaction> transactions;
        // account constructor
        public Account(int id, double balance, double annualInterestRate, Client client) {
            this.id = id;
            this.balance = balance;
            this.annualInterestRate = annualInterestRate;
            this.client = client;

            this.transactions = new ArrayList<>();

            dateCreated = new Date();
        }

        // setters and getters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }


        // note: date has only a getter. No setter to avoid users from tempering with the date
        public Date getDateCreated() {
            return dateCreated;
        }
        // withdraw method.
        public boolean withdraw (double amountToWithdraw) {
            // check whether balance is greater than withdrawal amount
            if (balance >= amountToWithdraw ){
                balance = balance - amountToWithdraw;
                this.transactions.add(new Transaction('W', amountToWithdraw, this.balance, "Amount Withdrawn " + amountToWithdraw));
                return true;
            } else  {
                return false;
            }
        }
        public void deposit (double amountToDeposit) {
            balance = balance + amountToDeposit;
            this.transactions.add(new Transaction('D', amountToDeposit, this.balance, "Amount Deposited " + amountToDeposit ));
        }


    public String toString () {
            return "Account: ID : " + this.id + "  Balance: " + this.balance + "  Annual Rate: " + this.annualInterestRate + " Date: " + this.dateCreated;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}