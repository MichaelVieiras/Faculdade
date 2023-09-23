package mExames;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Cadastro de Exame de Glicemia");
        System.out.print("Nome do paciente: ");
        String nomeGlicemia = scan.nextLine();
        System.out.print("Tipo sanguíneo: ");
        String tipoSanguineoGlicemia = scan.nextLine();
        System.out.print("Ano de nascimento: ");
        int anoNascimentoGlicemia = scan.nextInt();
        System.out.print("Quantidade de glicose (mg/dL): ");
        double quantidadeGlicose = scan.nextDouble();

        ExameGlicemia exameGlicemia = new ExameGlicemia(nomeGlicemia, tipoSanguineoGlicemia, anoNascimentoGlicemia, quantidadeGlicose);
        exameGlicemia.classificarResultado();
        exameGlicemia.mostrarResultado();

        scan.nextLine();

        System.out.println("\nCadastro de Exame de Colesterol");
        System.out.print("Nome do paciente: ");
        String nomeColesterol = scan.nextLine();
        System.out.print("Tipo sanguíneo: ");
        String tipoSanguineoColesterol = scan.nextLine();
        System.out.print("Ano de nascimento: ");
        int anoNascimentoColesterol = scan.nextInt();
        System.out.print("Quantidade de LDL (mg/dL): ");
        double quantidadeLDL = scan.nextDouble();
        System.out.print("Quantidade de HDL (mg/dL): ");
        double quantidadeHDL = scan.nextDouble();

        ExameColesterol exameColesterol = new ExameColesterol(nomeColesterol, tipoSanguineoColesterol, anoNascimentoColesterol, quantidadeLDL, quantidadeHDL);
        exameColesterol.classificarResultado();
        exameColesterol.mostrarResultado();

        scan.nextLine();

        System.out.println("\nCadastro de Exame de Triglicerídeos");
        System.out.print("Nome do paciente: ");
        String nomeTriglicerideos = scan.nextLine();
        System.out.print("Tipo sanguíneo: ");
        String tipoSanguineoTriglicerideos = scan.nextLine();
        System.out.print("Ano de nascimento: ");
        int anoNascimentoTriglicerideos = scan.nextInt();
        System.out.print("Quantidade de triglicerídeos (mg/dL): ");
        double quantidadeTriglicerideos = scan.nextDouble();

        ExameTriglicerideos exameTriglicerideos = new ExameTriglicerideos(nomeTriglicerideos, tipoSanguineoTriglicerideos, anoNascimentoTriglicerideos, quantidadeTriglicerideos);
        exameTriglicerideos.classificarResultado();
        exameTriglicerideos.mostrarResultado();

        scan.close();
    }
}

