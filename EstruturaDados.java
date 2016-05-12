

/**
 * Representa uma estrutura de dados.
 * @author Patricia
 *
 */
public interface EstruturaDados <E>{

	/**
	 * Verifica se a estrutura est� vazia. Uma estrutura vazia cont�m zero elementos.
	 * @return True se a estrutura n�o possui nenhum elemento e false caso contr�rio.
	 */
	public boolean estaVazia();
	
	/**
	 * Remove todos os elementos da estrutura de dados.
	 *
	 */
	public void esvazie();
	
	/**
	 * Calcula quantos elementos est�o armazenados na estrutura de dados. 
	 * @return A quantidade de elementos da estrutura.
	 */
	public int numeroElementos();

	

}
