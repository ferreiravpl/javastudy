package entities;

import java.util.ArrayList;
import java.util.List;

public class MoneyChangeCalculator extends Transactions {

    double returnTotalNoteChange;

    List<Double> noteList = new ArrayList();

    //Método para inserir as cédulas na lista
    public void setNoteList() {
        noteList.add(100.0);
        noteList.add(50.0);
        noteList.add(25.0);
        noteList.add(10.0);
        noteList.add(5.0);
        noteList.add(2.0);
        noteList.add(1.0);
        noteList.add(0.50);
        noteList.add(0.25);
        noteList.add(0.10);
        noteList.add(0.05);
    }

    //Método para consultar a lista
    public List<Double> returnNoteList () {
        return noteList;
    }

    //Desordenar lista chumbada e ordenar em um próprio método
    //Ajustar variável returnTotalNoteChange pq tá pegando sempre o troco total e não o resto das próximas divisões;
    //Criar validação pra que somente aceite o pagamento caso seja maior que o custo
    //Validar utilização de hash

    //Método para calcular o troco em cédulas
    public double returnTotalNoteChange () {
        for (int i = 0; i < noteList.size(); i++) {
            returnTotalNoteChange = calculateTotalMoneyChange() / noteList.get(i);
            if (returnTotalNoteChange != 0) {
                System.out.println(returnTotalNoteChange);
            } else {
                System.out.println("O troco está completo");
            }
        }
        return returnTotalNoteChange;
    }

    //Calculando o valor total do troco (sem separação por cédulas)
    public Double calculateTotalMoneyChange () {
        return Transactions.getPaidAmount() - Transactions.getCost();
    }

}
