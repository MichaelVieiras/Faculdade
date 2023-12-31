package onibusbusbus;

import javax.swing.JOptionPane;

public class Rota {
	public void planejarDia() {
		int quantidadeRotas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de rotas do dia: "));
		double totalKm = 0;

		for (int i = 1; i <= quantidadeRotas; i++) {
			double kmRota = Double.parseDouble(JOptionPane.showInputDialog("Digite a quilometragem (km) pecorrida" + i + ": "));
			totalKm += kmRota;		
		}

		double mediaConsumo = 2.5;
		double quantidadeCombustivel = totalKm / mediaConsumo; // Calculo para saber a quantidade de combustível

		double valorLitroDiesel = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do litro do óleo diesel: ")); // Recebe o valor do Disel por litro
		double valorTotal = valorLitroDiesel * quantidadeCombustivel;

		String mensagem = "Total de km percorridos: " + totalKm + " km\n"
				+ "Quantidade de litros de combustível necessário: " + quantidadeCombustivel + " litros\n"
				+ "Valor total a ser desembolsado: R$ " + valorTotal; 

		JOptionPane.showMessageDialog(null, mensagem); // Apresenta a resposta em uma caixa de mensagem
	}
}
