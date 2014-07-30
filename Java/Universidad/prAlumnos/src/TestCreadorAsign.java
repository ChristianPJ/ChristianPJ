import java.util.*;


public class TestCreadorAsign {
	
	public static void main(String[] args)
	{
		List<String> lista = new LinkedList<String>();
		Alumno nuevo = new Alumno("Juan", 2, 7);
		lista.add("Ingeniero");
		lista.add("A");
		//lista.add(nuevo.nombreAlumno());
		lista.add(Double.toString(nuevo.getNotaExamenTeorico()));
		lista.add(Double.toString(nuevo.getNotaExamenPractico()));
		
		
		CreadorAsignatura asignatura = new CreadorAsignatura("LTO",lista);
		System.out.println(asignatura);
	}
}
