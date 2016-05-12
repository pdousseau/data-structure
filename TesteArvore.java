import java.util.Iterator;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TesteArvore extends TestCase{
	
	ArvoreAVL<String> arvore;
	ArvoreAVL<Integer> arvoreNumerica;
	
	@Override
	protected void setUp() throws Exception {
        super.setUp();
        this.arvore= new ArvoreAVL<String>();
        this.arvoreNumerica= new ArvoreAVL<Integer>();
    }
	
	public void testContem(){
		this.arvore.insere("macaco");
		this.arvore.insere("galinha");
		assertEquals(this.arvore.contem("macaco"),true);
		assertEquals(this.arvore.contem("girafa"),false);
	}
	
	public void testEhAncestral(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.ehAncestral("jumento", "foca"),true);
		assertEquals(this.arvore.ehAncestral("foca", "zebra"),false);
		assertEquals(this.arvore.ehAncestral("foca", "gaviao"),true);
	}
	
	
		
	public void testRetornaArvoreDireita(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		ArvoreAVL<String> arvoreDireita = new ArvoreAVL<String>();
		arvoreDireita.insere("lontra");
		arvoreDireita.insere("zebra");
		ArvoreAVL<String> novaArvore = this.arvore.retornaArvoreDireita("jumento");
		assertEquals(novaArvore.metodoEquals(arvoreDireita),true);
	}
	
	public void testRetornaArvoreEsquerda(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		ArvoreAVL<String> arvoreEsquerda = new ArvoreAVL<String>();
		arvoreEsquerda.insere("foca");
		arvoreEsquerda.insere("abelha");
		arvoreEsquerda.insere("gaviao");
		arvoreEsquerda.insere("burro");
		ArvoreAVL<String> novaArvore = this.arvore.retornaArvoreEsquerda("jumento");
		assertEquals(novaArvore.metodoEquals(arvoreEsquerda),true);
	}
	
	public void testRetornaPai(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.retornaPai("abelha"),"foca");
		assertEquals(this.arvore.retornaPai("gaviao"),"foca");
		assertEquals(this.arvore.retornaPai("zebra"),"lontra");
		assertEquals(this.arvore.retornaPai("jumento"),null);
	}
	
	public void testRaiz(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.retornaRaiz(),"jumento");
	}
	
	public void testRetornaComprimento(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.retornaComprimento("jumento", "gaviao"),2);
		assertEquals(this.arvore.retornaComprimento("jumento", "foca"),1);
	}
	
	public void testRetornaGrau(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.retornaGrau("jumento"),2);
		assertEquals(this.arvore.retornaGrau("abelha"),1);
		assertEquals(this.arvore.retornaGrau("gaviao"),0);
	}
	
	public void testRetornaElemento(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.retorna("jumento"),"jumento");
	}
	
	public void testRemove(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		this.arvore.remove("abelha");
		assertEquals(this.arvore.contem("abelha"),false);
		assertEquals(this.arvore.contem("burro"),false);
		assertEquals(this.arvore.contem("gaviao"),true);
	}
	
	public void testEsvazie(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		this.arvore.esvazie();
		assertEquals(this.arvore.contem("abelha"),false);
		assertEquals(this.arvore.contem("burro"),false);
		assertEquals(this.arvore.contem("gaviao"),false);
		assertEquals(this.arvore.contem("jumento"),false);
	}
	
	public void testIteratorPre(){
        this.arvoreNumerica.insere(64);
        this.arvoreNumerica.insere(30);
        this.arvoreNumerica.insere(98);
        this.arvoreNumerica.insere(3);
        this.arvoreNumerica.insere(37);
        this.arvoreNumerica.insere(71);
        this.arvoreNumerica.insere(107);
        Iterator<Integer> iterador = this.arvoreNumerica.retornaIteratorPreOrdem();
        assertEquals(iterador.hasNext(),true);
        assertEquals(iterador.next()+"","64");
        assertEquals(iterador.next()+"","30");
        assertEquals(iterador.next()+"","3");
        assertEquals(iterador.next()+"","37");
        assertEquals(iterador.next()+"","98");
        assertEquals(iterador.hasNext(),true);
        assertEquals(iterador.next()+"","71");  
        assertEquals(iterador.next()+"","107");
        while(iterador.hasNext())
            assertEquals(iterador.next()+"","107");
        assertEquals(iterador.hasNext(),false);
	}
	
	public void testIteratorPosOrdem(){
		this.arvoreNumerica.insere(64);
        this.arvoreNumerica.insere(30);
        this.arvoreNumerica.insere(98);
        this.arvoreNumerica.insere(3);
        this.arvoreNumerica.insere(37);
        this.arvoreNumerica.insere(71);
        this.arvoreNumerica.insere(107);
        Iterator<Integer> iterador = this.arvoreNumerica.retornaIteratorPosOrdem();
        assertEquals(iterador.hasNext(),true);
        assertEquals(iterador.next()+"","3");
        assertEquals(iterador.next()+"","37");
        assertEquals(iterador.next()+"","30");
        assertEquals(iterador.next()+"","71");
        assertEquals(iterador.next()+"","107");
        assertEquals(iterador.next()+"","98");
        assertEquals(iterador.next()+"","64");
 
       

	}
	
	
	public void testFatorB(){
		this.arvoreNumerica.insere(64);
        this.arvoreNumerica.insere(30);
        this.arvoreNumerica.insere(98);
        this.arvoreNumerica.insere(3);
        this.arvoreNumerica.insere(37);
        this.arvoreNumerica.insere(71);
        this.arvoreNumerica.insere(107);
        assertEquals(this.arvoreNumerica.fatorB(),0);
        this.arvoreNumerica.esvazie();
        this.arvoreNumerica.insere(42);
        this.arvoreNumerica.insere(15);
        this.arvoreNumerica.insere(88);
        this.arvoreNumerica.insere(67);
        this.arvoreNumerica.insere(94);
        this.arvoreNumerica.insere(51);
        assertEquals(this.arvoreNumerica.fatorB(),-2);
	}
	
	public void testIteratorIn(){
        this.arvoreNumerica.insere(64);
        this.arvoreNumerica.insere(30);
        this.arvoreNumerica.insere(98);
        this.arvoreNumerica.insere(3);
        this.arvoreNumerica.insere(37);
        this.arvoreNumerica.insere(71);
        this.arvoreNumerica.insere(107);
        Iterator<Integer> iterador = this.arvoreNumerica.retornaIteratorInOrdem();
        assertEquals(iterador.hasNext(),true);
        assertEquals(iterador.next()+"","3");
        assertEquals(iterador.next()+"","30");
        assertEquals(iterador.next()+"","37");
        assertEquals(iterador.next()+"","64");
        assertEquals(iterador.next()+"","71");
        assertEquals(iterador.hasNext(),true);
        assertEquals(iterador.next()+"","98");  
        assertEquals(iterador.next()+"","107");
       
        assertEquals(iterador.hasNext(),false);
	}
	
	public void testIteratorPre2(){
		arvore.insere("lontra");
		arvore.insere("zebra");
		Iterator<String> iterador = this.arvore.retornaIteratorPreOrdem();
		assertEquals(arvore.numeroElementos(),2);
        assertEquals(iterador.hasNext(),true);
        assertEquals(iterador.next(),"lontra");
        assertEquals(iterador.next(),"zebra");
	}

	
	public void testAltura(){
		this.arvore.insere("jumento");
		this.arvore.insere("foca");
		this.arvore.insere("lontra");
		this.arvore.insere("abelha");
		this.arvore.insere("gaviao");
		this.arvore.insere("burro");
		this.arvore.insere("zebra");
		assertEquals(this.arvore.retornaAltura(),3);
	}
	
	
	
	public static void main (String[] args){
        TestSuite suite = new TestSuite(TesteArvore.class);
        junit.textui.TestRunner.run(suite);
    }
}
