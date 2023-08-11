package onibusbusbusconsole;

import java.util.Scanner;

public class Rota {
    public void planejarDia() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de rotas do dia: ");
        int quantidadeRotas = scan.nextInt();
        
        double totalKm = 0;

        for (int i = 1; i <= quantidadeRotas; i++) {
            System.out.print("Digite a quilometragem (km) percorrida na rota " + i + ": ");
            double kmRota = scan.nextDouble();
            totalKm += kmRota;        
        }

        double mediaConsumo = 2.5;
        double quantidadeCombustivel = totalKm / mediaConsumo;

        System.out.print("Digite o valor do litro do óleo diesel: ");
        double valorLitroDiesel = scan.nextDouble();
        double valorTotal = valorLitroDiesel * quantidadeCombustivel;

        System.out.println("\nTotal de km percorridos: " + totalKm + " km");
        System.out.println("Quantidade de litros de combustível necessário: " + quantidadeCombustivel + " litros");
        System.out.println("Valor total a ser desembolsado: R$ " + valorTotal);
        
        scan.close();
    }
}

