package Models;


import Exeptions.NatimortoException;

public class Natimorto extends Pessoa{

	public Natimorto (String nome, Pessoa paiOuMae) {
		super(nome, paiOuMae, null);
	}
	@Override
	public Pessoa CadastrarFilho(Pessoa pessoa) throws NatimortoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
