package checkingaccount;
 

public class CheckingAccount {
    private double balance;


    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit (double amountToDeposit) {
        balance = balance + amountToDeposit;

        System.out.println("You deposited " + amountToDeposit + ". Your current balance is: " + balance);
    }

    public void withdraw (double amountToWithdrawal) {
        if (balance >= amountToWithdrawal) {
            balance = balance - amountToWithdrawal;
            System.out.println("You withdrew " + amountToWithdrawal + ". You current balance is: " + balance);
        } else {
            System.out.println("Cant withdraw amount greater than the available balance. Try lesser amount!");
        }
    }
}
