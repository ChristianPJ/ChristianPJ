import java.util.*;

public class CreadorAsignatura {

	Asignatura asign;
	Map<String, List<String>> prob;

	public CreadorAsignatura(String nombre, List<String> datos) {

		if (datos != null) {
			asign = new Asignatura(nombre);
			prob = new HashMap<String, List<String>>();
			
			String iae = "IllegalArgumentException";
			String nsee = "NoSuchElementException";
			String nfe = "NumberFormatException";
			String range = "RangoException";
			
			for (String cad : datos) {
				StringTokenizer tc = new StringTokenizer(cad, ":");
				int ntoken = tc.countTokens();
				try {
					if ((ntoken < 5) || (ntoken > 7)) {
						throw new NoSuchElementException();
					} else // Recogemos los datos
					{
						int i = 1;
						Asignatura.Especialidad esp = null;
						Asignatura.Grupo grupo = null;
						double nt = 0, np = 0, np1 = 0, np2 = 0;
						String nomb = null;

						while (tc.hasMoreTokens()) {
							String t = tc.nextToken();
							switch (i) {
							case 1:
								esp = Asignatura.Especialidad.valueOf(t);
								break;

							case 2:
								grupo = Asignatura.Grupo.valueOf(t);
								break;

							case 3:
								nomb = t;
								break;

							case 4:
								nt = Double.valueOf(t);
								break;

							case 5:
								np = Double.valueOf(t);
								break;

							case 6:
								np1 = Double.valueOf(t);
								break;

							case 7:
								np2 = Double.valueOf(t);
								break;
							}
							i++;
						}

						if (ntoken == 5) {
							if (((nt >= 0) && (nt <= 2))
									|| ((np >= 0) && (np <= 8))) {
								Alumno al5 = new Alumno(nomb, nt, np);
								System.out.println("Alumnos de las asignaturas: " + al5);
								asign.agregaAlumno(esp, grupo, al5);
							} else {
								throw new RangoException();
							}
						}
						if (ntoken == 6) {
							if (((nt >= 0) && (nt <= 2))
									|| ((np >= 0) && (np <= 8))
									|| ((np1 >= 0) && (np1 <= 1.5))) {
								Alumno al6 = new AlumnoVoluntarioso(nomb, nt,
										np, np1, 0);
								asign.agregaAlumno(esp, grupo, al6);
							} else {
								throw new RangoException();
							}
						}
						if (ntoken == 7) {
							if (((nt >= 0) && (nt <= 2))
									|| ((np >= 0) && (np <= 8))
									|| ((np1 >= 0) && (np1 <= 1.5))
									|| ((np2 >= 0) && (np2 <= 1.5))) {
								Alumno al7 = new AlumnoVoluntarioso(nomb,nt,np,np1,np2);
								asign.agregaAlumno(esp, grupo, al7);
							}else
							{
								throw new RangoException();
							}
						}
					}
				} catch (RangoException e) {
					if(prob.containsKey(range))
					{
						prob.get(range).add(cad + ">>" + e.getMessage());
					}else
					{
						List<String> lrange = new ArrayList<String>();
						lrange.add(cad + ">>" + e.getMessage());
						prob.put(range, lrange);
					}
				}catch(NoSuchElementException e)
				{
					if(prob.containsKey(nsee))
					{
						prob.get(nsee).add(cad + ">>" + e.getMessage());
					}else
					{
						List<String> lnsee = new ArrayList<String>();
						lnsee.add(cad + ">>" + e.getMessage());
						prob.put(nsee, lnsee);
					}
				}catch(NumberFormatException e)
				{
					if(prob.containsKey(nfe))
					{
						prob.get(nfe).add(cad + ">>" + e.getMessage());
					}else
					{
						List<String> lnfe = new ArrayList<String>();
						lnfe.add(cad + ">>" + e.getMessage());
						prob.put(nfe, lnfe);
					}
				}catch(IllegalArgumentException e)
				{
					if(prob.containsKey(iae))
					{
						prob.get(iae).add(cad + ">>" + e.getMessage());
					}else
					{
						List<String> liae = new ArrayList<String>();
						liae.add(cad + ">>" + e.getMessage());
						prob.put(iae, liae);
					}
				}
			}
		}
	}
	
	public Map<String,List<String>> getIncorrectos()
	{
		return prob;
	}
	
	public Asignatura getAsignatura()
	{
		return asign;
	}
}
