import java.util.Iterator;
import ine5408.estruturas.EstruturaDados;
import ine5408.estruturas.ExcecaoEstruturaVazia;

public interface Pilha<E> extends EstruturaDados<E> {

	public void empilha(E elemento);

	public E desempilha() throws ExcecaoEstruturaVazia;

	public E topo() throws ExcecaoEstruturaVazia;

	public boolean contem(E elemento);

	public int retornaPosicao(E elemento);

	public Iterator<E> retornaIterator();
}