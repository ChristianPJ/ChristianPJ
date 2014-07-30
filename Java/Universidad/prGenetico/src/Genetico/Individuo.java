package Genetico;

public class Individuo{
	public double fitness;

	public Cromosoma c;

	public Individuo(int i, Problema p) {
		c=new Cromosoma(i, false);
		fitness=p.evalua(c);
	}

	public Individuo(Cromosoma i, Problema p) {
		c=i.copia();
		fitness=p.evalua(c);
	}

	public double fitness() {
		return this.fitness;
	}

	public Cromosoma cromosoma() {
		return c.copia();
	}

}
