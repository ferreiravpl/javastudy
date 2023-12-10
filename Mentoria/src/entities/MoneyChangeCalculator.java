package entities;

import java.util.ArrayList;
import java.util.List;

public class MoneyChangeCalculator extends Transactions {

    double returnTotalNoteChange;

    List noteList = new ArrayList();

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

    //Método para calcular o troco em cédulas
    public double returnTotalNoteChange () {
        for (Object note : noteList) {
            returnTotalNoteChange = calculateTotalMoneyChange() / noteList.indexOf(note);
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
