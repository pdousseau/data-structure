import java.util.Iterator;
import java.util.NoSuchElementException;
import ine5408.estruturas.ExcecaoEstruturaVazia;

public class PilhaArray<E> implements Pilha<E> {
	private E[] elementos;
	private int numElementos;

	@SuppressWarnings("unchecked")
	public PilhaArray(int tamanho) {
		this.elementos = (E[]) new Object[tamanho];
	}

	@SuppressWarnings("unchecked")
	public PilhaArray() {
		this.elementos = (E[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	public void empilha(E elemento) {
		if (this.numElementos == this.elementos.length) {
			E[] novoArray = (E[]) new Object[this.elementos.length * 2];
			System.arraycopy(elementos, 0, novoArray, 0, this.elementos.length);
			this.elementos = novoArray;
		}
		this.elementos[this.numElementos] = elemento;
		this.numElementos++;
	}

	public E desempilha() throws ExcecaoEstruturaVazia {
		if (this.numElementos > 0) {
			E elemento = this.elementos[this.numElementos-1];
			this.elementos[this.numElementos-1] = null;
			this.numElementos--;
			return elemento;
		}
		else
			throw new ExcecaoEstruturaVazia ("piha vazia!");
		}

	public E topo() throws ExcecaoEstruturaVazia {
		if (this.numElementos > 0)
			return this.elementos[this.numElementos - 1];
		else
			throw new ExcecaoEstruturaVazia("piha vazia!");
	}

	public boolean contem(E elemento) {
		for(int i=0; i<numElementos;i++){
			if(this.elementos[i].equals(elemento))
				return true;
		}
		return false;
	}

	public Iterator<E> retornaIterator() {
		return new IteratorPilha();
	}

	public int retornaPosicao(E elemento) {
		for(int i=0; i<numElementos;i++){
			if(this.elementos[i].equals(elemento))
				return i;
		}
		return -1;
	}

	public boolean estaVazia() {
		if (numElementos==0)
			return true;
		return false;
	}

	public void esvazie() {
		int n = numElementos;
		for(int i=0;i<n;i++){
			this.elementos[i] = null;
			numElementos--;
		}
	}

	public int numeroElementos() {
		return numElementos;
	}
	
	protected class IteratorPilha implements Iterator<E>{
        private int posicao;

        public boolean hasNext() {
            return (posicao+1)<=numeroElementos();
        }

        public E next() {
            if (hasNext()){
                return PilhaArray.this.elementos[posicao++];
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}