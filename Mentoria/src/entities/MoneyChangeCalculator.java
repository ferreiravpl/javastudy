package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyChangeCalculator extends Transactions {

    double returnTotalNoteChange;
    List<Double> noteList = new ArrayList();

    //Método para inserir as cédulas na lista
    public void setNoteList() {
        noteList.add(10.0);
        noteList.add(200.0);
        noteList.add(5.0);
        noteList.add(0.10);
        noteList.add(50.0);
        noteList.add(100.0);
        noteList.add(2.0);
        noteList.add(0.05);
        noteList.add(1.0);
        noteList.add(0.50);
        noteList.add(20.0);
        noteList.add(0.25);
    }

    //Método para consultar a lista
    public List<Double> returnNoteList () {
        return noteList;
    }

    //Método para calcular o troco em cédulas
    public void returnTotalNoteChange () {
        Collections.sort(noteList, Collections.reverseOrder());
        returnTotalNoteChange = calculateTotalMoneyChange();
        for (int i = 0; i < noteList.size(); i++) {
            double validateCalculateTotalMoneyChange = calculateTotalMoneyChange();
                if (validateCalculateTotalMoneyChange == 0) {
                    break;
                }
            double newValueNoteChange = returnTotalNoteChange / noteList.get(i);
            int noteQuantityPerValue = (int) Math.floor(newValueNoteChange);
                if (noteQuantityPerValue > 0) {
                    double alreadyPaidAmount = noteQuantityPerValue * noteList.get(i);
                    returnTotalNoteChange -= alreadyPaidAmount;
                    System.out.println("O seu troco contém " + noteQuantityPerValue + " notas de " + noteList.get(i));
            }
        }
    }

    //Calculando o valor total do troco (sem separação por cédulas)
    public Double calculateTotalMoneyChange() {
        if (Transactions.getPaidAmount() < Transactions.getCost()) {
            System.out.println("Dinheiro insuficiente!");
            return 0.0;
        } else {
            return Transactions.getPaidAmount() - Transactions.getCost();
        }
    }
}