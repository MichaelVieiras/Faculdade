package exercicio;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
	
		while (true) {
			String senha = JOptionPane.showInputDialog("Digite a senha");
			if (senha == null) {
				JOptionPane.showMessageDialog(null, "Você perdeu.");
				break;
			}else if (senha.equals("banana")) {
				JOptionPane.showMessageDialog(null, "Você acertou");
				break;
			}else {
				JOptionPane.showMessageDialog(null, "Você errou a senha!");
			}
		}

	}
}