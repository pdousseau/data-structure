

/**
 * Representa uma estrutura de dados.
 * @author Patricia
 *
 */
public interface EstruturaDados <E>{

	/**
	 * Verifica se a estrutura está vazia. Uma estrutura vazia contém zero elementos.
	 * @return True se a estrutura não possui nenhum elemento e false caso contrário.
	 */
	public boolean estaVazia();
	
	/**
	 * Remove todos os elementos da estrutura de dados.
	 *
	 */
	public void esvazie();
	
	/**
	 * Calcula quantos elementos estão armazenados na estrutura de dados. 
	 * @return A quantidade de elementos da estrutura.
	 */
	public int numeroElementos();

	

}
