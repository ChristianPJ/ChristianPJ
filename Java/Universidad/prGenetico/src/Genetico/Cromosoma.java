package Genetico;

import java.util.*;

public class Cromosoma {
	public int[] datos;

	public Random dna;

	public Cromosoma(int l, boolean b) {
		dna = new Random();
		if (b) {
			for (int i = 0; i < l; i++) {
				datos[i] = dna.nextInt(1);
			}
		} else {
			for (int i = 0; i < l; i++) {
				datos[i] = 0;
			}
		}
	}

	public int gen(int i) {
		return datos[i];
	}

	public void gen(int i, int j) {
		datos[i] = j;
	}

	public int longitud() {
		return datos.length;
	}

	public void mutar(double d) { // cambiar porcentaje a 0.0...
		Random prob = new Random();
		for (int i = 0; i < datos.length; i++) {
			int p = prob.nextInt(1);
			if (p < d) {
				if (datos[i] == 0) {
					datos[i] = 1;
				} else {
					datos[i] = 0;
				}
			}
		}
	}

	public Cromosoma copia() {
		Cromosoma c2;
		c2 = new Cromosoma(this.datos.length, false);
		for (int i = 0; i < this.datos.length; i++) {
			c2.datos[i] = this.datos[i];
		}
		return c2;
	}
}
