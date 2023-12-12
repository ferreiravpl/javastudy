package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoneyChangeCalculator extends Transactions {

    double returnTotalNoteChange = calculateTotalMoneyChange();
    double newValueNoteChange;

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

    //Desordenar lista chumbada e ordenar em um próprio método
    //Ajustar variável returnTotalNoteChange pq tá pegando sempre o troco total e não o resto das próximas divisões;
    //Criar validação pra que somente aceite o pagamento caso seja maior que o custo também no for
    //Criar nova variável pra armazenar o resto das divisões (validar se faz sentido criar um método pra incrementar ela ou se no próprio for);

    //Validar quantidade de notas para dar troco, ex: 1 Nota de 100, 5 de 20, 3 de 1 real e assim por diante

    //Método para calcular o troco em cédulas
    public double returnTotalNoteChange () {
        Collections.sort(noteList, Collections.reverseOrder());


//        returnTotalNoteChange = calculateTotalMoneyChange() / noteList.get(i); INICIO COM 100
//    i=1, valor=150
//    i=2, valor=50
//    i=3, valor


        double novoValor;
        for (int i = 0; i < noteList.size(); i++) {
            System.out.println("VALOR DO ELEMENTO DA LISTA NA POSICAO i = " + i + " valor = " + noteList.get(i));
            double validateCalculateTotalMoneyChange = calculateTotalMoneyChange();
            if (validateCalculateTotalMoneyChange == 0) {
                break;
            }
            novoValor = returnTotalNoteChange / noteList.get(i); //pega o valor inicial e divide pelo elemento do seu i; novoValor = returnTotalNoteChange /  noteList.get(i);
            double pegaResto = calculateTotalMoneyChange() % noteList.get(i); //resto da divisao.
            int primeiroAntesDaVirgula = (int) Math.floor(returnTotalNoteChange); //o primeiro valor antes da virgula.
            if (primeiroAntesDaVirgula > 0) { //A cedula cabe no valor do troco.
                double teste = primeiroAntesDaVirgula * noteList.get(i); //devo diminuir o valor, pela quantidade que me retornou de inteiro * pelo valor da cedula (calcula a qtd de notas de x valor).
                returnTotalNoteChange --;//precisa tirar o valor que deu na variavel teste, e atualizar o returnTotalNoteChange para que na proxima iteração o valor que a variavel novoValor receba seja o troco atualizado, ou seja, diminuindo 100 reais, por exemplo.
            }
            /*
            * 100/200 = 0.5;
            * 250/100 = 2.50
            * 2 nota de 100 e tem resto;
            * se tem resto, devo diminuir o valor, pela quantidade que me retornou antes do resto(inteiro) * pelo valor da cedula.
            * Atualizo valor
            * Divido de novo
            * 50/100 = 0.5
            * a nota não pode ser entregue.
            * pego proxima nota
            *
            * */
            System.out.println("LINHA PARA TESTE E VER SE ISSO ME AJUDA EM ALGO, PFVR ME AJUDA JESUS> " + "resto: " + pegaResto + "primeiro int: " + primeiroAntesDaVirgula);
            if (returnTotalNoteChange != 0) {
                System.out.println(returnTotalNoteChange);
            } else {
                System.out.println("O troco está completo");
            }
        }
        return returnTotalNoteChange;
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
