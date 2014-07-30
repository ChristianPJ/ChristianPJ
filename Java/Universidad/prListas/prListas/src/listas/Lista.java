package listas;


public interface Lista<T> extends Vaciable{
	
	public void insertar(int pos, T elem)throws Exception;
	public void eliminar(int pos)throws Exception;
	public T elemento(int pos) throws Exception;
	public void agregar(T elem);
	public void visualizar();
}
