public class TestAlumnos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Alumno nuevo = new Alumno("Juan", 2, 7);
		AlumnoVoluntarioso huevos = new AlumnoVoluntarioso("Juan", 2, 7, 1.5, 1.5);
		Alumno nuevo2 = new Alumno("Juan", 2, 7);
		System.out.println(nuevo);
		System.out.println(huevos);
		System.out.println(nuevo2);
		
		Alumno al1 = new Alumno("Juan", 1, 4);
		Alumno al2 = new Alumno("Juan", 1, 4);
		
		int i = al1.compareTo(al2);
		System.out.println("Comparando alumnos: " + i);
		AlumnoVoluntarioso huevos2 = new AlumnoVoluntarioso("Pepe", 1, 4, 0.75, 0);
		if (nuevo.equals(huevos)) {
			System.out.println("Alumno matriculado dos veces.");
		} else {
			System.out.println("Alumno matriculado correctamente.");
		}
		
		int j = nuevo.compareTo(huevos);
		
		System.out.println("Comparando nombres y notas: " + j);
		
		//i = nuevo.compareTo(huevos.notaFinal());
		System.out.println("Comparando notas: " + i);
		
	}

}
