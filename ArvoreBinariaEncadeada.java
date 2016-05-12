import java.util.Iterator;
import java.util.NoSuchElementException;

import ine5408.estruturas.ArvoreBinaria;

public class ArvoreBinariaEncadeada<C extends Comparable<C>> implements
		ArvoreBinaria<C> {
	C elem;
	ArvoreBinariaEncadeada<C> esq;
	ArvoreBinariaEncadeada<C> dir;

	public ArvoreBinariaEncadeada() {
		this.elem = null;
		this.esq = null;
		this.dir = null;
	}

	public boolean contem(C elemento) {
		if (this.elem == null)
			return false;
		else {
			int comp = elemento.compareTo(this.elem);
			if (comp == 0)
				return true;
			else if (comp < 0)
				return this.esq.contem(elemento);
			else
				return this.dir.contem(elemento);
		}
	}

	public boolean metodoEquals(ArvoreBinariaEncadeada<C> arvoreA){
		if(arvoreA.numeroElementos()!=this.numeroElementos())
			return false;
		else{
			Iterator<C> iteradorA = arvoreA.retornaIteratorPreOrdem();
			Iterator<C> iteradorB = this.retornaIteratorPreOrdem();
			while(iteradorA.hasNext()){
				if(!iteradorA.next().equals(iteradorB.next())){
					return false;
				}
			}
		return true;
		}
	}
	
	public void insere(C elemento) {
		if (this.elem == null) {
			this.elem = elemento;
			this.esq = new ArvoreBinariaEncadeada<C>();
			this.dir = new ArvoreBinariaEncadeada<C>();
		} else if (elemento.compareTo(this.elem) < 0)
			this.esq.insere(elemento);
		else
			this.dir.insere(elemento);
	}

	public int numeroElementos() {
		if (this.elem == null)
			return 0;
		else
			return this.esq.numeroElementos() + this.dir.numeroElementos() + 1;
	}

	public boolean ehAncestral(C ascendente, C descendente) {
		if (this.elem.compareTo(ascendente)<0)
			return this.dir.ehAncestral(ascendente, descendente);
		else if (this.elem.compareTo(ascendente)>0)
			return this.esq.ehAncestral(ascendente, descendente);
		else{
			return contem(descendente);
		}
		
	}

	public void remove(C elemento) {
		if(this.elem.compareTo(elemento)==0)
			this.elem=null;
		else if(this.elem.compareTo(elemento)<0)
			this.dir.remove(elemento);
		else
			this.esq.remove(elemento);
	}

	public C retorna(C elemento) {
		if(this.elem.compareTo(elemento)==0)
			return this.elem;
		else if(this.elem.compareTo(elemento)>0)
			return this.esq.retorna(elemento);
		else
			return this.dir.retorna(elemento);
	}

	public int retornaAltura() {
        if(this.elem==null)
            return -1;
        return Math.max(this.dir.retornaAltura(), this.esq.retornaAltura())+1;
    }
	
	public ArvoreBinariaEncadeada<C> retornaArvoreDireita(C elemento) {
			if(this.elem.compareTo(elemento)<0)
				return this.dir.retornaArvoreDireita(elemento);
			else if(this.elem.compareTo(elemento)>0)
				return this.esq.retornaArvoreDireita(elemento);
			else
				return this.dir;
	}

	public ArvoreBinariaEncadeada<C> retornaArvoreEsquerda(C elemento) {
		if(this.elem.compareTo(elemento)>0)
			return this.esq.retornaArvoreEsquerda(elemento);
		else if(this.elem.compareTo(elemento)<0)
			return this.dir.retornaArvoreEsquerda(elemento);
		else
			return this.esq;
	}

	public int retornaComprimento(C origem, C destino) {
		if(this.elem.compareTo(origem)==0)
			return retornaComprimento(destino,0);
		else if(this.elem.compareTo(origem)>0)
			return this.esq.retornaComprimento(origem, destino);
		else return this.dir.retornaComprimento(origem, destino);
	}
	
	private int retornaComprimento(C destino,int pos){
		if(this.elem.compareTo(destino)==0)
			return pos;
		else if(this.elem.compareTo(destino)>0)
			return this.esq.retornaComprimento(destino, ++pos);
		return this.dir.retornaComprimento(destino, ++pos);
	}

	public int retornaGrau(C elemento) {
		if(this.elem.compareTo(elemento)==0){
			if (this.dir.retornaRaiz() == null && this.esq.retornaRaiz() == null)
				return 0;
			else if (this.dir.retornaRaiz() != null && this.esq.retornaRaiz() != null)
				return 2;
			else 
				return 1;
		} else if (this.elem.compareTo(elemento)<0)
			return this.dir.retornaGrau(elemento);
		return this.esq.retornaGrau(elemento);
		
	}

	public Iterator<C> retornaIteratorInOrdem() {
		return new IteratorInOrdem();
	}

	public Iterator<C> retornaIteratorPosOrdem() {
		return new IteratorPosOrdem();
	}

	public Iterator<C> retornaIteratorPreOrdem() {
		return new IteratorPreOrdem();
	}

	public C retornaPai(C elemento) {
		return retornaAnterior(elemento,this.elem,0);
	}
	
	private C retornaAnterior(C elemento, C anterior,int pos){
		if(this.elem.compareTo(elemento)==0){
			if (pos==0)
				return null;
			return anterior;
		}
		else if(this.elem.compareTo(elemento)<0)
			return this.dir.retornaAnterior(elemento, this.elem,++pos);
		else
			return this.esq.retornaAnterior(elemento, this.elem,++pos);
	}

	public C retornaRaiz() {
		return this.elem;
	}

	public boolean estaVazia() {
		if(numeroElementos()==0)
			return true;
		return false;
	}

	public void esvazie() {
		this.elem = null;
	}
	
	protected class IteratorPreOrdem implements Iterator<C>{
        private PilhaArray<ArvoreBinariaEncadeada<C>> pilha = new PilhaArray<ArvoreBinariaEncadeada<C>>();
        private int cont;
        
        public boolean hasNext() {
        	return ( ( elem!=null || !pilha.estaVazia() ) && cont<numeroElementos() );
        }

        public C next() {
            if (hasNext()){
            	cont++;
            	if(!pilha.estaVazia()){
            		ArvoreBinariaEncadeada<C> retornado = pilha.desempilha(); 
            		if (retornado.dir!=null)
            			if(retornado.dir.retornaRaiz()!=null)
            				pilha.empilha(retornaArvoreDireita(retornado.retornaRaiz()));
            		if (retornado.esq!=null)
            			if(retornado.esq.retornaRaiz()!=null)
            				pilha.empilha(retornaArvoreEsquerda(retornado.retornaRaiz()));
            		return retornado.retornaRaiz();
            		
            	} else {
            		if(!dir.estaVazia())
            			pilha.empilha(dir);
                	if(!esq.estaVazia())
                		pilha.empilha(esq);
                	return elem;
            	}
            }
            throw new NoSuchElementException();
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
	
	protected class IteratorPosOrdem implements Iterator<C>{
        private PilhaArray<Object> pilha = new PilhaArray<Object>();
       
        public IteratorPosOrdem(){
        	pilha.empilha(ArvoreBinariaEncadeada.this);
        }
        
        public boolean hasNext() {
        	return ( !pilha.estaVazia() );
        }

        @SuppressWarnings("unchecked")
		public C next() {
        	Object desempilhado = pilha.desempilha();
        	while(desempilhado instanceof ArvoreBinaria){
        		pilha.empilha(((ArvoreBinaria<C>)desempilhado).retornaRaiz());
            	if (!((ArvoreBinariaEncadeada<C>)desempilhado).dir.estaVazia())
            		pilha.empilha(((ArvoreBinariaEncadeada<C>)desempilhado).dir);
            	if (!((ArvoreBinariaEncadeada<C>)desempilhado).esq.estaVazia())
            		pilha.empilha(((ArvoreBinariaEncadeada<C>)desempilhado).esq);
            	desempilhado = pilha.desempilha();
            	
            }
        	
            return (C)desempilhado;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        
    }
	
	protected class IteratorInOrdem implements Iterator<C>{
        private PilhaArray<Object> pilha = new PilhaArray<Object>();
                
        public IteratorInOrdem(){
        	pilha.empilha(ArvoreBinariaEncadeada.this);
        }
        
        public boolean hasNext() {
        	return (!pilha.estaVazia());
        }

        @SuppressWarnings("unchecked")
		public C next() {
        	Object desempilhado = pilha.desempilha();
        	while(desempilhado instanceof ArvoreBinaria){
        		if (!((ArvoreBinariaEncadeada<C>)desempilhado).dir.estaVazia())
            		pilha.empilha(((ArvoreBinariaEncadeada<C>)desempilhado).dir);
            		
            	pilha.empilha((((ArvoreBinariaEncadeada<C>)desempilhado).retornaRaiz()));
            		
            	if (!((ArvoreBinariaEncadeada<C>)desempilhado).esq.estaVazia())
            		pilha.empilha(((ArvoreBinariaEncadeada<C>)desempilhado).esq);
            	desempilhado = pilha.desempilha();
            		
            }
        	
            return (C)desempilhado;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        
    }
}
