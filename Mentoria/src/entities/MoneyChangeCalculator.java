package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyChangeCalculator extends Transactions {

    Double returnTotalNoteChange;
    Double newValueNoteChange;

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

    //Ajustar variável returnTotalNoteChange pq tá pegando sempre o troco total e não o resto das próximas divisões;
    //Criar nova variável pra armazenar o resto das divisões (validar se faz sentido criar um método pra incrementar ela ou se no próprio for);


    //Método para calcular o troco em cédulas
    public double returnTotalNoteChange () {
        Collections.sort(noteList, Collections.reverseOrder());
        for (int i = 0; i < noteList.size(); i++) {
            System.out.println("VALOR DO ELEMENTO DA LISTA NA POSICAO i = " + i + " valor = " + noteList.get(i));
            double validateCalculateTotalMoneyChange = calculateTotalMoneyChange();
            if (validateCalculateTotalMoneyChange == 0) {
                break;
            }
            returnTotalNoteChange = calculateTotalMoneyChange();
            newValueNoteChange = returnTotalNoteChange / noteList.get(i); //Armazena o valor inicial do returnTotalNoteChange dividido pelo valor do index
            double pegaResto = calculateTotalMoneyChange() % noteList.get(i); //Armazena o resto da divisão na variável pegaResto
            Integer eachValueNoteQuantity = (int) Math.floor(returnTotalNoteChange);
            if (eachValueNoteQuantity > 0) { //Valida se a cédula cabe no valor do troco
                double teste = eachValueNoteQuantity * noteList.get(i); //devo diminuir o valor, pela quantidade que me retornou de inteiro * pelo valor da cedula (calcula a qtd de notas de x valor).
//                returnTotalNoteChange--;//precisa tirar o valor que deu na variavel teste, e atualizar o returnTotalNoteChange para que na proxima iteração o valor que a variavel novoValor receba seja o troco atualizado, ou seja, diminuindo 100 reais, por exemplo.
            }
            System.out.println("LINHA PARA TESTE E VER SE ISSO ME AJUDA EM ALGO, PFVR ME AJUDA JESUS> " + "resto: " + pegaResto + " primeiro int: " + eachValueNoteQuantity);
            if (returnTotalNoteChange != 0) {
                System.out.println(returnTotalNoteChange);
            } else {
                System.out.println("O troco está completo");
            }
        }
        return 0.0;
    }

    //Calculando o valor total do troco (sem separação por cédulas)
    public Double calculateTotalMoneyChange() {
        if (Transactions.getPaidAmount() < Transactions.getCost()) {
            System.out.println("Dinheiro insuficiente!");
        } else {
            return Transactions.getPaidAmount() - Transactions.getCost();
        }
        return 0.0;
    }
}
