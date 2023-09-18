package application;
import entities.Account;
import entities.Transaction;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account ac = new Account();
        //Definindo dados de nome
        System.out.print("Enter the account holder: ");
        String name = sc.nextLine();
        ac.setName(name);

        //Definindo dados de conta
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        ac.setAccountNumber(accountNumber);
        sc.nextLine();

        Transaction tc = new Transaction();

        //Questionando se há depósito inicial
        System.out.print("Is there a initial deposit (y/n)? ");
        String isInitialDeposit = sc.nextLine();

        //Validação do depósito inicial e inserção do valor no balanço final da conta
        if ("n".equalsIgnoreCase(isInitialDeposit)) {
            System.out.println("Account data without deposit: " + "Account owner: " + ac.getName() + ", " + "Account number: " + ac.getAccountNumber() + ", " + "Account balance: " + ac.getBalance());
        } else {
            System.out.print("Enter the initial deposit value: ");
            double initialDepositValue = sc.nextDouble();
            ac.setInitialDeposit(initialDepositValue);
            ac.setBalance(initialDepositValue);
            System.out.println("Updated account data: " + "Account owner: " + ac.getName() + ", " + "Account number: " + ac.getAccountNumber() + ", " + "Account balance: " + ac.getBalance());
        }

        //Questionando depósito posterior
        System.out.print("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        tc.setDeposit(depositValue);
        System.out.println("Updated account data: " + "Account owner: " + ac.getName() + ", " + "Account number: " + ac.getAccountNumber() + ", " + "Account balance: " + ac.getBalance());

        //Questionando saque
        System.out.print("Enter a withdraw value: ");
        double withdraw = sc.nextDouble();
        tc.setWithdraw(withdraw);
        System.out.println("Updated account data: " + "Account owner: " + ac.getName() + ", " + "Account number: " + ac.getAccountNumber() + ", " + "Account balance: " + ac.getBalance());

        sc.close();

    }
}
