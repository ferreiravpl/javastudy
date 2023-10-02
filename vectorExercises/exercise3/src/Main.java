import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quanta pessoas serão digitadas? ");
        int qtdPessoas = sc.nextInt();
        Pessoa[] vect = new Pessoa[qtdPessoas];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Dados da " + i + "a pessoa:");
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            vect[i] = new Pessoa(nome, idade, altura);
        }

        double mediaAltura = 0.0;

        for (int i = 0; i < vect.length; i++) {
            mediaAltura += vect[i].getAltura() / qtdPessoas;
        }

        System.out.println("Média de altura: " + mediaAltura);

        double porcentagemIdade = 0.0;
        int contadorMenoresDe16 = 0;

        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getIdade() < 16) {
              contadorMenoresDe16++;
            }
        }

        if (contadorMenoresDe16 > 0) {
            porcentagemIdade = ((double)contadorMenoresDe16 / qtdPessoas * 100.00);
            System.out.println("Porcentagem de pessoas menores de 16 anos: " + porcentagemIdade);

        } else {
            System.out.println("Não existem pessoas menores de 16 anos");
        }

        for (int i = 0; i < vect.length; i++) {
            if (vect[i].getIdade() < 16) {
                System.out.println("Nome das pessoas:");
                System.out.printf("%s\n", vect[i].getNome());
            }
        }

        sc.close();
    }
}