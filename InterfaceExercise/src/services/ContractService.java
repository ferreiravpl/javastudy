package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService ops;

    public ContractService(OnlinePaymentService ops) {
        this.ops = ops;
    }

    public void processContract(Contract contract, Integer months) {

        //Calcula parcela básica
        double basicQuota = contract.getTotalValue() / months;

        //Calcula valor total da parcela e insere na lista de installments
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = ops.interest(basicQuota, i);
            double fee = ops.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;
            contract.getInstallment().add(new Installment(dueDate, quota));

        }

    }

}
