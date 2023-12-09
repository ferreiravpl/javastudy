package application;

import entities.MoneyChangeCalculator;
import entities.Transactions;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Transactions tc = new Transactions();
        MoneyChangeCalculator mcc = new MoneyChangeCalculator();
        mcc.setNoteList();

        System.out.print("Qual o valor da sua conta? ");
        Double cost = sc.nextDouble();
        tc.setCost(cost);

        System.out.print("Qual o valor do pagamento em dinheiro? ");
        Double paidAmount = sc.nextDouble();
        tc.setPaidAmount(paidAmount);

        System.out.println("O troco é: " + mcc.calculateTotalMoneyChange());

        System.out.println("As notas disponíveis para troco são: " + mcc.returnNoteList());
        System.out.println(mcc.returnTotalNoteChange());

        sc.close();
    }
}