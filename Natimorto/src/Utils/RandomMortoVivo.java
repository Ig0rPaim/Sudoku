package Utils;

import java.util.Random;

import Enums.MortoVivo;

public class RandomMortoVivo {
	public static MortoVivo VivoOuMorto() {
		Random random = new Random();
		var i = random.nextInt(2);
		switch(i) {
			case 0:
				return MortoVivo.Morto;
			case 1:
				return MortoVivo.Vivo;
			default:
				return null;
		}
	}
}
