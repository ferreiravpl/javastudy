package services;

import entities.Contract;

public class ContractService {

    public void processContract (Contract contract, Integer months) {
        Contract obj = new Contract();
        ContractService service = new ContractService();
        service.processContract(obj, 3);
    }

}
