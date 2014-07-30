public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private double notaExamenTeorico, notaExamenPractico;

	static enum Calificacion {
		MatriculaDeHonor, Sobresaliente, Notable, Aprobado, Suspenso
	};

	public Alumno(String nombre, double notaExamenTeo, double notaExamenPrac) {

		this.nombre = nombre;

		if (((notaExamenTeo >= 0) && (notaExamenTeo <= 2))
				&& ((notaExamenPrac >= 0) && (notaExamenPrac <= 8))) {
			this.notaExamenTeorico = notaExamenTeo;
			this.notaExamenPractico = notaExamenPrac;
		} else {
			throw new RangoException("Error...Nota fuera de rango");
		}
	}

	public Calificacion calificacion() {

		if (((this.notaFinal() >= 0) && (this.notaFinal() < 5))
				|| (this.notaExamenPractico < 2.64)) {
			return Calificacion.Suspenso;
		} else if ((this.notaFinal() >= 5) && (this.notaFinal() < 7)) {
			return Calificacion.Aprobado;
		} else if ((this.notaFinal() >= 7) && (this.notaFinal() < 9)) {
			return Calificacion.Notable;
		} else if ((this.notaFinal() >= 9) && (this.notaFinal() < 10)) {
			return Calificacion.Sobresaliente;
		} else {
			return Calificacion.MatriculaDeHonor;
		}
	}

	public double getNotaExamenTeorico() {
		return this.notaExamenTeorico;
	}

	public double getNotaExamenPractico() {
		return this.notaExamenPractico;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void setNotaExamenTeorico(double nota) {
		this.notaExamenTeorico = nota;
	}

	public void setNotaExamenPractico(double nota) {
		this.notaExamenPractico = nota;
	}

	public double notaFinal() {
		return notaExamenTeorico + notaExamenPractico;
	}

	public int compareTo(Alumno a) {
		int comp = this.nombre.compareToIgnoreCase(a.nombre);

		if (a == null)
			return -1;

		if (comp == 0) {
			if (this.notaFinal() < a.notaFinal()) {
				return -1;
			} else if (this.notaFinal() > a.notaFinal()) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return comp;
		}
	}

	public boolean equals(Object o) {
		if (!(o instanceof Alumno) || (o == null)) {
			return false;
		} else {
			return nombre.equalsIgnoreCase(((Alumno) o).nombre);
		}
	}

	public int hashCode() {
		return this.nombre.hashCode();
	}

	public String toString() {
		return ("Alumno [" + this.nombre + ", " + this.notaFinal() + "]");
	}
}
