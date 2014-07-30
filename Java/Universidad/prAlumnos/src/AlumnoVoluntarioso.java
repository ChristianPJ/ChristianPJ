public class AlumnoVoluntarioso extends Alumno {
	double notaPractica1, notaPractica2;

	public AlumnoVoluntarioso(String nombre, double notaExamenTeo,
			double notaExamenPrac, double notaPrac1, double notaPrac2) {
		super(nombre, notaExamenTeo, notaExamenPrac);

		if ((notaPrac1 >= 0 && notaPrac1 <= 1.5)
				&& (notaPrac2 >= 0 && notaPrac2 <= 1.5)) {
			this.notaPractica1 = notaPrac1;
			this.notaPractica2 = notaPrac2;
		} else {
			throw new RangoException(
					"Error..Notas de Practicas Fuera de Rango.");
		}
	}

	public double notaFinal() {
		double sumprac = notaPractica1 + notaPractica2;

		return super.getNotaExamenTeorico() + sumprac
				+ ((((8 - sumprac)) * super.getNotaExamenPractico()) / 8);
	}

	public double getNotaPractica1() {
		return this.notaPractica1;
	}

	public double getNotaPractica2() {
		return this.notaPractica2;
	}
}
