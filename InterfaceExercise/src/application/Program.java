package application;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Numero: ");
        int contractNumber = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        Double contractValue = sc.nextDouble();

        Contract obj = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Entre com o número de parcelas: ");
        int installmentQty = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(obj, installmentQty);

        System.out.println("Parcelas: ");

        for (Installment installment : obj.getInstallment()) {
            System.out.println(installment);
        }

        sc.close();
    }
}