
import ine5408.estruturas.ExcecaoElementoInexistente;
import java.util.Iterator;

/**
 * @author Patricia
 *
 * @param <C> Tipo dos elementos que podem ser incluídos na árvore binária.
 */
public interface ArvoreBinaria<C extends Comparable<C>> extends EstruturaDados<C>{
		
	/**
	 * Insere o elemento na árvore de busca binária.
	 * Apos a inserção, a árvore continua sendo uma árvore de busca.
	 * @param elemento Elemento a ser inserido na árvore de busca binária.
	 */
	public void insere (C elemento);
		
	/**
	 * Remove o elemento da árvore binária.
	 * @param elemento Elemento que será removido da árvore.
	 * @throws ExcecaoElementoInexistente se o elemento não existir. Após a remoção, a árvore continua sendo uma árvore binária.
	 */
	public void remove (C elemento) throws ExcecaoElementoInexistente;

	/**
	 * Verifica a existência de um elemento na árvore binária.
	 * @param elemento O elemento que está sendo procurado na árvore binária.
	 * @return TRUE se o elemento existe na árvore binária.
	 */
	public boolean contem (C elemento);
		
	/**
	 * Retorna o elemento da árvore binária igual ao elemento passado como parâmetro.
	 * @param elemento Elemento igual ao que será retornado.
	 * @return O elemento da árvore binária igual ao elemento passado como parâmetro. Se o elemento não existir, retorna null.
	 */
	public C retorna (C elemento);
	
	/**
	 * Retorna o número de filhos de um elemento da árvore de busca binária.
	 * @param elemento O elemento cujo grau será retornado.
	 * @return O grau, ou seja, o número de filhos do elemento.
	 * @throws ExcecaoElementoInexistente se o elemento não existir na árvore de busca binária.
	 */
	public int retornaGrau (C elemento) throws ExcecaoElementoInexistente;
	
	/**
	 * Retorna o elemento que é a raiz da árvore de busca binária.
	 * @return O elemento que é a raiz da árvore de busca binária.
	 */
	public C retornaRaiz ();

	/**
	 * Retorna o pai do elemento.
	 * @param elemento O elemento cujo pai será retornado.
	 * @return O pai do elemento. Se o elemento for a raiz da árvore de busca binária, retorna null.
	 * @throws ExcecaoElementoInexistente se o elemento não existir na árvore de busca binária.
	 */
	public C retornaPai (C elemento) throws ExcecaoElementoInexistente;
	
	/**
	 * Retorna a árvore esquerda de um elemento da árvore de busca binária.
	 * @param elemento O elemento cuja árvore esquerda será retornada.
	 * @return A árvore esquerda do elemento.
	 * @throws ExcecaoElementoInexistente se o elemento não existir.
	 */
	public ArvoreBinaria<C> retornaArvoreEsquerda (C elemento) throws ExcecaoElementoInexistente;
		
	/**
	 * Retorna a árvore direita de um elemento da árvore de busca binária.
	 * @param elemento O elemento cuja árvore direita será retornada.
	 * @return A árvore direita do elemento. 
	 * @throws ExcecaoElementoInexistente se o elemento não existir.
	 */
	public ArvoreBinaria<C> retornaArvoreDireita (C elemento) throws ExcecaoElementoInexistente;

	/**
	 * Retorna o comprimento entre a origem e o destino.
	 * @param origem Origem do caminho.
	 * @param destino Destino do caminho.
	 * @return Retorna o comprimento entre a origem e o destino.
	 * @throws ExcecaoElementoInexistente se não existir caminho entre a origem e o destino.
	 */
	public int retornaComprimento (C origem, C destino) throws ExcecaoElementoInexistente;	

	/**
	 * Retorna a altura da árvore de busca binára.
	 * @return A altura da árvore. Se a árvore não tiver nenhum elemento, retorna -1.
	 * Se a árvore tiver somente um elemento, retorna 0.
	 */
	public int retornaAltura ();
	
	/** 
	 * Verifica se o primeiro elemento é ascendente do segundo elemento.
	 * @param ascendente Elemento ascendente.
	 * @param descendente Elemento descendente.
	 * @return TRUE se o primeiro elemento é ascendente do segundo elemento.
	 */
	public boolean ehAncestral (C ascendente, C descendente);
	
	/**
	 * Iterator dos elementos da árvore de busca binária em pré-ordem.
	 * @return Um iterator dos elementos em pré-ordem.
	 */
	public Iterator<C> retornaIteratorPreOrdem ();

	/** 
	 * Iterator dos elementos da árvore de busca binária em in-ordem.
	 * @return Um iterator dos elementos em in-ordem.
	 */
	public Iterator<C> retornaIteratorInOrdem ();
	
	/** 
	 * Iterator dos elementos da árvore de busca binária em pós-ordem.
	 * @return Um iterator dos elementos em pós-ordem.
	 */
	public Iterator<C> retornaIteratorPosOrdem ();
		
}
