

import listas.*;

public class TestLista {
public static void main(String[] args) throws Exception{
Lista<Number> lis = new ListaEnlazada<Number>();
lis.insertar(0, 1000);
System.out.println(lis);
for (int i = 0; i < 10; i++) {
lis.agregar(i);
}
lis.insertar(11, 1.5);
for (int i = 0; i < lis.longitud(); i++) {
	System.out.println(lis.elemento(i));
		}
System.out.println(lis);
lis.eliminar(11);
System.out.println(lis);
System.out.println("Contenido de la lista: " + lis
+ " 0: " + lis.elemento(0)
+ " 2: " + lis.elemento(2)
+ " 10: " + lis.elemento(10));
lis.insertar(1, 2000);
System.out.println(lis);
}
}