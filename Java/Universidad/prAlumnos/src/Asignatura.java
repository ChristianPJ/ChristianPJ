import java.util.*;

public class Asignatura {
	static enum Especialidad {
		II, ITIS, ITIG
	};

	static enum Grupo {
		A, B, C
	};

	private String nombreasign;
	private Map<Especialidad, Map<Grupo, Set<Alumno>>> mapa;

	public Asignatura(String nombre) {
		this.nombreasign = nombre;
		mapa = new HashMap<Especialidad, Map<Grupo, Set<Alumno>>>();
	}

	public boolean agregaAlumno(Especialidad es, Grupo gr, Alumno al) {
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] gru = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgru = gru.length;

		int x = 0, y;

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> grupo = mapa.get(esp[x]);

				y = 0;

				while (y < lgru) {
					if (grupo.containsKey(gru[y])) {
						Set<Alumno> alumnos = grupo.get(gru[y]);

						for (Alumno a : alumnos) {
							if (a.equals(al)) {
								return false;
							}
						}
					}
					y++;
				}
			}
			x++;
		}

		if (mapa.containsKey(es)) {
			Map<Grupo, Set<Alumno>> grp = mapa.get(es);

			if (grp.containsKey(gr)) {
				grp.get(gr).add(al);
			} else // No hay grupo en esta especialidad
			{
				Set<Alumno> alum = new HashSet<Alumno>();
				alum.add(al);
				grp.put(gr, alum);
			}
		} else // No existe la especialidad, la creamos
		{
			Map<Grupo, Set<Alumno>> gg = new TreeMap<Grupo, Set<Alumno>>();
			Set<Alumno> aa = new HashSet<Alumno>();
			aa.add(al);
			gg.put(gr, aa);
			mapa.put(es, gg);
		}
		return true;
	}

	public Set<Alumno> alumnosPorNombre(Especialidad es, Grupo gr,
			Filtro<Alumno> filtro) {
		Set<Alumno> conj = new TreeSet<Alumno>();

		if (mapa.containsKey(es)) {
			Map<Grupo, Set<Alumno>> grp = mapa.get(es);
			if (grp.containsKey(gr)) {
				Set<Alumno> al = grp.get(gr);

				for (Alumno a : al) {
					if (filtro != null) {
						if (filtro.filtro(a)) {
							conj.add(a);
						}
					} else {
						conj.add(a);
					}
				}
			}
		}
		return conj;
	}

	public Set<Alumno> alumnosPorNombre(Filtro<Alumno> filtro) {
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grp = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrp = grp.length;
		int x = 0, y;

		Set<Alumno> conj = new TreeSet<Alumno>();

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;
				while (y < lgrp) {
					if (gg.containsKey(grp[y])) {
						Set<Alumno> aa = gg.get(grp[y]);

						for (Alumno a : aa) {
							if (filtro != null) {
								if (filtro.filtro(a)) {
									conj.add(a);
								}
							} else {
								conj.add(a);
							}
						}
					}
					y++;
				}
			}
			x++;
		}

		return conj;
	}

	// ----------------------------------------------------------------------
	public class OrdenNota implements Comparator<Alumno> {
		public int compare(Alumno al1, Alumno al2) {
			if (al1.notaFinal() < al2.notaFinal()) {
				return 1;
			} else if (al1.notaFinal() > al2.notaFinal()) {
				return -1;
			} else {
				return al1.getNombre().compareToIgnoreCase(
						al2.getNombre());
			}
		}
	}

	// -------------------------------------------------------------------------
	public Set<Alumno> alumnosPorNota(Especialidad es, Grupo gr,
			Filtro<Alumno> filtro) {
		Comparator<Alumno> orden = new OrdenNota();
		Set<Alumno> conj = new TreeSet<Alumno>(orden);

		if (mapa.containsKey(es)) {
			Map<Grupo, Set<Alumno>> grp = mapa.get(es);

			if (grp.containsKey(gr)) {
				Set<Alumno> al = grp.get(gr);

				for (Alumno a : al) {
					if (filtro != null) {
						if (filtro.filtro(a))
							conj.add(a);
					} else {
						conj.add(a);
					}
				}
			}
		}

		return conj;
	}

	public Set<Alumno> alumnosPorNota(Filtro<Alumno> filtro) {
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grup = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrup = grup.length;
		Comparator<Alumno> orden = new OrdenNota();
		Set<Alumno> conj = new TreeSet<Alumno>(orden);
		int x = 0, y;

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;
				while (y < lgrup) {
					if (gg.containsKey(grup[y])) {
						Set<Alumno> aa = gg.get(grup[y]);

						for (Alumno a : aa) {
							if (filtro != null) {
								if (filtro.filtro(a)) {
									conj.add(a);
								}
							} else {
								conj.add(a);
							}
						}
					}
					y++;
				}
			}
			x++;
		}
		return conj;
	}

	public Alumno alumno(String nombre) {
		Alumno al = null;
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grup = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrup = grup.length;
		int x = 0, y;

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;
				while (y < lgrup) {
					if (gg.containsKey(grup[y])) {
						Set<Alumno> aa = gg.get(grup[y]);

						for (Alumno a : aa) {
							if (a.getNombre().equalsIgnoreCase(nombre))
								al = a;
						}
					}
					y++;
				}
			}
			x++;
		}
		return al;
	}

	public String especialidadGrupo(Alumno al) {
		String cad = null;
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grup = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrup = grup.length;
		int x = 0, y;

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;

				while (y < lgrup) {
					if (gg.containsKey(grup[y])) {
						Set<Alumno> aa = gg.get(grup[y]);

						for (Alumno a : aa) {
							if (a.equals(al)) {
								return cad = esp[x].name() + ":"
										+ grup[y].name();
							}
						}
					}
					y++;
				}
			}
			x++;
		}

		return cad;
	}

	public Map<Alumno.Calificacion, Set<Alumno>> alumnosPorCalificacion() {
		Map<Alumno.Calificacion, Set<Alumno>> ret = new TreeMap<Alumno.Calificacion, Set<Alumno>>();
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grp = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrp = grp.length;
		int x = 0, y;

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;

				while (y < lgrp) {
					if (gg.containsKey(grp[y])) {
						Set<Alumno> aa = gg.get(grp[y]);

						for (Alumno a : aa) {
							Alumno.Calificacion calif = a.calificacion();

							if (ret.containsKey(calif)) {
								ret.get(calif).add(a);
							} else {
								Comparator<Alumno> orden = new OrdenNota();
								Set<Alumno> al = new TreeSet<Alumno>(orden);
								al.add(a);
								ret.put(calif, al);
							}
						}
					}
					y++;
				}
			}
			x++;
		}
		return ret;
	}

	public Map<Alumno.Calificacion, Map<Especialidad, Integer>> resumen() {
		Map<Alumno.Calificacion, Map<Especialidad, Integer>> ret = new TreeMap<Alumno.Calificacion, Map<Especialidad, Integer>>();
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grup = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrup = grup.length;
		int x = 0, y;

		while (x < lesp) {
			if (mapa.containsKey(esp[x])) {
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;

				while (y < lgrup) {
					if (gg.containsKey(grup[y])) {
						Set<Alumno> aa = gg.get(grup[y]);

						for (Alumno a : aa) {
							Alumno.Calificacion calif = a.calificacion();

							if (ret.containsKey(calif)) {
								Map<Especialidad, Integer> mesp = ret
										.get(calif);

								if (mesp.containsKey(esp[x])) {
									int num = mesp.get(esp[x]) + 1;
									ret.get(calif).put(esp[x], num);
								} else {
									ret.get(calif).put(esp[x], 1);
								}
							} else {
								Map<Especialidad, Integer> cmesp = new TreeMap<Especialidad, Integer>();
								cmesp.put(esp[x], 1);
								ret.put(calif, cmesp);
							}
						}
					}
					y++;
				}
			}
			x++;
		}
		return ret;
	}
	
	public String toString()
	{
		Asignatura.Especialidad[] esp = Asignatura.Especialidad.values();
		Asignatura.Grupo[] grp = Asignatura.Grupo.values();
		int lesp = esp.length;
		int lgrp = grp.length;
		int x = 0, y;
		String cad = "Asignatura: " + this.nombreasign + "\n";
		
		while(x < lesp)
		{
			if(mapa.containsKey(esp[x]))
			{
				Map<Grupo, Set<Alumno>> gg = mapa.get(esp[x]);
				y = 0;
				cad += "Especialidad: " + esp[x].toString() + "\n";
				
				while(y < lgrp)
				{
					if(gg.containsKey(grp[y]))
					{
						Set<Alumno> alum = gg.get(grp[y]);
						cad += "Grupo: " + grp[y].toString() + "\n";
						
						for(Alumno a:alum)
						{
							cad += a + "\n";
						}
					}
					y++;
				}
			}
			x++;
		}
		
		return cad;
	}
}
