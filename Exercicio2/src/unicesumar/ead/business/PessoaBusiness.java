package unicesumar.ead.business;

import unicesumar.ead.programacao.Pessoa;

public class PessoaBusiness {
	
	public boolean aprovado;
	
	void aprovarPessoa(Pessoa pessoa) {
		aprovado = pessoa.idade > 18;
	}
}
