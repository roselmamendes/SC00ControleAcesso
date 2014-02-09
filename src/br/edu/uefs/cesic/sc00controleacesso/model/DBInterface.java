package br.edu.uefs.cesic.sc00controleacesso.model;

public interface DBInterface<E> {
	
	/**
	 * Antes de usar esse método chame o método obtemInstancia da classe DBHelper.
	 * @param lab
	 */
	public int inserirAtualizar(E objeto);
	
	/**
	 * Antes de usar esse método chame o método obtemInstancia da classe DBHelper.
	 * @param lab
	 */
	public int excluir(Object[] chave);
	
	/**
	 * Antes de usar esse método chame o método obtemInstancia da classe DBHelper.
	 * @param lab
	 */
	public E buscar(Object[] chave);

}
