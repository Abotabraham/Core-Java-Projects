package checkingaccount;

 // This program models a check account
public class CheckAccountApplication {
    public static void main(String[] args) {
      CheckingAccount account = new CheckingAccount(0);
      //System.out.println(account.getBalance());
      account.deposit(5000);
      account.withdraw(3000);
      account.withdraw(4000);
    }

}
