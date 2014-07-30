package Genetico;

public class OneMax implements Problema {

	public double evalua(Cromosoma c) {
		int fitness = 0;
		for (int i = 0; i < c.datos.length; i++) {
			if (c.datos[i] == 1) {
				fitness++;
			}
		}
		return fitness;
	}

}
