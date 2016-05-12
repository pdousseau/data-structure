
import ine5408.estruturas.ExcecaoElementoInexistente;
import java.util.Iterator;

/**
 * @author Patricia
 *
 * @param <C> Tipo dos elementos que podem ser inclu�dos na �rvore bin�ria.
 */
public interface ArvoreBinaria<C extends Comparable<C>> extends EstruturaDados<C>{
		
	/**
	 * Insere o elemento na �rvore de busca bin�ria.
	 * Apos a inser��o, a �rvore continua sendo uma �rvore de busca.
	 * @param elemento Elemento a ser inserido na �rvore de busca bin�ria.
	 */
	public void insere (C elemento);
		
	/**
	 * Remove o elemento da �rvore bin�ria.
	 * @param elemento Elemento que ser� removido da �rvore.
	 * @throws ExcecaoElementoInexistente se o elemento n�o existir. Ap�s a remo��o, a �rvore continua sendo uma �rvore bin�ria.
	 */
	public void remove (C elemento) throws ExcecaoElementoInexistente;

	/**
	 * Verifica a exist�ncia de um elemento na �rvore bin�ria.
	 * @param elemento O elemento que est� sendo procurado na �rvore bin�ria.
	 * @return TRUE se o elemento existe na �rvore bin�ria.
	 */
	public boolean contem (C elemento);
		
	/**
	 * Retorna o elemento da �rvore bin�ria igual ao elemento passado como par�metro.
	 * @param elemento Elemento igual ao que ser� retornado.
	 * @return O elemento da �rvore bin�ria igual ao elemento passado como par�metro. Se o elemento n�o existir, retorna null.
	 */
	public C retorna (C elemento);
	
	/**
	 * Retorna o n�mero de filhos de um elemento da �rvore de busca bin�ria.
	 * @param elemento O elemento cujo grau ser� retornado.
	 * @return O grau, ou seja, o n�mero de filhos do elemento.
	 * @throws ExcecaoElementoInexistente se o elemento n�o existir na �rvore de busca bin�ria.
	 */
	public int retornaGrau (C elemento) throws ExcecaoElementoInexistente;
	
	/**
	 * Retorna o elemento que � a raiz da �rvore de busca bin�ria.
	 * @return O elemento que � a raiz da �rvore de busca bin�ria.
	 */
	public C retornaRaiz ();

	/**
	 * Retorna o pai do elemento.
	 * @param elemento O elemento cujo pai ser� retornado.
	 * @return O pai do elemento. Se o elemento for a raiz da �rvore de busca bin�ria, retorna null.
	 * @throws ExcecaoElementoInexistente se o elemento n�o existir na �rvore de busca bin�ria.
	 */
	public C retornaPai (C elemento) throws ExcecaoElementoInexistente;
	
	/**
	 * Retorna a �rvore esquerda de um elemento da �rvore de busca bin�ria.
	 * @param elemento O elemento cuja �rvore esquerda ser� retornada.
	 * @return A �rvore esquerda do elemento.
	 * @throws ExcecaoElementoInexistente se o elemento n�o existir.
	 */
	public ArvoreBinaria<C> retornaArvoreEsquerda (C elemento) throws ExcecaoElementoInexistente;
		
	/**
	 * Retorna a �rvore direita de um elemento da �rvore de busca bin�ria.
	 * @param elemento O elemento cuja �rvore direita ser� retornada.
	 * @return A �rvore direita do elemento. 
	 * @throws ExcecaoElementoInexistente se o elemento n�o existir.
	 */
	public ArvoreBinaria<C> retornaArvoreDireita (C elemento) throws ExcecaoElementoInexistente;

	/**
	 * Retorna o comprimento entre a origem e o destino.
	 * @param origem Origem do caminho.
	 * @param destino Destino do caminho.
	 * @return Retorna o comprimento entre a origem e o destino.
	 * @throws ExcecaoElementoInexistente se n�o existir caminho entre a origem e o destino.
	 */
	public int retornaComprimento (C origem, C destino) throws ExcecaoElementoInexistente;	

	/**
	 * Retorna a altura da �rvore de busca bin�ra.
	 * @return A altura da �rvore. Se a �rvore n�o tiver nenhum elemento, retorna -1.
	 * Se a �rvore tiver somente um elemento, retorna 0.
	 */
	public int retornaAltura ();
	
	/** 
	 * Verifica se o primeiro elemento � ascendente do segundo elemento.
	 * @param ascendente Elemento ascendente.
	 * @param descendente Elemento descendente.
	 * @return TRUE se o primeiro elemento � ascendente do segundo elemento.
	 */
	public boolean ehAncestral (C ascendente, C descendente);
	
	/**
	 * Iterator dos elementos da �rvore de busca bin�ria em pr�-ordem.
	 * @return Um iterator dos elementos em pr�-ordem.
	 */
	public Iterator<C> retornaIteratorPreOrdem ();

	/** 
	 * Iterator dos elementos da �rvore de busca bin�ria em in-ordem.
	 * @return Um iterator dos elementos em in-ordem.
	 */
	public Iterator<C> retornaIteratorInOrdem ();
	
	/** 
	 * Iterator dos elementos da �rvore de busca bin�ria em p�s-ordem.
	 * @return Um iterator dos elementos em p�s-ordem.
	 */
	public Iterator<C> retornaIteratorPosOrdem ();
		
}
