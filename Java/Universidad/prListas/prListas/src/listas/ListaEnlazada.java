package listas;

public class ListaEnlazada<T> implements Lista<T> {
	private Nodo<T> Nodotemp = null;
	private Nodo<T> Nodotemp2 = null;

	public int numElementos;
	private Nodo<T> primero;
	private Nodo<T> ultimo;

	static class Nodo<S> {
		public S dato;
		public Nodo<S> siguiente;

		public Nodo(S v) {
			dato = v;
			siguiente = null;
		}

		public Nodo(S v, Nodo<S> sig) {
			dato = v;
			siguiente = sig;
		}
	}

	public ListaEnlazada() {
		primero = null;
		ultimo = null;
		numElementos = 0;
	}

	public void insertar(int pos, T elem) throws Exception {
		Nodo<T> nuevoNodo = new Nodo<T>(elem);
		Nodo<T> tempNodo = null;
		if (longitud() < pos) {
			throw new Exception("Error");
		} else {
			tempNodo = primero;
			if (pos == 0) {
				primero = nuevoNodo;
				ultimo = nuevoNodo;
				numElementos++;
			} else {
				for (int i = 0; i < pos-1; i++) {
					tempNodo = tempNodo.siguiente;
				}
				nuevoNodo.siguiente = tempNodo.siguiente;
				tempNodo.siguiente = nuevoNodo;
				numElementos++;
			}
		}
	}

	public void eliminar(int pos) throws Exception {
		Nodo<T> tempNodo;
		Nodo<T> tempNodo2;
		if (longitud() < pos) {
			throw new Exception("Error");
		} else {
			tempNodo = null;
			tempNodo2 = null;
			tempNodo = primero;
			for (int i = 0; i < pos-1; i++) {
				tempNodo2 = tempNodo;
				tempNodo = tempNodo.siguiente;
			}
			tempNodo2.siguiente = tempNodo.siguiente;
			numElementos--;
		}
	}

	public T elemento(int pos) throws Exception {
		Nodo<T> tempNodo;
		if (longitud() < pos) {
			throw new Exception("Error");
		} else {
			tempNodo = null;
			tempNodo = primero;
			for (int i = 0; i < pos; i++) {
				tempNodo = tempNodo.siguiente;
			}
			return tempNodo.dato;
		}
	}

	public void agregar(T elem) {
		Nodo<T> nuevoNodo = new Nodo<T>(elem);
		Nodo<T> tempNodo = null;

		if (numElementos == 0) {
			primero = nuevoNodo;
			ultimo = nuevoNodo;
			numElementos++;
		} else {
			tempNodo=ultimo;
			tempNodo.siguiente=nuevoNodo;
			ultimo = nuevoNodo;
			numElementos++;
		}

	}

	public boolean esVacia() {
		return numElementos == 0;
	}

	public int longitud() {
		return numElementos;
	}
	public void visualizar(){
		Nodo<T> tempNodo = null;
		tempNodo = primero;
		for (int i = 0; i < numElementos; i++) {
			System.out.println(tempNodo.dato);	
			tempNodo = tempNodo.siguiente;
			
		}
	}

}
