package clientbankaccounts;

public class AccountApplication {
    public static void main(String[] args) {

       Client[] clients = new Client[2]; //null null
      // client 1 with two unique accounts
      clients[0] = new Client(100, "George", "12312312" );
       clients[0].AddAccount(new Account(1, 1000, 1.5, clients[0]));
       clients[0].AddAccount(new Account(2, 2000, 2.5, clients[0]));

     
      System.out.println(clients[0].toString());
      //System.out.println(clients[1].toString());

    }
}
