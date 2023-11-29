package Models;

import java.util.List;

import Enums.MortoVivo;
import Exeptions.NatimortoException;
import Utils.RandomMortoVivo;

public class Homem extends Pessoa{

	public Homem (String nome, Pessoa paiOuMae, List<Pessoa> filhos){
		super(nome, paiOuMae, filhos);
	}
	@Override
	public Pessoa CadastrarFilho(Pessoa pessoa) throws NatimortoException {
		if(getFilhos().size() == 1 || RandomMortoVivo.VivoOuMorto() == MortoVivo.Morto) {
			Natimorto nat = new Natimorto(pessoa.getNome(), this);
			setFilhos((Pessoa)nat);
			return (Pessoa)nat;
		}else {
			if(pessoa instanceof Homem) {
				Pessoa homem = (Homem)pessoa;
				setFilhos((Pessoa)homem);
				return homem;
			}else if(pessoa instanceof Mulher) {
				Pessoa mulher = (Mulher)pessoa;
				setFilhos((Pessoa)mulher);
				return mulher;
			}
		}
		return pessoa;
	}

}
