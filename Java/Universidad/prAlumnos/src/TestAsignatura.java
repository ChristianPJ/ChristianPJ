import java.util.ArrayList;
import java.util.List;

public class TestAsignatura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Asignatura alumnos = new Asignatura("LTO");
		Alumno al1 = new Alumno("Juan", 1, 4);
		Alumno al2 = new Alumno("pepe", 2, 2);
		Alumno al3 = new Alumno("Pedro", 1.5, 4);
		Alumno al4 = new Alumno("Julian", 1, 4);
		Alumno al5 = new Alumno("Luisa", 1, 4);
		Alumno al6 = new Alumno("Macarena", 1, 4);
		Alumno al7 = new Alumno("Luis", 1, 4);
		Alumno al8 = new Alumno("Luis", 1, 4);
		
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.A, al1);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.A, al2);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.A, al3);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.B, al4);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.B, al5);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.B, al6);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.B, al7);
		alumnos.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.B, al8);
		
		System.out.println("Alumnos de las asignaturas: " + alumnos);
		List<String> list = new ArrayList<String>();
		list.add("II:A:Juan Cañete:1:4");
		Asignatura asign = new Asignatura("LTO");
		
		asign.agregaAlumno(Asignatura.Especialidad.II, Asignatura.Grupo.A, al2);
		System.out.println("Alumnos de las asignaturas: " + asign);
		CreadorAsignatura asignatura = new CreadorAsignatura("LTO", list);
		
		
	}

}
